
package lab03a;
import javax.swing.*;
import java.text.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class BasicMethodsLab {

  public static void main( String args[] ) {

        String propertyCostStr;       // Value entered by user; string type
        String downPaymentStr;        // Value entered by user; string type
        String numberOfYearsStr;      // Value entered by user; string type
                
        double propertyCost;          // The double form of the user-entered property cost
        double downPayment = 0;       // The double form of the user-entered down payment
        double loanAmount = 0;        // The calculated price of the loan amount
        double monthlyPayment;	  //The monthly loan payment
        double annualInterestRate = 6.5;  //The annual interest rate
        int response = 0;             // The user's response as to whether to continue
               
        String s = ""; // purpose for reading char input 
        char propertyType;
        DecimalFormat f = new DecimalFormat("##.##"); //Formatting 2 decimal places for outputs                   
        
       // int numberOfYears = 15;	  //integer form of the user-entered down payment
        int numberOfYears = 0;
        
        // Initialize the output string to the empty string
        String outputStr = "";
                                        
        while (true) {
            
         //************************************************************************************************************
          //if else statement holding char value of inputs
          s=JOptionPane.showInputDialog("R = Residential, C = Commercial and A = Agricultural \n" +
                  " Enter ONLY a single character of R, C or A  for property type: ");  
         propertyType=s.charAt(0);  
         
         if(propertyType == 'R' ||propertyType == 'r')
             outputStr = outputStr + "Type:  Residential";
        //  System.out.println("Type:  Residential: "+ propertyType);  
         
         else if(propertyType == 'C'||propertyType == 'c')
             outputStr = outputStr + "Type:  Commercial";
        // System.out.println("Type:  Commercial: "+ propertyType);  
         
         else if(propertyType == 'A'||propertyType == 'a')
             outputStr = outputStr + "Type:  Agricultural";
         //System.out.println("Type:  Agricultural: "+ propertyType);  
         //************************************************************************************************************
            // Read in property cost from user as a string
            propertyCostStr = JOptionPane.showInputDialog("Enter property cost");
                           
            // Convert from type String to type double
            propertyCost = Double.parseDouble(propertyCostStr);
            
            // Read in down payment from user as a string
            downPaymentStr = JOptionPane.showInputDialog("Enter down payment");
            
            // Convert from type String to type double
            downPayment = Double.parseDouble(downPaymentStr);
            
            // Read in number of years from user as a string
            numberOfYearsStr = JOptionPane.showInputDialog("Enter number of years for loan:");
            
            // Convert from type String to type integer
            numberOfYears = Integer.parseInt(numberOfYearsStr);
            
            // Echo print the entered values
            outputStr = outputStr  +", Cost: " + String.format("%.2f", propertyCost)   + ", ";
            //outputStr = outputStr + "Down Payment: " + downPayment + " ";
            
            // Calculate loan amount for the propertyS
            loanAmount = propertyCost - downPayment;
            outputStr = outputStr + "Loan Amount: " + String.format("%.2f", loanAmount);
            
            // Calculate monthly payment
            // Change the annual interest rate to a decimal (/100) and a monthly rate (/12)
            monthlyPayment = loanAmount * (annualInterestRate/1200) /
                    (1 - 1 / Math.pow(1 + (annualInterestRate/1200), numberOfYears * 12));
            
                                   
            // Print the monthly payment
            outputStr = outputStr + ", " + "Monthly Amount: " + f.format(monthlyPayment);
            
            //Print the number of years for the loan
            outputStr = outputStr + "," + "Number of Years: " + numberOfYears + "\n";
            
            // Determine whether the user wants to continue the loop
            response = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if (response == JOptionPane.NO_OPTION)
                break;
        }
        
        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Property Loan Amounts", JOptionPane.INFORMATION_MESSAGE);
                
    }
}
