package unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Milthon Ferney Caicedo 
 */
public class CarParkingCost implements IParkingCost {

    /**
     * 
     * @param input
     * @param output
     * @return 
     */
    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
        
        /**
         *Los carros pagan un valor fijo de $4.000 por cada hora. Si el vehículo estuvo menos de
          una hora, se cobra un valor de $2.000. Después de la primera hora, pagará una tarifa
          de 2.000 la hora o su fracción (regla de tres simple). Por ejemplo, si estuvo dos horas y
          10 minutos, pagaría: 4.000 + 2.000 + 333 = 6333 = $6400 (por el redondeo)
         */

        long totalMinutos = 0; 
        double costo = 2000; 
        totalMinutos = ChronoUnit.MINUTES.between(input, output);
        if(totalMinutos >= 60){
            double totalPago = Math.ceil((2000 + ((costo)/(60)) * totalMinutos)/100) * 100;
            return (long)totalPago;
        }else{
            return 2000;
        }
    }
    
}
