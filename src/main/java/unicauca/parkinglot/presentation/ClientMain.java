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
        
        /**
         * Pruebas
         * 
         */
        
        LocalDateTime fromDateTime = LocalDateTime.of(2021, Month.FEBRUARY, 22, 8, 0);
        LocalDateTime toDateTime = LocalDateTime.of(2021,  Month.FEBRUARY, 25, 9, 15);

        LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );

        long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears( years );

        long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths( months );

        long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( days );


        long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( hours );

        long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes( minutes );

        long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);
        
        
        long minutes2 = ChronoUnit.MINUTES.between(fromDateTime, toDateTime);
        System.out.println("minutos: " + minutes2);
        
        System.out.println( years + " years " + 
        months + " months " + 
        days + " days " +
        hours + " hours " +
        minutes + " minutes " +
        seconds + " seconds.");

    }
    
}
