/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.presentation;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unicauca.parkinglot.access.IVehicleRepository;
import unicauca.parkinglot.access.RepositoryFactory;
import unicauca.parkinglot.domain.TypeEnum;
import unicauca.parkinglot.domain.Vehicle;
import unicauca.parkinglot.domain.service.Service;


/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas Bohórquez
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 19, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo); //Inyección de dependencias
        long result = service.calcularParkingCost(veh, input, output);
        System.out.println("Valor a pagar por la moto: " + result);
        service.saveVehicle(veh);
        veh = new Vehicle("JNK-124", TypeEnum.CAR);
        service.saveVehicle(veh);
        List<Vehicle> list = service.listVehicles();
        list.forEach(vehicle -> {
        System.out.println("Vehicle{ Placa: " + vehicle.getPlaca() + "," + "Tipo: " + vehicle.getType() + "}");
        });
        
        //Pruebas 
       //ParkingTest test = new ParkingTest(); 
    }
    
}