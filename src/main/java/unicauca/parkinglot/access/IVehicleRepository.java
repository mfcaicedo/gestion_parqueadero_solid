package unicauca.parkinglot.access;

import java.util.List;
import unicauca.parkinglot.domain.Vehicle;

/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas 
 */
public interface IVehicleRepository {
    public boolean saveProduct(Vehicle newVehicle);
    public List<Vehicle> listVehicles();
}
