
package unicauca.parkinglot.domain.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import unicauca.parkinglot.access.IVehicleRepository;
import unicauca.parkinglot.access.RepositoryFactory;
import unicauca.parkinglot.domain.TypeEnum;
import unicauca.parkinglot.domain.Vehicle;
import unicauca.parkinglot.domain.service.Service;

/**
 *
 * @author Milthon F Caicedo, Brandon Bohórquez
 */
public class ParkingTest {
     
    /**
     * Pruebas moto 
     */
    @Test
    public void MotosTest() {
        System.out.println("Moto hora y media");
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.MOTO);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 17, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 18, 30);
        IVehicleRepository repo = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        long expResult = 2500L;
        long result = service.calcularParkingCost(veh, input, output);
        System.out.println("valor: "+ result);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Moto menos una hora");
        output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 17, 45);
        expResult = 1000L;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Moto 3 horas y 45 minutos");
        input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 11, 45);
        expResult = 4800L;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
    }
    @Test
    public void CarTest(){
        System.out.println("Carro 2 horas y 10 minutos");
        Vehicle veh = new Vehicle("FTK-123", TypeEnum.CAR);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 10, 10);
        IVehicleRepository repo =
        RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        long expResult = 6400L;
        long result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Carro menos una hora");
        output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 45);
        expResult = 2000L;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Carro 1 horas y 30 minutos");
        input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 9, 30);
        expResult = 5000L;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
    }
    
    @Test
    public void TruckTest() {
        System.out.println("Camion menos de 12 horas");
        Vehicle veh = new Vehicle("JNK-838", TypeEnum.TRUCK);
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 13, 0);
        IVehicleRepository repo =
        RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        long expResult = 10000L;
        long result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Camión mas de 12 horas");
        input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 22, 0);
        expResult = 15000L;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
        System.out.println("Camión 3 dias y una hora");
        input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        output = LocalDateTime.of(2021, Month.FEBRUARY, 25, 9, 0);
        expResult = 45700;
        result = service.calcularParkingCost(veh, input, output);
        assertEquals(expResult, result);
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%\n");
        }
    }
    
    @Test
    public void PersistenceTest() {
        System.out.println("Guardar y listar");
        Vehicle veh = new Vehicle("QET-646", TypeEnum.MOTO);
        IVehicleRepository repo =
        RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repo);
        service.saveVehicle(veh);
        veh = new Vehicle("NBV-987", TypeEnum.CAR);
        service.saveVehicle(veh);
        veh = new Vehicle("IJY-987", TypeEnum.TRUCK);
        service.saveVehicle(veh);
        List<Vehicle> list = service.listVehicles();
        /**
         *Impresión de los vehiculos guardados en la base de datos 
        */
        System.out.println("LISTA DE VEHÍCULOS QUE SE ENCUENTRAN EN EL PARQUEADERO");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("placa: "+ list.get(i).getPlaca());
            System.out.println("tipo: "+ list.get(i).getType());
        }
        long expResult = 3L;
        long result = service.listVehicles().size();
        assertEquals(expResult, result);
        assertEquals("QET-646", service.listVehicles().get(0).getPlaca());
        if(result == expResult){
            System.out.println("Prueba superada con éxito de un 100%");
        }
    }
    
    
}
