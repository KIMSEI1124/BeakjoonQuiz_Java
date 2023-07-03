package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 최빈수_구하기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int testCase = Integer.parseInt(br.readLine());
            int result = getResult();
            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int number : array) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        Integer result = 0;
        int max = 0;
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (value == Math.max(max, value)) {
                max = value;
                result = key;
            }
        }

        return result;
    }
}
