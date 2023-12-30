import java.io.*;
import java.util.*;

public class Q5077 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int n;
    private static char[][] map;
    private static List<Grid> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        for (int r = 0; r < map.length; r++) {
            map[r] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            list.add(Grid.makeGrid());
        }
    }

    private static void solve() {
        for (Grid grid : list) {
            answer.append(grid.getMirrorCount(map));
        }
    }

    private static class Grid {
        private static char[][] map;

        public Grid() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            for (int r = 0; r < map.length; r++) {
                map[r] = br.readLine().toCharArray();
            }
        }

        private static Grid makeGrid() throws IOException {
            return new Grid();
        }

        public int getMirrorCount(char[][] map) {
            int count = 0;
            for (int r = 0; r < this.map.length; r++) {
                for (int c = 0; c < this.map[0].length; c++) {
                    if (isSame(map, r, c)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isSame(char[][] map, int r, int c) {
            for (int dr = 0; dr < map.length; dr++) {
                for (int dc = 0; dc < map[0].length; dc++) {
                    if (r + dr >= this.map.length || c + dc >= this.map[0].length - 1
                            || this.map[r + dr][c + dc] != map[dr][dc]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}