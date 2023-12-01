package AoC.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class PartTwo1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        int sum = 0;
        String fileName = "LeetCode/src/AoC/Day1/data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += getSum(line, map);
            }
        } catch (IOException e) {
            System.out.println("Error occurred \n " + e.getMessage());
        }
        System.out.println(sum);
    }

    private static int getSum(String line, HashMap<String, Integer> map) {
        int a = -1, b = -1;
        String s1 = getFirstWordOrDigit(line, map);
        String s2 = getLastWordOrDigit(line, map);

        if (!s1.isEmpty()) {
            a = map.containsKey(s1) ? map.get(s1) : s1.charAt(0) - '0';
        }

        if (!s2.isEmpty()) {
            b = map.containsKey(s2) ? map.get(s2) : s2.charAt(0) - '0';
        }

        if (a == -1 || b == -1) return 0; // In case of no valid digits

        return a * 10 + b;
    }

    private static String getFirstWordOrDigit(String word, HashMap<String, Integer> map) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String sub = word.substring(i, j);
                if (map.containsKey(sub) || (sub.length() == 1 && Character.isDigit(sub.charAt(0)))) {
                    return sub;
                }
            }
        }
        return "";
    }

    private static String getLastWordOrDigit(String word, HashMap<String, Integer> map) {
        for (int i = word.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String sub = word.substring(j, i);
                if (map.containsKey(sub) || (sub.length() == 1 && Character.isDigit(sub.charAt(0)))) {
                    return sub;
                }
            }
        }
        return "";
    }
}
