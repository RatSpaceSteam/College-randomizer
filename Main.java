import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner fileScan;
        fileScan = new Scanner(new File("colleges.txt"));
        fileScan.useDelimiter(",");
        String name = fileScan.next();
        for (int i = 0; i < 48; i++) {
            System.out.println("Name: " + name);
            String location = fileScan.next();
            System.out.println("Location: " + location);
            String setting = fileScan.next();
            System.out.println("Setting: " + setting);
            String size = fileScan.next();
            System.out.println("Size: " + size);
            String major = fileScan.next();
            System.out.println("Major/Field of Interest: " + major);
            String range = fileScan.next();
            System.out.println("ACT Range: " + range);
            String acceptRate = fileScan.next();
            if (containsNumAndLet(acceptRate)) {
                StringBuilder reset = new StringBuilder(acceptRate);
                int rateAndName = splitInTwo(acceptRate);
                acceptRate = acceptRate.substring(0, rateAndName);
                System.out.println("Acceptance Rate: " + acceptRate);
                reset.delete(0, rateAndName);
                name = reset.toString();
            }

        }
        fileScan.close();
    }

    public static boolean containsNumAndLet(String input) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String num : nums) {
            if (input.contains(num)) {
                for (String let : alphabet) {
                    String lower = let.toLowerCase();
                    if (input.contains(let) || input.contains(lower)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int splitInTwo(String rateAndName) {
        int split = 1;
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < rateAndName.length(); i++) {
            String current = Character.toString(rateAndName.charAt(i));
            for (String let : alphabet) {
                if (current.equals(let)) {
                    split = i;
                    return split;
                }
            }
        }
        return split;
    }
}