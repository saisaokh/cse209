/*
 * DecisionsLoopLab.java
 *
 */
package lab02a;

import javax.swing.*;

public class DecisionsLoopLabV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String title;           // Value entered by user; string type
        String costStr;     // Value entered by user; string type
        double cost, total = 0;        // The double form of the user-entered DVD cost
        int i = 0, num, resp = 0;       // The user's response as to whether to continue

        // Initialize the output string to the empty string
        String outputStr = "", outputStr2 = "";

        String category = ""; //Options for user to choose movies

        // Loop to input information on the user's DVD collection
        while (true) {
            // Read in DVD title from user as a string
            title = JOptionPane.showInputDialog("Enter DVD title");

            category = JOptionPane.showInputDialog("Choose category by number \n "
                    + "1 Comedy \n 2 Drama \n 3 Action \n 4 ScienceFiction \n 5 Animated");

            // Convert from type String to type integer
            num = Integer.parseInt(category);
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

            // Add the user-entered values to the output string 
            outputStr = outputStr + "DVD " + (i + 1) + ", Cat: " + category + " title: " + title + ", ";

            outputStr = outputStr + "Cost: " + cost + ", total = " + (total += cost) + "\n";

            // Get the user's choice as to whether to continue the loop
            resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // Test whether the user's choice is to continue the loop or not
            if (resp == JOptionPane.NO_OPTION) {
                break;
            }
            i++;
        }

        // outputStr2 = outputStr2 + total + "\n";
        // Display final output to the user
        JOptionPane.showMessageDialog(
                null, outputStr, "Account Total", JOptionPane.INFORMATION_MESSAGE);

        System.out.println(outputStr);
        // System.exit( 0 );      // Terminate the program
    }
}
