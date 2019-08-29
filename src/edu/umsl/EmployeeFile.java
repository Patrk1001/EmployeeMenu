
package edu.umsl;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 *
 */
public class EmployeeFile implements Serializable {

    static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//allows to serialize variable id...this class is for calculating and display

    static Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    protected double rate;
    protected double taxrate;
    protected int hours;
    protected double gross;
    protected double tax;
    protected double net;//protected, because it is related to the override method, otherwise private if no override
    protected double net_percent;
    protected String id;
    static Scanner sc = new Scanner(System.in);
    
  
    
//use setters and getters?
    public EmployeeFile(){
       rate = 30.0;
       taxrate = 0.2;
       hours = 40;
       gross = 0;
       tax=0;
       net=0;
       net_percent=0;
    }
    
    public EmployeeFile(String ID) 
    {
        this.id=ID;
    }
    public String getID()//getId to get it, use public String
        {
            return id;
        }
        
	public void setID(String s){//set, use public void, also need to pass it(String s)
		id = new String(s);
	}
   

    protected void computeGross()//let gross do the work
        	{ 
		gross=rate*hours;
	}

	public void computeTax() 
{ 
		tax =gross*taxrate;
                System.out.println("This is tax "+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(tax));
	}

	public void computeNet()
 { 
		net=gross-tax;
                System.out.println("This is net gross " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(net));
	}

	public void computeNetperc() 
{               
		net_percent=(net/gross)*100;
                System.out.println("This is net percent: " +net_percent+ "%");
	}
	
	public void displayEmployee() //print ID to  transfer ID to input to override to salary employee
{            
    
                //call calculations here
                System.out.println("This is your current rate");
		System.out.println("Hours: " + hours);
		System.out.println("Rate: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(rate)+ " per hour");
		System.out.println("Gross: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(gross));
		System.out.println("Net gross: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(net));
		System.out.println("Net percent: " + net_percent + "%");
	}
        
public void goBackToMainMenu(){
    
    
}
        
} 	


