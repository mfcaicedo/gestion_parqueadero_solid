/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author HP
 */
public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
        
        /**
         *Los carros pagan un valor fijo de $4.000 por cada hora. Si el vehículo estuvo menos de
          una hora, se cobra un valor de $2.000. Después de la primera hora, pagará una tarifa
          de 2.000 la hora o su fracción (regla de tres simple). Por ejemplo, si estuvo dos horas y
          10 minutos, pagaría: 4.000 + 2.000 + 333 = 6333 = $6400 (por el redondeo)
         */
        
        float valorHora = 4000;
        float valorCobro = 0;
        int minutosInput = input.getMinute();
        int minutosOutput = output.getMinute();
        int totalMinutos = 0; 
        
        if( input.getDayOfMonth() == output.getDayOfMonth() ){
            //validación si es menor a una hora 
            if( (output.getHour() - input.getHour()) == 0 ){
                valorCobro = 2000;
            }else if( (output.getHour() - input.getHour()) == 1 ){
               totalMinutos = (60 - minutosInput) + minutosOutput;
               if(totalMinutos < 60){
                   valorCobro = 2000;
                   //luego seguimos desde aquí 
               }
            }
        }
        
        
        
        return 0;
    }
    
}
