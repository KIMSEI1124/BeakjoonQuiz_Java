import java.io.*;
import java.util.*;

public class Q9375 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int T;
    private static int N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                answer.append("0\n");
                continue;
            }

            int count = 1;
            Map<String, Integer> map = new HashMap<>();
            List<String> keys = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] item = br.readLine().split(" ");
                if (map.containsKey(item[1])) {
                    map.put(item[1], map.get(item[1]) + 1);
                    continue;
                }
                map.put(item[1], 1);
                keys.add(item[1]);
            }

            if (keys.size() == 1) {
                answer.append(N).append("\n");
                continue;
            }

            for (String key : keys) {
                count *= map.get(key);
            }
            count += N;
            answer.append(count).append("\n");
        }

        System.out.println(answer);
    }
}