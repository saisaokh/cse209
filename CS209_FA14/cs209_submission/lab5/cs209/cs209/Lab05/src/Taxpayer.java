
import java.text.*;
//import java.util.Scanner;

public class Taxpayer {

    private String borrowerName;
    private int loanId;
    private double propertyCost;
    private double downPayment;
    private int numberOfYears;
    private double annualInterestRate = 7.50;

    DecimalFormat prec1 = new DecimalFormat("#.00");
    DecimalFormat prec2 = new DecimalFormat("$#.00");
    

//************************************************************************************************
    Taxpayer(String nam, int id, double propCost, double downPay, int numYears) {

        borrowerName = nam;
        loanId = id;
        propertyCost = propCost;
        downPayment = downPay;
        numberOfYears = numYears;
    }
//************************************************************************************************
//************************************************************************************************
    public String getBorrowerName() {

        return borrowerName;
    }
 //************************************************************************************************
 //************************************************************************************************   

    public int getLoanId() {

        return loanId;
    }

//************************************************************************************************
//************************************************************************************************
    public double getPropCost() {

        //System.out.println("This is in class propertyCost " + prec2.format(propertyCost));
        return propertyCost;
    }

//************************************************************************************************
//************************************************************************************************
    public double getDownPayment() {

        return downPayment;
    }

//************************************************************************************************   
//************************************************************************************************
    public int getNumYears() {
        // int a = 0;
        //numberOfYears = a;
        return numberOfYears;
    }

//************************************************************************************************ 
//************************************************************************************************
    public double getInterestRate() {

        return annualInterestRate;
    }

//************************************************************************************************    
//************************************************************************************************ 
    public double calculateMonthlyPayment() {

        double loanAmount = propertyCost - downPayment;

        double monthlyPaymentResult = loanAmount * (annualInterestRate / 1200)
                / (1 - 1 / Math.pow(1 + (annualInterestRate / 1200), numberOfYears * 12));

        return monthlyPaymentResult;
    }

//************************************************************************************************ 
//************************************************************************************************ 
    public String toString() {
        String str = "";
    //  DecimalFormat str = new DecimalFormat("$#.00");

        str = "Name: " + borrowerName + " ID: " + loanId + " Property Cost: " + prec2.format(propertyCost)
                + " Down Payment: " + prec2.format(downPayment)
                + " Yearly Interest Rate:  " + prec2.format(annualInterestRate) + " % Monthly Payment: " 
                + prec2.format(calculateMonthlyPayment());

        return str;
    }
}
//************************************************************************************************