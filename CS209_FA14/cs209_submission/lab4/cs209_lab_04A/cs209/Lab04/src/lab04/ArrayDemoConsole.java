package lab04;

import javax.swing.*;
import javax.swing.JOptionPane;

public class ArrayDemoConsole {

    public static void main(String[] args) {
        final int LIMIT = 12;       // Max size of array
        int A[] = new int[LIMIT];  // Array declaration and creation

        int B[] = new int[LIMIT]; //Array declaration 

        int countA = 0, countB = 0;         // Count the numbers entered into array A
        String numbStr, numbStrB;         // The number entered by user, as a string
        int numb, numbB;               // The number entered by user, as an double
        String promptAStr = ""; // String to prompt user for data entry
        String arrayAStr = "", arrayAStrB = "";  // String comprised of array elements       
        String outputStr = "";  // String to display output to user
     
        //*******************************************************************************************************************
        //for loop for array A[]
        for (int i = 0; i < A.length; i++) {
            // Prompt and get number from user as a string
            promptAStr = "Array elements: " + arrayAStr + "\n"
                    + "Enter number #" + (i + 1) + " to insert into first array A\n";
            numbStr = JOptionPane.showInputDialog(promptAStr);
            // Convert the number from type String to type double
            numb = Integer.parseInt(numbStr);
            // Insert the number into the next available position in array

            A[countA] = numb;

            // Increment the counter that keeps track of the number of entries
            countA++;

            arrayAStr = arrayToString(A, countA);
           
        } //for loop ends 
   
       String arrSortA = "The array A sorted:\n" + selectionSort(A) + "\n"; 
      
        //*******************************************************************************************************************
        //for loop for array B[]
        for (int i = 0; i < B.length; i++) {

            promptAStr = "Array elements: " + arrayAStrB + "\n"
                    + "Enter number #" + (i + 1) + " to insert into first array B\n";
            numbStr = JOptionPane.showInputDialog(promptAStr);
            numb = Integer.parseInt(numbStr);
            B[countB] = numb;
            countB++;

            arrayAStrB = arrayToString(B, countB);
        }
        
        String arrSortB = "The array B sorted:\n" + selectionSort(B) + "\n"; 
       // System.out.println(arrSortB);
        //*******************************************************************************************************************
        outputStr = "\nThe number of elements in the array A is: " + A.length + "\n"
                + "The elements of array A: " + arrayAStr + "\n"
                + "Sum of the elements of array A: " + arraySum(A)
                + "\nThe number of elements in the array A is: " + B.length + "\n"
                + "The elements of array A: " + arrayAStrB + "\n"
                + "Sum of the elements of array A: " + arraySum(B);
        JOptionPane.showMessageDialog(null, outputStr);
        
        JOptionPane.showMessageDialog(null,arrSortA + arrSortB , "SORTED ARRAYS", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(outputStr);

        System.exit(0);   // Exit the program properly
    }

    
    //**********************************************************************************************************************
    // Compute the sum of the elements in an array
    public static int arraySum(int Z[]) {
        int sum = 0;
        for (int i = 0; i < Z.length; i++) {
            sum += Z[i];
        }
        return sum;
    }

    //**********************************************************************************************************************
    //Method - passing int array and element num as parameters
    public static String arrayToString(int Z[], int countA) {

        String str1 = ""; //String initialization

        for (int i = 0; i < countA; i++) {
            str1 += Z[i] + " ";
  
        }
        
        return str1;
    }

    //**********************************************************************************************************************
    //selection sort
    public static String selectionSort(int[] list) {

        String str = "";
        
        for (int i = 0; i < list.length ; i++) { //Find the min in the list
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }

            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
            str += list[i] + " ";
          //System.out.print(list[i] + " ");
        }
        
        return str;
    }

    //**********************************************************************************************************************
}
