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
        vehicleDictionary = new EnumMap<>(TypeEnum.class);
        vehicleDictionary.put(TypeEnum.CARRO, new CarParkingCost());
        vehicleDictionary.put(TypeEnum.CAMION, new TruckParkingCost());
        vehicleDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        // Si se requie otto tipo de vehículo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica de repositorio 
     */

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    /**
     * Para un determinado tipo de vehículo determina la clase que se encarga de calcular el costo del
     * por el uso del parqueadero.
     *
     * @param tipo
     * @return IParkinCost
     */
    public IParkingCost getParkingCost(TypeEnum tipo) {

        IParkingCost result = null;

        if (vehicleDictionary.containsKey(tipo)) {
            result = vehicleDictionary.get(tipo);
        }

        return result;

    }
}
