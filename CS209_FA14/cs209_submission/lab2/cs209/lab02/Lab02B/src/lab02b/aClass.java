package lab02b;

import javax.swing.*;
import java.text.*;

public class aClass {

  
    public static void main(String[] args) {
        
        String title;           // Value entered by user; string type
        String costStr;     // Value entered by user; string type
        double cost, total = 0, discountPercent = 0, yourCost = 0;        // The double form of the user-entered DVD cost
        int i = 0, num, resp = 0;       // The user's response as to whether to continue
        
        // Initialize the output string to the empty string
        String outputStr = "", outputStr2 = "",totalPurchaseLevel ="", discountPercentStr = "";

        String category = ""; //Options for user to choose movies
        DecimalFormat f = new DecimalFormat("#.##");  // this will helps you to always keeps in two decimal places

        // Loop to input information on the user's DVD collection
        while (true) {
            // Read in DVD title from user as a string
            title = JOptionPane.showInputDialog("Enter DVD title");

            category = JOptionPane.showInputDialog("Choose category by number \n "
                    + "1 Comedy \n 2 Drama \n 3 Action \n 4 ScienceFiction \n 5 Animated");
                      
            num = Integer.parseInt(category); // Convert from type String to type integer
            {
                switch (num) {
                    case 1:
                        category = "Comedy";
                        break;
                    case 2:
                        category = "Drama";
                        break;
                    case 3:
                        category = "Action";
                        break;
                    case 4:
                        category = "ScienceFiction";
                        break;
                    case 5:
                        category = "Animated";
                        break;
                    default:
                        category = "Invaild choice!";
                        break;

                }
                // System.out.println("category");
            }

            // Read in cost from user as a string
            costStr = JOptionPane.showInputDialog("Enter DVD cost");

            // Convert from type String to type double
            cost = Double.parseDouble(costStr);
           
               //*******************************************************************************************************************************************************
            //if esle - determine low, medium, high and very high as purchaseLevel
               if( (total + cost) < 25)
            totalPurchaseLevel =  "Low" ;
               else if (total + cost >25 && total + cost< 75 )
                   totalPurchaseLevel = "Medium";
               else if (total + cost > 75 && total + cost < 125 )
                    totalPurchaseLevel = "High";
               else if (total +  cost >= 125)
                    totalPurchaseLevel = "Very High";             
           
               
               //*******************************************************************************************************************************************************
               //if else - calculation of discount % and display total cost after discount substraction 
                if((total + cost) < 25){
                    
                    discountPercent =  (total +  cost) * 0.05;
                    yourCost = (total+cost) - discountPercent;
                    discountPercentStr = " You will save $" + f.format(discountPercent) + " on your order with discount rate 5.0 % "
                             + "\nYour cost: " + f.format(yourCost);
             //System.out.println(f.format(discountPercent)); 
            //JOptionPane.showMessageDialog(null, "Your will save $" + f.format(discountPercent)+" on your order with disScount rate 5.0 %") ;
            //System.out.println("testing " + (f.format(discountPercent)));
                }   
                else if(total + cost >25 && total + cost < 75){
                    
                     discountPercent =  (total + cost) * 0.10;
                     yourCost = (total+cost) - discountPercent;
                     discountPercentStr = "You will save $" + f.format(discountPercent) + " on your order with discount rate 10.0 % "
                             + "\nYour cost: " + f.format(yourCost);
                }
                else if(total + cost >75 && total + cost < 125){
                    discountPercent =  (total + cost) * 0.15;
                    yourCost = (total+cost) - discountPercent;
                     discountPercentStr = " You will save $" + f.format(discountPercent) + " on your order with discount rate 15.0 % "
                              + "\nYour cost: " + f.format(yourCost);
                }
                else if(total + cost >= 125){
                    discountPercent =  (total + cost) * 0.20;
                    yourCost = (total+cost) - discountPercent;
                     discountPercentStr = " You will save $" + f.format(discountPercent) + " on your order with discount rate 20.0 % "
                              + "\nYour cost: " + f.format(yourCost);
                }
                //********************************************************************************************************************************************************
            // Add the user-entered values to the output string 
            outputStr = outputStr + "DVD " + (i + 1) + ", Cat: " + category + " title: " + title + ", ";

            outputStr = outputStr + "Cost: " + f.format(cost) + ", total = " + f.format(total += cost) + "  "+  totalPurchaseLevel +"\n";
                        
            // Get the user's choice as to whether to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr  + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // Test whether the user's choice is to continue the loop or not
            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
            i++;   //increment the number of user's DVD

        }
        
        System.out.println(total);
              
        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr + "total cost: $"+ f.format(total)  +"\n level: " + totalPurchaseLevel  +  "\n" + discountPercentStr , "Final Results", JOptionPane.INFORMATION_MESSAGE);

        System.out.println(outputStr);
         System.exit( 0 );      // Terminate the program
    }
}
