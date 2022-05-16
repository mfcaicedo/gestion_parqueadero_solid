package unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Milthon Ferney Caicedo 
 */
public class CarParkingCost implements IParkingCost {
    /**
     * Calcula el costo por el uso del parqueadero del vehículo tipo CAR. 
     * @literal 
     * Los carros pagan un valor fijo de $4.000 por cada hora. Si el vehículo estuvo menos de
     * una hora, se cobra un valor de $2.000. Después de la primera hora, pagará una tarifa
     * de 2.000 la hora o su fracción (regla de tres simple). Por ejemplo, si estuvo dos horas y
     * 10 minutos, pagaría: 4.000 + 2.000 + 333 = 6333 = $6400 (por el redondeo)
     * @param input fecha de entrada del vehículo 
     * @param output fecha de salida del vehículo 
     * @return costo total a pagar por el uso del parqueadero. 
     */
    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
        
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
