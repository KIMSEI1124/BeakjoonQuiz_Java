import java.io.*;
import java.util.*;

public class Q2576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        for (Integer number : list) {
            if (number % 2 != 0) {
                total += number;
                min = Math.min(number, min);
            }
        }
        if (total != 0) {
            answer.append(total).append("\n").append(min);
        } else {
            answer.append("-1");
        }
        System.out.println(answer);
    }
}