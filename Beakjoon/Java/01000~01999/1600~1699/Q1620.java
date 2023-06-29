import java.io.*;
import java.util.*;

public class Q1620 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        String input;
        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            numberMap.put(i, input);
            nameMap.put(input, i);
        }

        while (T-- > 0) {
            input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                /* 도감 번호로 주어질 경우 */
                answer.append(numberMap.get(Integer.parseInt(input)));
            } else {
                /* 이름으로 주어질 경우 */
                answer.append(nameMap.get(input));
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}