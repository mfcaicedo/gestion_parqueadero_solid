package unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;
import unicauca.parkinglot.access.RepositoryFactory;

/**
 * @author Milthon F Caicedo, Brandon Nicolas 
 */
public class ParkingCostFactory {
    private Map<TypeEnum, IParkingCost> dictionary;
    // Singleton
    private static ParkingCostFactory instance;
    private ParkingCostFactory(){
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
    }
    
    //Pregunta para mañana 
    private static void VehicleFactory(){
       
    }
    /**
    * Devuelve la instancia de la clase
    * @return instancia unica del ParkingCostFactory 
    */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    /**
     * Para un determinado tipo de vehículo determina la clase que se encarga de calcular el costo
     * por el uso del parqueadero.
     * @param tipo es el tipo de dato de vehículo (car, moto, etc
     * @return IParkingCost 
     */
    public IParkingCost getParkingCost(TypeEnum tipo) {
        IParkingCost result = null;
        if (dictionary.containsKey(tipo)) {
            result = dictionary.get(tipo);
        }
        return result;
    }   
    
}
