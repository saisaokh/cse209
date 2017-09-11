package lab06a;

import javax.swing.*;
import java.text.*;

public class Main {
   // The main method required for an application program
    
   public static void main( String[] args ) {
     final int MAX_NUMBER = 7;
     Taxpayer ln1 = null;   // Variable to hold an instance of the Loan class 
     Taxpayer ln2 = null;   // Same as above
     Taxpayer ln3 = null;   // Same
     Taxpayer ln4 = null;   // Same
     Taxpayer ln5 = null;   // Same
     Taxpayer ln6 = null;   // Same
     Taxpayer ln7 = null;   // Same
     
     Taxpayer ln = null;  
     DecimalFormat prec = new DecimalFormat("$#.00");
     
     //**********************************************
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
      
       
      //************************** 
         String s = "";
       char propertyType;
       s = JOptionPane.showInputDialog("Enter loan type by choosing R,C,A or U \n R Residential Loan\n "
               + "C Commercial Loan\n A Agricultural Loan\n  U Unspecified Loan\n\n\n Note: default loan is unspecified loan");
            propertyType = s.charAt(0);
            
            if (propertyType == 'R' || propertyType == 'r') {
                
                ln = new ResidentialLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
                //outputStr = outputStr + count + ". Loan Type Lab06_V3: ResidentialLoan,";
                 //ln = new ResidentialLoan(borrowerNameStr, loanId, propCost, downPayment, numberOfYears);
                
            } else if (propertyType == 'C' || propertyType == 'c') {
                outputStr = outputStr + count + ". Loan Type Lab06_V3: CommercialLoan,";
            } else if (propertyType == 'A' || propertyType == 'a') {
                outputStr = outputStr + count +". Loan Type Lab06_V3: AgriculturalLoan,";
            }
     //**************************
 
       // Assign new Loan object to next available Loan variable
       switch (count) {
           case 1:  ln1 = ln; break;
           case 2:  ln2 = ln; break;
           case 3:  ln3 = ln; break;
           case 4:  ln4 = ln; break;
           case 5:  ln5 = ln; break;
           case 6:  ln6 = ln; break;
           case 7:  ln7 = ln; break;
       }       
       outputStr += count + ".  " + ln.toString() +  "\n";             
    
       if (count < MAX_NUMBER) {
           msgStr = "\nMax number of allowed Loans is: " + MAX_NUMBER + "\nContinue?";
           
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
         switch (i) {
             case 1:  ln = ln1; break;
             case 2:  ln = ln2; break;
             case 3:  ln = ln3; break;
             case 4:  ln = ln4; break;
             case 5:  ln = ln5; break;
             case 6:  ln = ln6; break;
             case 7:  ln = ln7; break;
                 
         }
         
         outputStr2  += "\n" + i +" "+ln.getBorrowerName() + "  ID No. " + ln.getLoanId()+ "\n Loan Type: lab06_v3.ResidnetialLoan"
                            +  "\n Property cost "+ prec.format(ln.getPropCost()) + "       Loan amount: "+ prec.format(ln.getPropCost()-ln.getDownPayment())
                            + "\n Number of Years: "+ ln.getNumYears()+ "        Annual Interest Rate: " + prec.format(ln.getInterestRate())+ "%" 
                            + "\nMonthly Loan Payment " 
                                    + prec.format(ln.calculateMonthlyPayment())+ "\t Total Amount Pay for Loan: $" +prec.format(ln.TotalPayment())+ "\n";
     }    
        
     JOptionPane.showMessageDialog(null, outputStr2, "Loan Summary",
                                         JOptionPane.INFORMATION_MESSAGE);
     
     
   }
}
