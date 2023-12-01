package AoC.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PartOne {
    public static void main(String[] args) {
        int sum = 0;
        String fileName = "LeetCode/src/AoC/Day1/data.txt";
//        System.out.println(System.getProperty("user.dir"));
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += getSum(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred \n " + e.getMessage());
        }
        System.out.println(sum);
    }

    private static int getSum(String line) {
        int a = 0, b = 0;
        for (char ch :
                line.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                a = ch - '0';
                break;
            }
        }
        for (int i = line.length() - 1; i >= 0; i--) {
            char ch = line.charAt(i);
            if (ch >= '0' && ch <= '9') {
                b = ch - '0';
                break;
            }
        }
        return a*10+b;
    }
}