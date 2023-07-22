import java.io.*;
import java.util.*;

public class Q1592 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 공을 받은 횟수
        int l = Integer.parseInt(st.nextToken()); // 범위

        int[] array = new int[n + 1];
        int idx = 1;

        while (true) {
            array[idx]++;

            if (array[idx] == m) {
                break;
            }

            if (array[idx] % 2 == 0) {
                idx -= l;
                if (idx < 1) {
                    idx = n + idx;
                }
            } else {
                idx += l;
                if (idx > n) {
                    idx = idx - n;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}