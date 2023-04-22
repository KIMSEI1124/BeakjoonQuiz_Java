import java.io.*;
import java.util.*;

public class Q2573 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;
    private static StringTokenizer st;
    private static int[][] area;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            area[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        while (true) {
            visited = new boolean[N][M];
            printArray();
            if (melt(N, M)) {
                answer++;
                continue;
            }
            break;
        }

        System.out.println(answer);
    }

    private static void printArray() {
        System.out.println("day : " + answer);
        for (int i = 0; i < area.length; i++) {
            System.out.println(Arrays.toString(area[i]));
        }
    }

    private static int[] dx = { -1, 0, 0, 1 };
    private static int[] dy = { 0, -1, 1, 0 };

    private static boolean melt(int N, int M) {
        boolean isMelt = false;
        for (int i = 0; i < N; i++) { // y
            for (int j = 0; j < M; j++) { // x
                if (area[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        if (y < 0 || N <= y) {
                            continue;
                        }
                        int x = j + dx[k];
                        if (x < 0 || M <= x) {
                            continue;
                        }
                        if (visited[y][x]) {
                            continue;
                        }
                        if (area[y][x] == 0 && area[i][j] != 0) {
                            area[i][j] -= 1;
                            visited[i][j] = true;
                            isMelt = true;
                        }
                    }
                }
            }
        }
        return isMelt;
    }
}