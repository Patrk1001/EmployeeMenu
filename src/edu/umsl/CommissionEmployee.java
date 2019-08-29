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
public class CommissionEmployee extends EmployeeFile{

 @Override
 protected void computeGross()
    {
        int itemsSold;
        double salePrice= 50.00;
        double commissionRate=.50;
        double commission=0;

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number of items sold: ");

         itemsSold=sc.nextInt();
         System.out.println("Enter unit of sales price sold: ");
         salePrice = sc.nextInt();
         if(itemsSold >=1)
                 commission= (itemsSold*salePrice*commissionRate);
         gross=commission;
             System.out.println("The gross is:" + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(gross));
     
    }
    
}
