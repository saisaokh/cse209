package lab01b;

import javax.swing.*;  //necessary for JOptionPane class

public class ArithOptConsole {

    public static void main(String[] args) {
        //good style: all declarations at beginning of program
        double fahr,fahr2;    //degrees in fahrenheit
        double cels,cels2;    //degrees in celsius
        String fahrStr,celsStr; //String form for fahrenheit degrees
        String outputStr = "",outputStr2 = ""; //initialized to null string

        //JOptionPane always returns string type
        fahrStr = JOptionPane.showInputDialog("Enter fahrenheit degrees: ");
        fahr = Double.parseDouble(fahrStr);//convert string to double
        //note that 5/9.0 is necessary since 5/9  evaluates to 0
        cels = (5 / 9.0) * (fahr - 32);
       
        outputStr += "Fahrenheit degrees: " + fahr + "\n convert to "
                + "\nCelsius degrees: " + cels + "\n";
        
        
        celsStr  = JOptionPane.showInputDialog("Enter Celsius degrees: ");
        cels2 = Double.parseDouble(celsStr);
        fahr2 = (cels2 * 9)/5 +32;
        
        outputStr2 += "\nCelsius degrees: " + cels2 + "\n convert to "
                + "\nFahrenheit degrees: " + fahr2 + "\n";
        
        
        System.out.println(outputStr + outputStr2);
       // System.out.println(outputStr2);
        
        JOptionPane.showMessageDialog(null, outputStr + outputStr2, "Fahrenheit to Celsius",
                JOptionPane.INFORMATION_MESSAGE);

        //add code here for celsius to fahrenheit conversion
        //request degrees for celsius using JOptionPane.showInputDialog
    }
}
