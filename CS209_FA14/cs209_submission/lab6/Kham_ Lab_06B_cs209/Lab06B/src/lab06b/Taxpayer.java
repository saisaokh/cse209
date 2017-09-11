package lab06b;
import java.text.*;
//import java.util.Scanner;

public class Taxpayer {

    protected String borrowerName;
    protected int loanId;
    protected double propertyCost;
    protected double downPayment;
    protected int numberOfYears;
    protected double annualInterestRate = 0.0;

    DecimalFormat prec1 = new DecimalFormat("#.00");
    DecimalFormat prec2 = new DecimalFormat("$#.00");
    

//************************************************************************************************
    Taxpayer(String nam, int id, double propCost, double downPay, int numYears) {

        this.borrowerName = nam;
        this.loanId = id;
        this.propertyCost = propCost;
        this.downPayment = downPay;
        this.numberOfYears = numYears;
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
    public double TotalPayment(){
    
        return 0.0;
    }
 
//************************************************************************************************
//************************************************************************************************ 
    public String toString() {
        
        String str = "";
 
        str = "Name: " + borrowerName + " ID: " + loanId + " Property Cost: " + prec2.format(propertyCost)
                + " Down Payment: " + prec2.format(downPayment)
                + " Yearly Interest Rate:  " + prec2.format(annualInterestRate) + " % Monthly Payment: " ;
            
        return str;
    }   
    //*********************************************************************************************
   
    }

