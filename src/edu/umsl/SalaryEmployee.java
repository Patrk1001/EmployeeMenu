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
public class SalaryEmployee extends EmployeeFile{
    @Override
    protected void computeGross()
        	{
                    Scanner sc = new Scanner(System.in);
                int g = 0;
                System.out.println("Are you 1) Staff or 2) Executive: ");
                g= sc.nextInt();
		if(g==1){
                gross=50000;   
                System.out.println("The gross is:" + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(gross));
                }
                else if(g==2){
                gross=100000; 
               System.out.println("The gross is:" + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(gross)); 
                }
       
	}
    
    
}
