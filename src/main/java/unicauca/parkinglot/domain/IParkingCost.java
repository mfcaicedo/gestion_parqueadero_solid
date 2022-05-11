package unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Milthon F Caicedo 
 */
public interface IParkingCost {
    
    public long calculateCost(LocalDateTime input, LocalDateTime output );
}
