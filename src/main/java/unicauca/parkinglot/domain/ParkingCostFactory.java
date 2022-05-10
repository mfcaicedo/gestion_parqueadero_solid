/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.domain;

import java.util.Map;
import unicauca.parkinglot.access.RepositoryFactory;

/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas 
 */
public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    // Singleton
    private static ParkingCostFactory instance;
    
    /**
    * Devuelve la instancia de la clase
    * @return instancia unica de la la fábrica de repositorio 
    */
    
//    private static VehicleFactory(){
//        
//    }
//
//    public static ParkingCostFactory getInstance() {
//        if (instance == null) {
//            instance = new ParkingCostFactory();
//        }
//        return instance;
//    }
//    public static getParkingCost(Vehicle vehicle){
//        
//    }
    
    /**
     *     public double calculateDeliveryCost(Order order) {

        if (order == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery  
        IDelivery delivery = Factory.getInstance().getDelivery(order.getCountry());
        double result = delivery.calculateCost(order);

        return result;

    }
     */
    
    
}
