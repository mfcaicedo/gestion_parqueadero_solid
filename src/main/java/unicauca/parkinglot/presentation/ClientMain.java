/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.presentation;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



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
        
//       ParkingTest test = new ParkingTest(); 

        double valor = 4750;
        Math.ceil(valor);
        System.out.println("aproximacion: "+ ((long)Math.ceil(valor/100))*100);

        double numero = 0;
        double n = 4; 
        double n1 = 5; 
        numero = n/n1;
        System.out.println("numero: "+ numero);
        
        
    }
    
}
