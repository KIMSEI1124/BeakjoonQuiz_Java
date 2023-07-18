import java.io.*;
import java.util.*;

public class Q2206 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final char ROAD = '0';
    private static final char WALL = '1';

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n + 1][m + 1];
        boolean[][][] visited = new boolean[n + 1][m + 1][2];

    }

    private class Pos<Y, X> {
        private Y y;
        private X x;

        Pos(Y y, X x) {
            this.y = y;
            this.x = x;
        }

        public Y getY() {
            return y;
        }

        public X getX() {
            return x;
        }
    }
}