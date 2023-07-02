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

            List<Integer> list = getList();
            int count = getCount(list);

            answer.append(count).append("\n");
        }

        System.out.println(answer);
    }

    private static List<Integer> getList() throws IOException {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] item = br.readLine().split(" ");
            if (map.containsKey(item[1])) {
                map.put(item[1], map.get(item[1]) + 1);
                continue;
            }
            map.put(item[1], 1);
        }

        return new ArrayList<>(map.values());
    }

    private static int getCount(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }

        int count = 1;
        for (Integer quantity : list) {
            count *= quantity + 1;
        }

        return count - 1;
    }
}