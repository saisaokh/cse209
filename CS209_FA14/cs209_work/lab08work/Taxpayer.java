package lab06b;
import java.text.*;
//import java.util.Scanner;

public class Taxpayer {

    protected String borrowerName;
    protected int loanId;
    protected double propertyCost;
    protected double downPayment;
    protected int numberOfYears;
    protected String city1;
    protected double annualInterestRate = 0.0;
    
    protected String loanType;
    protected String cityName;
    DecimalFormat prec1 = new DecimalFormat("#.00");
    DecimalFormat prec2 = new DecimalFormat("$#.00");
    
//************************************************************************************************
    // String borrower, int idnum and String loan type
     Taxpayer(String nam, int id, String loanT ) {
         this.borrowerName = nam;
         this.loanId = id;
         this.loanType = loanT;
     }
    
//************************************************************************************************
    //Taxpayer(String nam, int id, double propCost, double downPay, int numYears, String city) {
     Taxpayer(String nam, int id, double propCost, double downPay, int numYears, String citynam) {

        //this.cityName = cityNam;
        this.borrowerName = nam;
        this.loanId = id;
        this.propertyCost = propCost;
        this.downPayment = downPay;
        this.numberOfYears = numYears;
        this.city1 = citynam;
    }
     /*
//************************************************************************************************
     public String getCity() {

        return city1;
    }
//************************************************************************************************
     */
     
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
 //super.toString()
        str = "TPName: " + borrowerName + " ID: " + loanId + " Property Cost: " + prec2.format(propertyCost)
                + " Down Payment: " + prec2.format(downPayment)
                + " Yearly Interest Rate:  " + prec2.format(annualInterestRate) + " % Monthly Payment: " +"City: " + city1;
            
        return str;
    }   
    //*********************************************************************************************
   
    /*
    public int getNumYear(){
        
        if(numberOfYears > 30)
    
        numberOfYears = 30;
        
        return numberOfYears;
        
    }
    //*******************************************
     public String toString() {
        String str = "";
      
        //  DecimalFormat str = new DecimalFormat("$#.00");
        str =  "TP Loan Type: Lab06_V3: ResidentialLoan,"+ "Name: " + borrowerName + ", ID: " + loanId + ", Cost: " + prec2.format(propertyCost)
                + " Down Payment: $" + prec2.format(downPayment) + ", Year "+ getNumYear()
                +", Rate:  " + prec2.format(getInterestRate()) + " % Monthly Payment: " 
                + prec2.format(calculateMonthlyPayment());

        return str;
    }
    */
    }

