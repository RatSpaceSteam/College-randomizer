import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        College[] randomColleges = new College[48];
        Scanner fileScan;
        fileScan = new Scanner(new File("colleges.txt"));
        fileScan.useDelimiter(",");
        String name = fileScan.next();
        for (int i = 0; i < 48; i++) {
            String location = fileScan.next();
            String setting = fileScan.next();
            String size = fileScan.next();
            String major = fileScan.next();
            String range = fileScan.next();
            String acceptRateString = fileScan.next();
            if (containsNumAndLet(acceptRateString)) {
                StringBuilder reset = new StringBuilder(acceptRateString);
                int rateAndName = splitInTwo(acceptRateString);
                acceptRateString = acceptRateString.substring(0, rateAndName - 1);
                int acceptRate = Integer.parseInt(acceptRateString);
                randomColleges[i] = new College(name, location, setting, size, major, range, acceptRate);
                reset.delete(0, rateAndName);
                name = reset.toString();
            }
            else {
                int acceptRate = Integer.parseInt(acceptRateString);
                randomColleges[i] = new College(name, location, setting, size, major, range, acceptRate);
            }

        }
        fileScan.close();

        int randCol = (int)(Math.random() * 48);
        System.out.println("Name: " + randomColleges[randCol].getName());
        System.out.println("Location: " + randomColleges[randCol].getLocation());
        System.out.println("Setting: " + randomColleges[randCol].getSetting());
        System.out.println("Size: " + randomColleges[randCol].getSize());
        System.out.println("Major/Field of Interest: " + randomColleges[randCol].getMajor());
        System.out.println("ACT Range: " + randomColleges[randCol].getRange());
        System.out.println("Acceptance Rate: " + randomColleges[randCol].getRate() + "%\n");
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