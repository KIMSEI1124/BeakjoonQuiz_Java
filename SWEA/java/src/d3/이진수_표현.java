package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진수_표현 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            answer.append("#").append(i).append(" ").append(getResult()).append("\n");
        }
        System.out.println(answer);
    }

    private static String getResult() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 마지막 n 비트의 개수
        int m = Integer.parseInt(st.nextToken());   // m
        int mask = (1 << n) - 1;

        if ((m & mask) == mask) {
            return "ON";
        }

        return "OFF";
    }
}
