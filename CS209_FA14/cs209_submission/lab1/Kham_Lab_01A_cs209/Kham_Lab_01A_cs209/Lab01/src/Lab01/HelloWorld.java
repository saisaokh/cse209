package Lab01;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author khams125
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String outputStr = "Hello world!\n" + "Hello, Sai!\n"
                + "Welcome to Java Programming!";
        System.out.println(outputStr);
        JOptionPane.showMessageDialog(null, outputStr, "MY WINDOW OUTPUT",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
