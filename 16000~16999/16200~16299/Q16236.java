import java.io.*;
import java.util.*;

public class Q16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] sea;
    static int[] eat_fish = new int[7]; // 2 ~ 6, 아기 상어가 먹은 물고기의 수
    static int[] fish_count = new int[7]; // 1 ~ 6, 공간안에 있는 물고기의 수

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        sea = new int[N + 1][N + 1];

        int[] shark_pos = new int[2]; // 상어의 시작 좌표
        int shark_size = 2; // 상어의 크기

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    shark_pos[0] = i;
                    shark_pos[1] = j;
                } else if (sea[i][j] != 0) {
                    fish_count[sea[i][j]]++;
                }
            }
        }

        // solve
        

        // output
        System.out.println(ans);
    }
}