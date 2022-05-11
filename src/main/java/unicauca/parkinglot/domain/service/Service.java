package unicauca.parkinglot.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import unicauca.parkinglot.access.IVehicleRepository;
import unicauca.parkinglot.access.RepositoryFactory;
import unicauca.parkinglot.access.VehicleRepository;
import unicauca.parkinglot.domain.IParkingCost;
import unicauca.parkinglot.domain.ParkingCostFactory;
import unicauca.parkinglot.domain.Vehicle;

/**
 *
 * @author Milthon F Caicedo 
 */
public class Service {
    /**
     * Atributos 
     */
    IVehicleRepository repository;
    public Service(IVehicleRepository repository){
        this.repository = repository;
    }
    /**
     * Según el tipo de vehículo llama a su respectiva clase para que calcule el costo 
     * por el uso del parqueadero. 
     * @param vehicle es el objeto de vehículo.
     * @param input fecha de entrada 
     * @param output fecha de salida
     * @return result total a pagar por el uso del parqueadero.
     */
    public long calcularParkingCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output){
        if(vehicle == null){
            return -1;
        }
        IParkingCost parkingCost = ParkingCostFactory.getInstance().getParkingCost(vehicle.getType());
        long result = parkingCost.calculateCost(input, output);
        return result;
    }
    public void saveVehicle(Vehicle vehicle){
        if(vehicle != null){
            repository.saveProduct(vehicle);
        }
    }
    /**
     * Lista de vehículos del parqueadero público 
     * @return lista de vehículos
     */
    public List<Vehicle> listVehicles(){
        return repository.listVehicles();
    }
}
