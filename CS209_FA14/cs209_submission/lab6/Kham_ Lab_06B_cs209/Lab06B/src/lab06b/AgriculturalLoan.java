
package lab06b;

//****************************************************************************************************************************
public class AgriculturalLoan extends Taxpayer {
    private char propertyType = 'R';
    private double annualInterestRate= 0.0;
    protected double monthlyPaymentResult = 0.0;

    //**************************************************************************************************************************
    public AgriculturalLoan(String nam, int id, double propCost, double downPay, int numYears ) {
        super(nam, id, propCost, downPay, numYears);
      
    }
//****************************************************************************************************************************
    public double getInterestRate (){
        
        
      //  double monthlyPayment = 0.0;
        double AnsPercent = (downPayment / propertyCost) * 100;
        
        if (AnsPercent <= 10 ) {

                annualInterestRate = 6.25;
               
        }
        else {

                annualInterestRate = 5.25;     
        }
    
      return  annualInterestRate;
    }
//****************************************************************************************************************************
    public int getNumYear(){
        
        if(numberOfYears > 20)
    
        numberOfYears = 20;
        
        return numberOfYears;
        
    }
    
//****************************************************************************************************************************
    
    public  double calculateMonthlyPayment() {
        
        
        double monthlyPaymentResult = 0.0;
        double AnsPercent = (downPayment / propertyCost) * 100;
        double loanAmount = propertyCost - downPayment;

        if(AnsPercent <= 10){
        annualInterestRate = 6.25;
            monthlyPaymentResult = loanAmount * (annualInterestRate / 1200)
                / (1 - 1 / Math.pow(1 + (getInterestRate() / 1200), getNumYear()* 12));
        }
        else{
        annualInterestRate =  5.25;
            monthlyPaymentResult = loanAmount * (annualInterestRate / 1200)
                / (1 - 1 / Math.pow(1 + (getInterestRate() / 1200), getNumYear()* 12));
        }
       // System.out.println("getInterestRate()" + annualInterestRate);
            
        return monthlyPaymentResult;
    }
 //**************************************************************************************************************************** 
    
    public double TotalPayment() { //param: monthlP, numYear
    
          double totalAmountPaid = 0;
          
          totalAmountPaid = (calculateMonthlyPayment() * 12) * getNumYear();
          
       //   System.out.println(" totalAmountPaid " +totalAmountPaid );
          return totalAmountPaid;
          
      }
 
    //****************************************************************************************************************************
    
    public String toString() {
        String str = "";
      
        //  DecimalFormat str = new DecimalFormat("$#.00");
        str =  "Loan Type: Lab06_V3: AgriculturalLoan,"+ "Name: " + borrowerName + ", ID: " + loanId + ", Cost: " + prec2.format(propertyCost)
                + ", Down Payment: " + prec2.format(downPayment) + ", Year "+ getNumYear()
                +", Rate:  " + prec2.format(getInterestRate()) + " % Monthly Payment: " 
                + prec2.format(calculateMonthlyPayment());

        return str;
    }
//*******************************************************************************************************************************
    }