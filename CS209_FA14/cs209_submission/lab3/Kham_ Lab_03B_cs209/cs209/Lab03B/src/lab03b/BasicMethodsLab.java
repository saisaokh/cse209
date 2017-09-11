package lab03b;

import javax.swing.*;
import java.text.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BasicMethodsLab {

    public static void main(String args[]) {

        String propertyCostStr;       // Value entered by user; string type
        String downPaymentStr;        // Value entered by user; string type
        String numberOfYearsStr;      // Value entered by user; string type

        double propertyCost;          // The double form of the user-entered property cost
        double downPayment = 0;       // The double form of the user-entered down payment
        double loanAmount = 0;        // The calculated price of the loan amount
        double monthlyPayment;	  //The monthly loan payment        
        int response = 0;             // The user's response as to whether to continue

        String s = ""; // string to char convertion purpose
        char propertyType;
        DecimalFormat f = new DecimalFormat("##.##"); // Purpose to format 2 decimal places
        int numberOfYears = 0;
        String outputStr = "";// Initialize the output string to the empty string

        while (true) {

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

            //to insert propery type in fun
            s = JOptionPane.showInputDialog("Enter only a single character R: Residential, C: Commercial and A: Agricultural  for property type\n");
            propertyType = s.charAt(0);

            double MonthlyP = calculatePayment(propertyCost, downPayment, numberOfYears, propertyType);//Function call and assing the result(monthly payment) to ans
            
            double toatlAmountPaid = TotalPayment( MonthlyP,   numberOfYears); //Method calculation of total amount paid
             
             
            //*************************************************************** outputs for JOptionPane 
            if (propertyType == 'R' || propertyType == 'r') {
                outputStr = outputStr + "Type: Residential";
            } else if (propertyType == 'C' || propertyType == 'c') {
                outputStr = outputStr + "Type: Commercial";
            } else if (propertyType == 'A' || propertyType == 'a') {
                outputStr = outputStr + "Type: Agricultural";
            }
            //*************************************************************** 
            
            loanAmount = propertyCost - downPayment;
           // System.out.println("In main  loanAmount " + f.format(loanAmount));
            //System.out.println("In main monthyPayment, return from calculatePayment " + f.format(ans));

            // Echo print the entered values and formatting 2 decimal 
            outputStr = outputStr + ", Cost: " + String.format("%.2f", propertyCost) + ", " + "Loan Amount: "
                    + String.format("%.2f", loanAmount) + ", Monthly Amount: " + String.format("%.2f", MonthlyP);

            outputStr = outputStr + "," + " Number of Years: " + numberOfYears + "\n" + "Total Amount Paid for loan: " +String.format("%.2f", toatlAmountPaid)+ "\n"  ;
           // outputStr = String.format("%.2f", toatlAmountPaid);

            // Determine whether the user wants to continue the loop
            response = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Property Loan Amounts", JOptionPane.INFORMATION_MESSAGE);

    }

    //************************************************************************************************************
    // methods to call another respective methods base on the input of R, C or A
    public static double calculatePayment(double propertyCost, double downPayment, int numberOfYears, char propertyType) {

        double mPayment = 0;
        switch (propertyType) {
            case 'R':
            case 'r':
                mPayment = computeResidentialPayment(propertyCost, downPayment, numberOfYears);// Calling another method
                break;
            case 'C':
            case 'c':
                mPayment = computeCommercialPayment(propertyCost, downPayment, numberOfYears);
                break;
            case 'A':
            case 'a':
                mPayment = computeAgriculturalPayment(propertyCost, downPayment, numberOfYears);
                break;

        }

        return mPayment; //Returning the result of calculations of another methods eg:computeAgriculturalPayment(propertyCost, downPayment, numberOfYears);
    }

    //************************************************************************************************************
    //Method: calculation of computeResidentialPayment if user's input is R
    public static double computeResidentialPayment(double propertyCost, double downPayment, int numberOfYears) {

        double result = 0;
        double loanAmount = propertyCost - downPayment;
        System.out.println("Loan Amount = " + loanAmount);

        double AnsPercent = (downPayment / propertyCost) * 100; //Declaration of percentage to identity if amount is > 20 %

        if (AnsPercent > 20) {

            double annualInterestRate = 5.75;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        } else if (AnsPercent < 20) {

            double annualInterestRate = 6.75;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        }
        return result; // Returning the result of another method eg: computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

    }

    //************************************************************************************************************
    //Method: calculation of computeCommercialPayment if user's input is R
    public static double computeCommercialPayment(double propertyCost, double downPayment, int numberOfYears) {

        double result = 0;
        double loanAmount = propertyCost - downPayment;
        System.out.println("Loan Amount = " + loanAmount);

        double AnsPercent = (downPayment / propertyCost) * 100; // 20 % > or < calculation

        if (AnsPercent < 30) {

            double annualInterestRate = 9.6;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        } else {

            double annualInterestRate = 8.6;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        }
        return result;

    }

    //************************************************************************************************************
    ////Method: calculation of computeAgriculturalPayment if user's input is R
    public static double computeAgriculturalPayment(double propertyCost, double downPayment, int numberOfYears) {

        double result = 0;
        double loanAmount = propertyCost - downPayment;
        System.out.println("Loan Amount = " + loanAmount);

        double AnsPercent = (downPayment / propertyCost) * 100; // 20 % > or < calculation

        if (AnsPercent < 10) {

            double annualInterestRate = 6.25;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        } else {

            double annualInterestRate = 5.25;

            result = computeMonthlyPayment(loanAmount, annualInterestRate, numberOfYears);

        }
        return result;

    }

    //************************************************************************************************************
    //Method: calculation of monthly payment according to the formula below
    public static double computeMonthlyPayment(double loanAmount, double annualInterestRate, int numberOfYears) {
        double monthlyPaymentResult;

        monthlyPaymentResult = loanAmount * (annualInterestRate / 1200)
                / (1 - 1 / Math.pow(1 + (annualInterestRate / 1200), numberOfYears * 12));

        return monthlyPaymentResult;
    }
   //************************************************************************************************************
      public static double TotalPayment(double MonthlyP,  int numberOfYears) { //param: monthlP, numYear
    
          double totalAmountPaid = 0;
          
          totalAmountPaid = (MonthlyP * 12) * numberOfYears;
          
          System.out.println(" totalAmountPaid " +totalAmountPaid );
          return totalAmountPaid;
          
      }
    
    
}
