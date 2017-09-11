
package lab09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Main extends JFrame {
    // Member variables
    private JLabel prompt1, prompt2, prompt3;   // Prompts for user input
    private JTextField input1, input2, input3;  // Mechanisms to get user input
    private JButton button1;
    
    private final int MAX_ITEMS = 12;  // Max number of elements in the array
    private MyNumberArrayB numberArray = new MyNumberArrayB(MAX_ITEMS);
    
    private JTextArea TDisplay;        // Output display area
    private int TDisplayWidth = 30;    // Width of the JTextArea
    private int TDisplayHeight = 25;   // Height of the JTextArea
    
    // The main method required for an application program
    public static void main( String[] args ) {
        JFrame frame =  new Main( ); // Construct the window
        frame.setSize( new Dimension( 550, 500 ) );  // Set its size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible( true );   // Make the window visible
    }
    
    // Constructor
    public Main() {
        super( "Exception Handling Lab" );
                      
        JPanel pan = new JPanel( new GridLayout( 3, 2 ));
        add(pan, BorderLayout.NORTH);
        EtchedBorder eBorder = new EtchedBorder();
        
        prompt1 = new JLabel("Enter index number (0-" + (MAX_ITEMS - 1) + "), hit Enter key:",JLabel.RIGHT);
        prompt1.setBorder(eBorder);
        pan.add( prompt1 );  // put prompt on panel
        input1 = new JTextField( 4 );
        pan.add( input1 );  // put input JTextField on panel
        
        prompt2 = new JLabel("Enter decimal number to insert, hit Enter key:", JLabel.RIGHT);
        prompt2.setBorder(eBorder);
        pan.add( prompt2 );  // put prompt on panel
        input2 = new JTextField( 15 );
        pan.add( input2 );  // put input JTextField on panel
        
        prompt3 = new JLabel("Sum and Average of entered numbers:", JLabel.RIGHT);
        prompt3.setBorder(eBorder);
        pan.add( prompt3 );  // put prompt on panel
        
        button1 = new JButton("Compute");
        pan.add( button1 );  // put button on panel
        
        // Create and display a text area for presenting results
        TDisplay = new JTextArea( createListStr(),
                TDisplayHeight,TDisplayWidth);
        TDisplay.setLineWrap( true );
        TDisplay.setWrapStyleWord( true );
        add(TDisplay, BorderLayout.CENTER);
        
        // Add handlers to respond to user GUI manipulation
        input1.addActionListener( new ActListener1() );
        input2.addActionListener( new ActListener2() );
        button1.addActionListener( new ButtonListener() );
    }
    
    public String createListStr(){
        String outString = "\nTHE NUMBER LIST:\n\n" + numberArray.toString();
        return outString;
    }
    
    // Class to handle user action on first JTextField
    class ActListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String strPos = input1.getText();
            // int pos = Integer.parseInt( strPos );
            //*********Exception A*********
            int pos = 0;
            try {
                pos = Integer.parseInt(strPos);
            } catch (Exception A) {

                JOptionPane.showMessageDialog(null,"Incrroect data type entered \n "
                        + "Please try agian to enter a real number into the array");
            }
            //*********Exception A*********end////////////////

            //********Exception C**********
            try {
                // value = numberArray.getNumberAtPos( pos );
                if (pos >= MAX_ITEMS) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Exception C) {

                JOptionPane.showMessageDialog(null,"INVALID ARRAY INDEX\\n"+ C.toString()+": "+pos);
            }
             //*********Exception C*********end///////////////

             //*********Exception B*********
            double value = 0.0;
            try {
                value = numberArray.getNumberAtPos(pos);
            } catch (Exception B) {

                JOptionPane.showMessageDialog(null,"Incorrect data tye entered\n"+
                        "Please try again to enter a real number into the array\n"
                        + B.toString());
            }
            //*********Exception B**********end///////////////

            String strValue = Double.toString(value);
            input2.setText(strValue);

            // Display list and results
            TDisplay.setText(createListStr());
        }
    }

    // Class to handle user action on second JTextField
    class ActListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String strPos = input1.getText();
            String strValue = input2.getText();
            //   int pos = Integer.parseInt( strPos );
            //******************
            int pos = 0;
            try {
                pos = Integer.parseInt(strPos);
            } catch (Exception A) {

                JOptionPane.showMessageDialog(null,"Illegal data entered for index in first textbox \n "
                        + "Please try agian to choose the location in the array\n "+A.toString());
                
                
            }

            //*******Exception C***********
            try {
                // value = numberArray.getNumberAtPos( pos );
                if (pos >= MAX_ITEMS) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Exception C) {
                   JOptionPane.showMessageDialog(null,"INVALID ARRAY INDEX\n" +C.toString()+": " +pos);
               //JOptionPane.showMessageDialog(null,"INVALID ARRAY INDEX\N"+C.toString());
            }

             //***************Exception C****************end///////////
            //*******Exception B***********
           // double value = Double.parseDouble( strValue );  
            double value = 0.0;
            try {
                value = Double.parseDouble(strValue);
            } catch (Exception B) {

                JOptionPane.showMessageDialog(null,"Incorrect data tye entered \n"+
                        "Please try again to enter a real number into the array\n"
                        + B.toString());
            }

            //********Exception B**********end
            numberArray.insertNumberAtPos(value, pos);
            // Display list and results
            TDisplay.setText(createListStr());
        }

    }

    // Class to handle user action on button
    class ButtonListener implements ActionListener  {
        
        public void actionPerformed( ActionEvent e) {
            input1.setText("");
            input2.setText("");
            String displayStr = createListStr();
            if (e.getSource() == button1) {
                displayStr += "\nNumber of entered decimal numbers is: " + numberArray.getCountOfEnteredNumbers();
                displayStr += "\nSum of the entered numbers is: " + numberArray.computeSumOfNumbers();
                displayStr += "\nAverage of the entered numbers is: " + numberArray.computeAveOfEnteredNumbers();
            }            
            // Display list and results
            TDisplay.setText(displayStr);
        }
    }
}

// A simple array class to use for demonstrating exception handling
class MyNumberArrayB  {
    // Instance variables
    private int maxSize;       // Maximum number of elements in the array
    private double number[];   // The array of numbers
    private int countNums = 0;
    
    // Constructor
    MyNumberArrayB( int mSize ) {
        number = new double[mSize];
        maxSize = mSize;
    }
    
    // Method to return the number of elements that have been entered into the array
    public int getCountOfEnteredNumbers() {
        return countNums;
    }
    
    // Method to insert number into array at index position j
    public void insertNumberAtPos( double val, int j ) {
        number[j] = val;
        countNums++;
    }
    
    // Method to get the data number at array index position j
    public double getNumberAtPos( int j ) {
        return number[j];
    }
    
    // Method to compute the sum of all the numbers in the array
    public double computeSumOfNumbers() {
        double sum = 0.0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }
        return sum;
    }
    
    // Method to compute the average of all the numbers actually inserted into the array
    public double computeAveOfEnteredNumbers() {
        double sum = computeSumOfNumbers();
        double ave =  sum / countNums;
        return ave;
    }
    
    // Method to return the entire array composed as one string, with both index
    // and element value included
    public String toString() {
        String outString = "";
        for (int i = 0; i < number.length; i++ ) {
            outString = outString + "  " + i + "     " + number[i] + "\n";
        }
        return outString;
    }
}

