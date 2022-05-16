package unicauca.parkinglot.access;

import java.util.EnumMap;
import java.util.Map;
import unicauca.parkinglot.domain.CarParkingCost;
import unicauca.parkinglot.domain.IParkingCost;
import unicauca.parkinglot.domain.MotoParkingCost;
import unicauca.parkinglot.domain.TruckParkingCost;
import unicauca.parkinglot.domain.TypeEnum;

/**
 *
 * @author Milthon F Caicedo
 */
public class RepositoryFactory {
   private Map<TypeEnum, IParkingCost> vehicleDictionary;
    // Singleton
    private static RepositoryFactory instance;
    private RepositoryFactory() {
        
    }
    /**
     * Devuelve la instancia de la clase
     * @return instancia unica de la la fábrica de repositorio 
     */
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    /**
     * Retorna el respositorio del vehículo de la fabrica. 
     * @param tipo
     * @return IVehicleRepository
     */
    public IVehicleRepository getRepository(String tipo){
        if(tipo.equals("default")){
            
           IVehicleRepository respository = new VehicleRepository(); 
            return respository;
        }
        return null; 
    }
}
