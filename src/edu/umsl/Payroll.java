package edu.umsl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 *
 */
public class Payroll {

    boolean load;
    double balance;
    static Scanner sc = new Scanner(System.in);
    EmployeeFile[] myaccts = new EmployeeFile[3];// creates array with 3 account numbers

    public static void main(String[] args) throws IOException {
        Payroll pay = new Payroll();
        pay.transactionMenu();
        //pay.saveEmployees();//Must load first before selecting
    }

    public void transactionMenu() throws IOException {//employee should be in payroll
        System.out.println("1) Populate employees");//first populate employee
        System.out.println("2) Select employees");//second, you can select employee
        System.out.println("3) Save employees");//save, employee
        System.out.println("4) Load employees");//then, you can load, then select employees to see saved data
        System.out.print("Please enter a number: ");
        int num1 = sc.nextInt();
        if (num1 == 1 && load == false) {
            populateEmployees();
        } else if (num1 == 2) {
            selectEmployee();
        } else if (num1 == 3) {
            saveEmployee();
        } else if (num1 == 4) {
            loadEmployees();
        } else if (num1 == 1 && load == true) {
            System.out.println("Account loaded. Pick a different number");
            transactionMenu();
        }
    }

    public void populateEmployees() throws IOException {
        //int gross;
        
        for (int i = 0 ; i < myaccts.length; i++) {
            System.out.println("|==================================|");
            System.out.println("|           Company Name           |");
            System.out.println("|***********Populate Employees*****|");
            System.out.println("|__________________________________|");
            System.out.println("| Enter 1 For Hourly Employee      |");
            System.out.println("| Enter 2 For Salary Employee      |");
            System.out.println("| Enter 3 For Comission Employee   |");
            System.out.println("|   Please Make Selection Now...   |");
            System.out.println("|==================================|");
            int id = sc.nextInt();// assigns to each array number [0],[1],[2]
            if (id == 1) {
                i = id - 1;
                myaccts[i] = new HourlyEmployee();

                String nm = "1";
                myaccts[i].setID(nm);
                //System.out.print("How many hours do you work per week? :");
                //System.out.print("What is your pay rate?: ");
            } else if (id == 2) {
                //int num;
                i = id - 1;
                myaccts[i] = new SalaryEmployee();
                String nm = "2";
                myaccts[i].setID(nm);
            } else if (id == 3) {
                i = id - 1;
                myaccts[i] = new CommissionEmployee();
                String nm = "3";
                myaccts[i].setID(nm);
                //System.out.print("How many items sold?: ");
                //System.out.print("What is the unit price of items sold?: ");
            } else if (id == 0) {
                break; // remember to correct this with the right code
            }

            try {

                //myaccts[i] = new EmployeeFile(intiDeposit, id);// creates acount with [0],[1],[2]
            } catch (InputMismatchException ioe) {
                System.out.println("\nInvalid Entry\n");
            }

        }
        transactionMenu();
    }

    public void selectEmployee() throws IOException {//like lookupStudents
        System.out.println("Please choose an employee");
        System.out.println("0) Hourly Employee");
        System.out.println("1) Salary Employee");
        System.out.println("2) Commission Employee");
        int secondinput = sc.nextInt();
        if (secondinput == 0) {
            myaccts[secondinput].getID();
            displayMenu(secondinput);
        } else if (secondinput == 1) {
            myaccts[secondinput].getID();
            displayMenu(secondinput);
        } else if (secondinput == 2) {
            myaccts[secondinput].getID();
            displayMenu(secondinput);//secondinput passes to displayMenu()
        }
        // int index = -1;
    }
    // for(int i = 0; i < myaccts.length; i++)

    public void displayMenu(int arg_input) throws IOException {
        //int secondinput;
//                          if(myaccts[i].getID().equalsIgnoreCase(secondinput))
//                          {
//                          index=i;
        int num;
        do {
            System.out.println("Please select the following");
            System.out.println("1) Calculate Gross pay");
            System.out.println("2) Calculate Tax");
            System.out.println("3) Calculate Net pay");
            System.out.println("4) Calculate Net percent");
            System.out.println("5) Display all");
            System.out.println("6) Go back to the main menu");
            num = sc.nextInt();
            if (num == 1) {
                myaccts[arg_input].computeGross();
            } else if (num == 2) {
                myaccts[arg_input].computeTax();
            } else if (num == 3) {
                myaccts[arg_input].computeNet();
            } else if (num == 4) {
                myaccts[arg_input].computeNetperc();
            } else if (num == 5) {
                myaccts[arg_input].displayEmployee();
                }
                else if(num==6){
                    transactionMenu();
                }    
           
                
            
        } while (num != -99);
        
        
    }

    
    
    
    
    public void saveEmployee() {
        FileOutputStream outStream = null;
        ObjectOutputStream os = null;
        System.out.println("Employee saved");
        
        try {
            outStream = new FileOutputStream("employee.txt");// creates file
            os = new ObjectOutputStream(outStream);
            os.writeObject(myaccts);// saves array of accounts
            os.flush();
            os.close();
            Scanner sc = new Scanner(System.in);
            System.out.println("Which employee would you like to save? [0)Hourly, 1)Salary, 2)Commission] " );
            String input4 = sc.nextLine();
            
            PrintWriter writer;
            //writer = new PrintWriter("Employee.txt", "UTF-8");
            writer = new PrintWriter(input4, "UTF-8");
            for(int i = 0; i < myaccts.length; i++)
           
            {
                writer.println("Count: " + (i+1));
                writer.println("Name: " + 1 );
                writer.println("Gross: " + 2);
                writer.println("Net: " + 3);
                writer.println("Net%: " + 4);
                writer.println("-----------");
            }
            System.out.println("File saved.  ");
            writer.close();
           
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
    private void loadEmployees() throws FileNotFoundException, IOException {
        FileInputStream inStream = null;
        ObjectInputStream is = null;
        int input;
        load = true;
        System.out.println("Account File loaded");
        try {
            inStream = new FileInputStream("employee.txt");// creates file
            is = new ObjectInputStream(inStream);
            myaccts = (EmployeeFile[]) is.readObject();// reads account array

            is.close();
            
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
        
        transactionMenu();
    }
    
  
    
}
