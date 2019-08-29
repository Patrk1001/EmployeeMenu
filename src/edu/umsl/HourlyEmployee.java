/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author patrick
 */
public class HourlyEmployee extends EmployeeFile {      


        @Override
        protected void computeGross()
        {
         
           Scanner sc= new Scanner(System.in);
           System.out.println("Please enter amount of hours: ");
           hours = sc.nextInt();
           System.out.println("Enter your rate: ");
           rate = sc.nextInt();
           if ( hours > 40 )

           {

               double extraHours = hours - 40;

             gross = ( 40 * rate ) + ( extraHours * rate * 1.5);

           }

           else {
               gross = hours * rate;
           

              System.out.println("The gross is:" + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(gross));

                 }}}



    


           