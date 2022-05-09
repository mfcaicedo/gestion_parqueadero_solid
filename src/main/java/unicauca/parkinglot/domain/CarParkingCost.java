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
 * @author Milthon Ferney Caicedo 
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

        long totalMinutos = 0; 
        totalMinutos = ChronoUnit.MINUTES.between(input, output);
        if(totalMinutos >= 60){
            return (2000 + ((2000)/(60)) * totalMinutos);
        }else{
            return 2000;
        }
        
//        long valorCobro = 0;
//        int minutosInput = input.getMinute();
//        int minutosOutput = output.getMinute();
//        int totalMinutos = 0; 
//        int auxHorasMinutos = 0;
//        
//        if( input.getDayOfMonth() == output.getDayOfMonth() ){
//            //validación si es menor a una hora 
//            if( (output.getHour() - input.getHour()) == 0 ){
//                valorCobro = 2000;
//            }else if( (output.getHour() - input.getHour()) == 1 ){
//               totalMinutos = (60 - minutosInput) + minutosOutput;
//               if(totalMinutos < 60){
//                   valorCobro = 2000;
//                    //totalMinutos = 61   -> 1 
//               }else{
//                   int auxMinutos = totalMinutos - 60;
//                   valorCobro = 4000 + (2000*auxMinutos)/(60); 
//               }
//            }else{
//                // 18 - 6 = 12 == 720 minutos (por si algo revisar los segundos)
//            //   auxHorasMinutos = ((output.getHour() - input.getHour()) - 1)* 60 +((60) minutosInput + minutosOutput );
//                valorCobro = 4000 + (((2000)/(60))*(auxHorasMinutos)); 
//            }
//        }else{
//            //Eje: 2 dias    7am   out 5am del siguiente ia  
//            //00:00 am  hasta 24:00 pm 
//            /**
//             * Input = 5/05/2022 7:05 am  
//             * output = 8/05/2022 10:03 am
//             * 2 dias y 22horas  70horas y 8 minutos 
//             */
//            int numDias = output.getDayOfMonth() - input.getDayOfMonth();
//            
//            if(output.getHour() < input.getHour()){
//                
//                
//                
//            }else{
//         //       auxHorasMinutos = ((numDias * 24) * 60 + () ( minutosInput + minutosOutput )) - 60;
//                valorCobro = 4000 + ((2000)/(60)*(auxHorasMinutos)); 
//                
//            }
//           
//            int auxHoras1 = ((24 - input.getHour()) + output.getHour() ) * 60 ;
//            int auxHotas2 = 0;
//        }
        
       // return valorCobro;
    }
    
}
