/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgeCalculator;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Aireen
 */
public class AgeCalculator2 {
    // Calculate age, given the date of birth

    
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
    
        int year = 2003;
        int month = 5;
        int dayOfMonth = 7;
        LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);

        // Period.between(startDateInclusive, endDateExclusive);
        int age = Period.between(birthDate, today).getYears();
        
        System.out.println("You are " + age + " years old");
    }
}
