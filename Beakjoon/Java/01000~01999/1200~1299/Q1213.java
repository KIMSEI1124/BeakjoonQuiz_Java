import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1213 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean notError = true;
        StringBuilder half = new StringBuilder();
        Character middle = null;

        for (Character key : map.keySet().stream().sorted().collect(Collectors.toList())) {
            int quantity = map.get(key);
            if (quantity % 2 != 0) {
                if (middle == null) {
                    middle = key;
                } else {
                    answer = new StringBuilder("I'm Sorry Hansoo");
                    notError = false;
                    break;
                }
            }
            half.append(String.valueOf(key).repeat(quantity / 2));
        }

        if (notError) {
            answer.append(half);
            if (middle != null) {
                answer.append(middle);
            }
            answer.append(half.reverse());
        }

        System.out.println(answer);
    }
}