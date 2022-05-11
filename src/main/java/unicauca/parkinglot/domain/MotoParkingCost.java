/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Milthon F Caicedo 
 */
public class MotoParkingCost implements IParkingCost {

    /**
     * 
     * @param input
     * @param output
     * @return 
     */
    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
 
        /**
         * 2mil -> 60 minutos = 1 hora 
         * mil -> minutos menor a 60  es decir 1 hora 
         * mas de una hora se le cobra mil pesos. 
         */
        
        double costo = 1000; 
        long totalMinutos = 0; 
        totalMinutos = ChronoUnit.MINUTES.between(input, output);
        if(totalMinutos < 60){
            return 1000;
        }else{
            double total = (Math.ceil(( 1000 + (costo)/(60) * totalMinutos )/(100))) * 100;
            return (long)total; 
        }
        
        
    }
     
}
