import java.io.*;
import java.util.*;

public class Q10807 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        solvedFor();
        solvedMap();
    }

    private static void solvedFor() throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[st.countTokens()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int V = Integer.parseInt(br.readLine());
        int count = 0;
        for (Integer number : numbers) {
            if (number == V) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void solvedMap() throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int V = Integer.parseInt(br.readLine());
        if(map.containsKey(V)) {
            System.out.println(map.get(V));
        } else {
            System.out.println("0");
        }
    }
}