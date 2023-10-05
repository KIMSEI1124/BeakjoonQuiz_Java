package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌_깨기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int T;
    private static int result;
    private static int N, W, H; // N: 구슬을 쏠 수 있는 횟수
    private static int[][] area;
    private static Block[] topBlocks;
    private static int totalBlockQuantity;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input();
            solve();
            System.out.println(totalBlockQuantity);
            answer.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st;
        result = 0;

        /* 테스트 케이스 정보 입력 */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        /* 2차원 배열 입력 */
        area = new int[H][W];
        topBlocks = new Block[W];
        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                area[r][c] = Integer.parseInt(st.nextToken());
                if (area[r][c] != 0) {
                    if (topBlocks[c] == null) {
                        topBlocks[c] = Block.of(r, c, area[r][c]);
                    }
                    totalBlockQuantity++;
                }
            }
        }
    }

    private static void solve() {
        permutation(new int[N], 0);
    }


    private static void permutation(int[] array, int count) {
        /* 구슬 발사 */
        if (count == N) {
            /* TODO: 10/5/23 구슬 게임 시작 */
            return;
        }

        /* 구슬 발사할 경로 정하기 (중복 조합) */
        for (int c = 0; c < W; c++) {
            array[count] = c;
            permutation(array, count + 1);
        }
    }

    private static class Block {
        private int r;
        private int c;
        private int number;

        private Block(int r, int c, int number) {
            this.r = r;
            this.c = c;
            this.number = number;
        }

        public static Block of(int r, int c, int number) {
            return new Block(r, c, number);
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getNumber() {
            return number;
        }
    }
}
