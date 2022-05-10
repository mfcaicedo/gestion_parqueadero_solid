/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import unicauca.parkinglot.access.IVehicleRepository;
import unicauca.parkinglot.access.RepositoryFactory;
import unicauca.parkinglot.access.VehicleRepository;
import unicauca.parkinglot.domain.IParkingCost;
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
     * Calcular costo de entrega
     * @param order orden sobre la cual se calcula el costo de entrega
     * @return costo de entrega
     *
    public double calculateDeliveryCost(Order order) {

        if (order == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery  
        IDelivery delivery = Factory.getInstance().getDelivery(order.getCountry());
        double result = delivery.calculateCost(order);

        return result;
    }
     */
    
    /**
     * 
     * @param vehicle
     * @param input
     * @param output
     * @return 
     */
    public long calcularParkingCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output){
        System.out.println("vehicle: "+ vehicle.getType());
        if(vehicle == null){
            return -1;
        }
        IParkingCost parkingCost = RepositoryFactory.getInstance().getParkingCost(vehicle.getType());
        System.out.println("resultado : "+ parkingCost);
        long result = parkingCost.calculateCost(input, output);
        System.out.println("result: "+ result);
        
        return result;
    }
    public void saveVehicle(Vehicle vehicle){
        
        if(vehicle != null){
            repository.saveProduct(vehicle);
        }
        
    }
    public List<Vehicle> lstVehicles(){
        
        return repository.listVehicles();
        
    }
}
