import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trebuchet {

    // Defining map with string and its corresponding numerical number.
    private static Map<String, Integer> createWordToNumMap() {
        Map<String, Integer> wordToNum = new HashMap<>();
        wordToNum.put("one", 1);
        wordToNum.put("two", 2);
        wordToNum.put("three", 3);
        wordToNum.put("four", 4);
        wordToNum.put("five", 5);
        wordToNum.put("six", 6);
        wordToNum.put("seven", 7);
        wordToNum.put("eight", 8);
        wordToNum.put("nine", 9);
        wordToNum.put("oneight", 18);
        wordToNum.put("twone", 21);
        wordToNum.put("eightwo", 82);
        return wordToNum;
    }


    // Removes all non DIGIT types and stores into a "TEMPORARY" array.
    public static int numExtraction(String input) {
        // Calling map to search for matches with digits.
        Map<String, Integer> map = createWordToNumMap();

        // Declared mutable string which each line with be added to before doing a first and last value collection.
        StringBuilder digits = new StringBuilder();

        Pattern pattern = Pattern.compile("(?:\\d+|oneight|twone|eightwo|one|two|three|four|five|six|seven|eight|nine)");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            String match = matcher.group().toLowerCase();
            if(Character.isDigit(match.charAt(0))) {
                digits.append(match);
            } else {
                digits.append(map.get(match));
            }
        }

        String number = "";
        number += digits.charAt(0);
        number += digits.charAt(digits.length() - 1);

        return Integer.parseInt(number);
    }


    public static void main(String[] args) throws IOException {
        // Array that will store each line of the INPUT CASE.
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File file = new File("C:\\Users\\reece\\Desktop\\Coding\\Advent of Code\\2023\\Day 1\\Part 2 Trebuchet\\Trebuchet\\src\\input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                lines.add(line);
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int answer = 0;

        for (String line : lines) {
            answer += numExtraction(line);
        }

        // Print out our answer which should be 54770.
        System.out.println(answer);
        
    }  

}
