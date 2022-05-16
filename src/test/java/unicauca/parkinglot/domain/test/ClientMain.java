package unicauca.parkinglot.domain.test;
/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas Bohórquez
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       ParkingTest test = new ParkingTest(); 
       test.MotosTest();
       test.CarTest();
       test.TruckTest();
       test.PersistenceTest();
           
    }
}
