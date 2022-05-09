package unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author HP
 */
public class TruckParkingCost implements IParkingCost {

    @Override
    public long calculateCost(LocalDateTime input, LocalDateTime output) {
        
        LocalDateTime tempDateTime = LocalDateTime.from( input );

        long dias = tempDateTime.until( output, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( dias );

        long horas = tempDateTime.until( output, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( horas );

        long minutos = tempDateTime.until( output, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes( minutos );

        long totalMinutos = 0; 
        
        /*
        * 15mil = 24 horas = 1440 minutos 
        * 10mil <= 12 horas = 720 minutos 
        * luego de 24 horas pagará 15mil por día 
        * y por las horas restantes 
        */
        
        
        if(dias > 0){
           totalMinutos = (dias*24) * 60;
           if (horas >0)
               totalMinutos += horas*60;
           if(minutos > 0 )
               totalMinutos += minutos;
            return (2000 + ((2000)/(60)) * totalMinutos);
        
        }else if (horas > 0 ){
           totalMinutos += horas*60;
           if(minutos > 0 )
                totalMinutos += minutos;
            return (2000 + ((2000)/(60)) * totalMinutos);
        
        }else if(minutos > 0){
            return 2000;
        }
        
        return 0;
    }
    
}
