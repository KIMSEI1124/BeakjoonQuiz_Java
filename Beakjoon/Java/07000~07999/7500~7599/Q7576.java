import java.io.*;
import java.util.*;

public class Q7576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
        int[][] box = getBox(N, M); // 상자
        System.out.println(getResult(box, N, M));
    }

    private static int[][] getBox(int N, int M) throws IOException {
        int[][] box = new int[N][M]; // 상자
        for (int i = 0; i < N; i++) {
            box[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return box;
    }

    private static int[] dy = { 0, -1, 0, 1 };
    private static int[] dx = { -1, 0, 1, 0 };

    private static int getResult(int[][] box, int N, int M) {
        int count = 0;
        Deque<Pos<Integer, Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int idx = box[i][j];
                if (idx == 1) {
                    queue.add(new Pos<Integer, Integer>(j, i));
                }
                if (idx == 0) {
                    count++;
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int loop = queue.size();
            boolean isChange = false;
            while (loop-- != 0) {
                Pos<Integer, Integer> pos = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newY = pos.getY() + dy[i];
                    if (newY < 0 || newY >= N) {
                        continue;
                    }
                    int newX = pos.getX() + dx[i];
                    if (newX < 0 || newX >= M) {
                        continue;
                    }
                    if (box[newY][newX] == 0) {
                        box[newY][newX] = 1;
                        queue.add(new Pos<Integer, Integer>(newX, newY));
                        count--;
                        isChange = true;
                    }
                }
            }
            if (isChange) {
                result++;
            } else {
                break;
            }
        }
        if (count != 0) {
            return -1;
        }
        return result;
    }

    private static class Pos<X, Y> {
        private X x;
        private Y y;

        public Pos(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getX() {
            return x;
        }

        public Y getY() {
            return y;
        }
    }
}