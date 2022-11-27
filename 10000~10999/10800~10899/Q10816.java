import java.io.*;
import java.util.*;

public class Q10816 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().forEach(t -> {
            map.put(t, map.getOrDefault(t, 0) + 1);
        });

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int cardNumber = Integer.parseInt(st.nextToken());
            answer.append(map.getOrDefault(cardNumber, 0)).append(" ");
        }

        warnException(N, M);
        System.out.println(answer);
    }

    private static void warnException(int N, int M) {
        return;
    }
}