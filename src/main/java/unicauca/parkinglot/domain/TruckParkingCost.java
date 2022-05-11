package unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Milthon F Caicedo 
 */
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
        
         /*
        * 15mil = 24 horas = 1440 minutos 
        * 10mil <= 12 horas = 720 minutos 
        * luego de 24 horas pagará 15mil por día 
        * y por las horas restantes 
        */
        long totalMinutos = 0; 
        double costo = 15000;
        totalMinutos = ChronoUnit.MINUTES.between(input, output);
        if(totalMinutos <= 720){
            return 10000;
        }else if (totalMinutos > 720 && totalMinutos <= 1440){
            return 15000;
        }else{ // > 24 horas 
            System.out.println("total minutos: "+totalMinutos);
            double totalPago = Math.ceil(((costo/1440) * totalMinutos)/100) * 100;
            return (long)totalPago;
        }
    }
    
}
