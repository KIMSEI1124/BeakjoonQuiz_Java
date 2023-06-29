import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1159 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine().substring(0, 1);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        map.forEach((word, count) -> {
            if (count >= 5) {
                list.add(word);
            }
        });
        if (list.size() > 0) {
            list.stream().sorted().forEach(t -> answer.append(t));
        }
        if (list.size() == 0) {
            answer.append("PREDAJA");
        }
        System.out.println(answer);
    }
}