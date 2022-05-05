/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicauca.parkinglot.presentation;

import java.time.LocalDateTime;
import java.time.Month;
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
        
        LocalDateTime input = LocalDateTime.of(2021, Month.FEBRUARY, 22, 17, 0);   
        
        LocalDateTime output = LocalDateTime.of(2021, Month.FEBRUARY, 22, 18, 30);
        
        System.out.println("input: " + input);
        System.out.println("hora: " + input.getHour());
        System.out.println("minutos: " + input.getMinute());
        //System.out.println("float: " + input.getLong());
        
    }
    
}
