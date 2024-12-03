import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    private static void partTwo() throws IOException {
        int[][] data = parseInput();
        HashMap<Integer, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < data[0].length; i++) {
            if(m1.containsKey(data[0][i])) {
                m1.put(data[0][i], m1.get(data[0][i]) + 1);
            } else {
                m1.put(data[0][i], 1);
            }
            if(m2.containsKey(data[1][i])) {
                m2.put(data[1][i], m2.get(data[1][i]) + 1);
            } else {
                m2.put(data[1][i], 1);
            }
        }
        long sum = 0;
        for (int key : m1.keySet()) {
            if(m2.containsKey(key)) {
                sum+=key*m1.get(key)*m2.get(key);
            }
        }
        System.out.println(sum);
    }

    private static void partOne() throws IOException {
        int[][] data = parseInput();
        Arrays.sort(data[0]);
        Arrays.sort(data[1]);

        int sum = 0;
        for (int i = 0; i < data[0].length; i++) {
            sum += Math.abs(data[0][i] - data[1][i]);
        }
        System.out.println(sum);
    }

    public static int[][] parseInput() throws IOException {
        List<String> listOfStrings = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("input.txt"))) {
            String line = bf.readLine();
            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }
        }

        int[][] data = new int[2][listOfStrings.size()];
        for (int i = 0; i < listOfStrings.size(); i++) {
            String[] dat = listOfStrings.get(i).split("   ");
            data[0][i] = Integer.parseInt(dat[0]);
            data[1][i] = Integer.parseInt(dat[1]);
        }
        return data;
    }
}
