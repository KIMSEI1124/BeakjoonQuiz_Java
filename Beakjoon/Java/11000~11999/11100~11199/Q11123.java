import java.io.*;
import java.util.*;

public class Q11123 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[][] area = getArea();
            answer.append(getResult(area)).append("\n");
        }
        System.out.println(answer);
    }

    private static char[][] getArea() throws IOException {
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] area = new char[H][W];
        for (int i = 0; i < H; i++) {
            area[i] = br.readLine().toCharArray();
        }
        return area;
    }

    private static int getResult(char[][] area) {
        int result = 0;
        boolean[][] visited = new boolean[area.length][area[0].length];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == '#' && !visited[i][j]) {
                    search(area, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static final int[] dy = { -1, 0, 0, 1 };
    private static final int[] dx = { 0, -1, 1, 0 };

    private static void search(char[][] area, boolean[][] visited, int i, int j) {
        Deque<Pos<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pos<>(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Pos<Integer, Integer> pos = queue.poll();
            int y = pos.getY();
            int x = pos.getX();
            for (int k = 0; k < 4; k++) {
                int newY = y + dy[k];
                if (newY < 0 || newY >= area.length) {
                    continue;
                }
                int newX = x + dx[k];
                if (newX < 0 || newX >= area[0].length) {
                    continue;
                }
                if (visited[newY][newX] || area[newY][newX] == '.') {
                    continue;
                }
                queue.add(new Pos<>(newY, newX));
                visited[newY][newX] = true;
            }
        }
    }

    private static class Pos<X, Y> {
        private X x;
        private Y y;

        public Pos(Y y, X x) {
            this.y = y;
            this.x = x;
        }

        public X getX() {
            return this.x;
        }

        public Y getY() {
            return this.y;
        }
    }
}
