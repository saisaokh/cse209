package lab06b;

import javax.swing.*;
import java.text.*;

public class Main {
    DecimalFormat prec = new DecimalFormat("#.00"); //formatting 2 decimal
    public static void main( String[] args ) {
        
       int SIZE = 50;
       Taxpayer [] TP = new  Taxpayer [SIZE];
     
     Taxpayer ln = null;  
     DecimalFormat prec = new DecimalFormat("$#.00");
     
     //**********************************************variable declaration
     String borrowerNameStr = "";  	// Holds Borrower's name entered by user
     String loanIdStr = ""; 	   // Holds Loan's ID number as string, entered by user
     int loanId = 0;        	   // Loan's ID number as int
     String propCostStr = ""; 	   // Property cost as string, entered by user
     double propCost = 0.0;   	   // Property cost as double
     String downPaymentStr = "";   // Down payment as string, entered by user
     double downPayment = 0.0;     // Down paymnet  as double
     String numberOfYearsStr = ""; // Number of years for loan as string, entered by user
     int numberOfYears = 0;        // Number of years for loan as integer
     //**********************************************
     
     int count = 0;         // The number of Loans created
     String outputStr = ""; // String for output display to user
     String outputStr2 = "";// String for output display to user
     String msgStr = "";    // Holds message for display to user
     int resp = 0;          // User's response from showConfirmDialog method

     while (true) {   // Loop to input data on each Loan        
       count++;
           
       // Read in borrower name from user as a string
       borrowerNameStr = JOptionPane.showInputDialog("Enter Borrower name");
       
       // Read in loan ID number from user as a string
       loanIdStr = JOptionPane.showInputDialog("Enter loan ID number");
       // Convert from type String to type int
       loanId = Integer.parseInt(loanIdStr.trim());       
     
       // Read in property cost from user as a string
       propCostStr = JOptionPane.showInputDialog("Enter property cost");
       // Convert from type String to type double
       propCost = Double.parseDouble(propCostStr.trim());
             
       // Read in down payment from user as a string
       downPaymentStr = JOptionPane.showInputDialog("Enter down payment");
       // Convert from type String to type double
       downPayment = Double.parseDouble(downPaymentStr.trim());
       
       // Read in number of years for loan from user as a string
       numberOfYearsStr = JOptionPane.showInputDialog("Enter number of years for loan");
       // Convert from type String to type integer
       numberOfYears = Integer.parseInt(numberOfYearsStr.trim());	 
       
   
      //************************** 
         String s = "";
       char propertyType;
       s = JOptionPane.showInputDialog("Enter loan type by choosing R,C,A  \n R/r Residential Loan\n "
               + "C/c Commercial Loan\n A/a Agricultural Loan\n  others Unspecified Loan\n\n\n Note: default loan is unspecified loan");
            propertyType = s.charAt(0);
            
            if (propertyType == 'R' || propertyType == 'r') {           
                ln = new ResidentialLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
 
            } else if (propertyType == 'C' || propertyType == 'c') {
                ln = new CommercialLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
            
            } else if (propertyType == 'A' || propertyType == 'a') {
                ln = new AgriculturalLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
            
            }else {
                 ln = new UnspecifiedLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
            }
     //**************************
 
        TP[count] = ln ; //for toString after eof while loop
          
        outputStr += count + ".  " + ln.toString() +  "\n";             
        //   outputStr += count + ".  " + TP[count] +  "\n";             
    
       if (count < SIZE) {
           msgStr = "\nMax number of allowed Loans is: " + SIZE + "\nContinue?";
           
           resp = JOptionPane.showConfirmDialog(null, outputStr + msgStr, "Confirm",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE);
           if (resp == JOptionPane.NO_OPTION)
              break;
       }
       else {
           msgStr = "Program cannot handle any more additional Loans.";
           JOptionPane.showMessageDialog(null, outputStr + msgStr, "Results",
                                         JOptionPane.INFORMATION_MESSAGE);
           break;           
       }       
     }//end while
     
     outputStr2 = "Loan list:\n";
     for (int i = 1; i <= count; i++){         
       ln = TP[i]; 
                
      outputStr2  += "\n" + i +". " + ln.getBorrowerName() + "          ID No:"  + ln.getLoanId() +"\n" + "Loan Type: "+ln.getClass().getName() + " \n" + "Property Cost: $"
                        + prec.format(ln.getPropCost()) + "          Loan Amount: "+ prec.format(ln.getPropCost() - ln.downPayment)+ "\n"+ "Number Of Years "+ ln.getNumYears()
                        + "           Annual Interest Rate: "+ prec.format(ln.getInterestRate())+ "%" + "\nMonthly Loan Payment: $"+ prec.format(ln.calculateMonthlyPayment())
                        + "          Total Amount Paid for loan: $"+ prec.format(ln.TotalPayment()) + "\n";
     
     }     
     JOptionPane.showMessageDialog(null, outputStr2, "Loan Summary",
                                         JOptionPane.INFORMATION_MESSAGE);
     
   }  
}
