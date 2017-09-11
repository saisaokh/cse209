
package lab06b;

//****************************************************************************************************************************
public class CommercialLoan extends Taxpayer {
    private char propertyType = 'R';
    private double annualInterestRate= 0.0;
    protected double monthlyPaymentResult = 0.0;


    //**************************************************************************************************************************
    //public CommercialLoan(String nam, int id, double propCost, double downPay, int numYears,String city ) {
    public CommercialLoan(String nam, int id, double propCost, double downPay, int numYears, String citynam ) {    
        //super(nam, id, propCost, downPay, numYears, city);
      super(nam, id, propCost, downPay, numYears,  citynam);
    }
//****************************************************************************************************************************

//****************************************************************************************************************************
    public double getInterestRate (){
        
      //  double monthlyPayment = 0.0;
        double AnsPercent = (downPayment / propertyCost) * 100;
        
        if (AnsPercent >= 30 ) {
                annualInterestRate = 9.2;             
        }
        else {
                annualInterestRate = 9.6;     
        }
    
      return  annualInterestRate;
    }
//****************************************************************************************************************************
    public int getNumYear(){
        
        if(numberOfYears > 15)
    
        numberOfYears = 15;
        
        return numberOfYears;
        
    }
    
//****************************************************************************************************************************
    
    public  double calculateMonthlyPayment() {
        
        
        double monthlyPaymentResult = 0.0;
        double AnsPercent = (downPayment / propertyCost) * 100;
        double loanAmount = propertyCost - downPayment;

        if(AnsPercent >= 30){
        annualInterestRate =9.2;
            monthlyPaymentResult = loanAmount * (annualInterestRate / 1200)
                / (1 - 1 / Math.pow(1 + (getInterestRate() / 1200), getNumYear()* 12));
        }
        else{
        annualInterestRate = 9.6;
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
          
        //  System.out.println(" totalAmountPaid " +totalAmountPaid );
          return totalAmountPaid;
          
      }
    
    
    //****************************************************************************************************************************
    
    public String toString() {
        String str = "";
      
        //  DecimalFormat str = new DecimalFormat("$#.00");
        str =  "Loan Type: Commercial, "+ "Name: " + borrowerName + ", ID: " + loanId + "City: "+ city1 +", Cost: " + prec2.format(propertyCost)
                + ", Loan Amount: " +prec2.format(propertyCost - downPayment) + ", Year "+ getNumYear()
                +", Rate:  " + prec2.format(getInterestRate()) + " % Monthly Payment: " 
                + prec2.format(calculateMonthlyPayment())+",Total Paid:"+prec2.format(TotalPayment())+"\n";

        return str;
    }
//*******************************************************************************************************************************
    }