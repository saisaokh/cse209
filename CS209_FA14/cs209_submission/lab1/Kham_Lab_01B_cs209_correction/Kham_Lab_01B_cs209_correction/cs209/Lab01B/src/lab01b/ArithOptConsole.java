package lab01b; //Package name

import javax.swing.*;  //necessary for JOptionPane class

public class ArithOptConsole {

    public static void main(String[] args) {

        //variables declaration
        double fahr, fahr2;    //var to hold 2 values of Fah
        double cels, cels2;    //var to hold 2 values of Cel
        String fahrStr, celsStr; //String form for fahrenheit degrees
        String outputStr = "", outputStr2 = ""; //initialized to null string

        //JOptionPane always returns string type
        fahrStr = JOptionPane.showInputDialog("Enter fahrenheit degrees: ");
        fahr = Double.parseDouble(fahrStr);//convert string to double

        // 5/9.0 is necessary since 5/9  evaluates to 0
        cels = (5 / 9.0) * (fahr - 32);

        outputStr += "Fahrenheit degrees: " + fahr + "\n convert to "
                + "\nCelsius degrees: " + cels + "\n";

        //display dialog box  conversion Fah from user's input to Cel
        JOptionPane.showMessageDialog(null, outputStr, "Fahrenheit to Celsius",
                JOptionPane.INFORMATION_MESSAGE);

        //Prompt user's input for Cel in Dialog box
        celsStr = JOptionPane.showInputDialog("Enter Celsius degrees: ");
        cels2 = Double.parseDouble(celsStr);
        fahr2 = (cels2 * 9) / 5 + 32;

        outputStr2 += "\nCelsius degrees: " + cels2 + "\n convert to "
                + "\nFahrenheit degrees: " + fahr2 + "\n";

        //display dialog box  conversion Fah from user's input to Cel
        JOptionPane.showMessageDialog(null, outputStr2, "Fahrenheit to Celsius",
                JOptionPane.INFORMATION_MESSAGE);

        System.out.println(outputStr);
        System.out.println( outputStr2);
        System.out.println(outputStr + outputStr2);

        //Dispaly conversion dialog box of both Fah to Cel and Cel to Fah
        JOptionPane.showMessageDialog(null, outputStr + outputStr2, "Fahrenheit to Celsius",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
