import java.io.*;
import java.util.*;

public class Q2343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M; // 강의의 수, 블루레이의 수
    static int[] lesson;
    static int[] bluelay;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lesson = new int[N + 1];
        bluelay = new int[M];

        st = new StringTokenizer(br.readLine());
        int id = 1;
        while (st.hasMoreTokens()) {
            lesson[id] = Integer.parseInt(st.nextToken()) + lesson[id - 1];
            id++;
        }

        // solve
        id = 0;
        int limit = lesson[N] / M; // 용량
        for (int i = N; i > 0; i--) {
            if (bluelay[id] >= limit) {
                id++;
            }
            bluelay[id] += lesson[i] - lesson[i - 1];
            System.out.println(Arrays.toString(bluelay));
        }

        // output
        System.out.println(ans);
    }
}