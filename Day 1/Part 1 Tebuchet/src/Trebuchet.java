import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;


public class Trebuchet {

    public int total;

    // Removes all non DIGIT types and stores into a "TEMPORARY" array.
    public ArrayList<String> removeNonDigits(ArrayList<String> lines) {
        // Temporary array for converted values.
        ArrayList<String> temp = new ArrayList<String>();

        for(String line: lines) {
            // Using regex to remove all non digit characters and replacing with an empty string.
            String str = line.replaceAll("[^0-9]", "");
            temp.add(str);
        }
        return temp;
    }

    // Collects all values from array then the first and last number of each line, concatenates them and stores into the final array.
    public ArrayList<String> FirstAndLastValCollection(ArrayList<String> temp) {
        // Final array that stores all coverted string inputs into integer values ready to be added together.
        ArrayList<String> finalNum = new ArrayList<String>();

        for (int i = 0; i < temp.size(); i++) {
            // Storing each converted string ready for gathering first and last digit.
            String store = temp.get(i);

            // Collecting first and last value of array
            char firstVal = store.charAt(0);
            char secondVal = store.charAt(store.length() - 1);  
            
            // Converting each collected value into a string ready for concatenation.
            String one = String.valueOf(firstVal);
            String two = String.valueOf(secondVal);

            // adding both collect values and placing into a string and storing into the final array.
            String concat = one + two;
            finalNum.add(concat);
            
        }
        return finalNum;
    }

    // Calculates the total of all values from the final array.
    public int totalCalc(ArrayList<String> finalNum) {
        for (String num : finalNum) {

            // Converts the string into an Integer to add together.
            int number = Integer.parseInt(num);
            
            // Adds the number from each index to the total variable.
            total += number;
        }
        return total; 
    }

    public static void main(String[] args){
        // Array that will store each line of the INPUT CASE.
        ArrayList<String> lines = new ArrayList<String>();

        // Our object to run each function in the class.
        Trebuchet runtime = new Trebuchet();

        try {
            File file = new File("C:\\Users\\reece\\Desktop\\Advent of Code\\2023\\Day 1\\Part 1 Tebuchet\\src\\input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                lines.add(line);
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Call our remove characters function.
        ArrayList<String> temp = runtime.removeNonDigits(lines);

        // Call our value collection function.
        ArrayList<String> finalNum = runtime.FirstAndLastValCollection(temp);

        // Call our calculation function and store the return value into our finalTotal variable.
        int finalTotal = runtime.totalCalc(finalNum);

        // Print out our answer which should be 54630.
        System.out.println(finalTotal);
        
    }  

}
