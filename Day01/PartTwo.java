package AoC.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class PartTwo {
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
                // expected output -> 54418
            }
        } catch (IOException e) {
            System.out.println("Error occurred \n " + e.getMessage());
        }
        System.out.println(sum);
    }

    private static int getSum(String line, HashMap<String, Integer> map) {
        int a = 0, b = 0, sum = 0;
        String s1 = getFirstWord(line, map);
        for (char ch :
                line.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                a = ch - '0';
                break;
            }
        }
        String s2 = getLastWord(line, map);
        for (int i = line.length() - 1; i >= 0; i--) {
            char ch = line.charAt(i);
            if (ch >= '0' && ch <= '9') {
                b = ch - '0';
                break;
            }
        }
        int i1 = indexOf(line, s1, "1"),i2=indexOf(line, s2, "2");
        if (s1.isEmpty() && s2.isEmpty()) {
            return a * 10 + b;
        } else if (s1.isEmpty()) {
            // s2 != ""
            if (i2 > indexOf(line, b)) {
                return a * 10 + map.get(s2);
            } else {
                return a * 10 + b;
            }
        } else if (s2.isEmpty()) {
            // s1 != ""
            if (i1 < indexOf(line, a)) {
                return map.get(s1) * 10 + b;
            } else {
                return a * 10 + b;
            }
        } else {
            if (a == 0 || i1 < indexOf(line, a)) {
                a = map.get(s1);
            }
            if (b == 0 || i2 > indexOf(line, b)) {
                b = map.get(s2);
            }
        }
        return a * 10 + b;
    }

    private static String getFirstWord(String word, HashMap<String, Integer> map) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                if (map.containsKey(word.substring(i, j))) {
                    return word.substring(i, j);
                }
            }
        }
        return "";
    }

    private static String getLastWord(String word, HashMap<String, Integer> map) {
        for (int i = word.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String sub = word.substring(j, i);
                if (map.containsKey(sub)) {
                    return sub;
                }
            }
        }
        return "";
    }

    private static int indexOf(String line, int a) {
        char[] ch = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            if (ch[i] == (char) (a + 48)) {
                return i;
            }
        }
        return -1;
    }

    private static int indexOf(String line, String word, String order) {
        int i = line.indexOf(word);
        int x = line.lastIndexOf(word);
        if (order.equals("1")) {
            return i;
        } else {
            return x;
        }
    }
}