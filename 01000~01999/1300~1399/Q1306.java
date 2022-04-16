import java.io.*;
import java.util.*;

public class Q1306 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] track = new int[N];
        for (int i = 0; i < N; i++) {
            track[i] = Integer.parseInt(st2.nextToken());
        }

        int start_Point = M; // 시작점
        int end_Point = N - M + 1; // 종료점
        int view = 2 * M - 1; // 시야

        // solve
        int real_Max = 0;
        // 2 3
        for (int i = start_Point-1; i < end_Point; i++) {
            int start_View = i - (view / 2);
            int end_View = i + (view / 2);
            System.out.println(end_View);
            if (i == start_Point) { // 시작점에서 최대값 구하기
                for (int j = start_View; j < end_View; j++) {
                    if (track[j] > real_Max) {
                        real_Max = track[j];
                    }
                }
            } else { // 윈도우 슬라이딩 하면서 구하기
                if (track[end_View] > real_Max) {
                    real_Max = track[end_View];
                }
            }
            sb.append(real_Max).append(" ");
        }

        /*
         * for (int i = start_Point - 1; i < end_Point; i++) {
         * int max = 0;
         * int view2 = view / 2;
         * for (int j = i + (-1 * view2); j <= i + view2; j++) {
         * if (track[j] > max) {
         * max = track[j];
         * }
         * }
         * sb.append(max).append(" ");
         * }
         */
        System.out.print(sb);
    }
}