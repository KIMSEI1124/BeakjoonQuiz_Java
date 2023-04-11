import java.io.*;
import java.util.*;

public class Q11651 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Point<Integer, Integer>> list = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point<Integer, Integer> point = new Point<>();
            point.setPoint(x, y);
            list.add(point);
        }
        Comparator<Point<Integer, Integer>> comparatorY = (a, b) -> a.getY() - b.getY();
        Comparator<Point<Integer, Integer>> comparatorX = (a, b) -> a.getX() - b.getX();
        list.sort(comparatorX);
        list.sort(comparatorY);
        for (Point<Integer, Integer> point : list) {
            answer.append(point.getPoint()).append("\n");
        }
        System.out.println(answer);
    }

    private static class Point<X, Y> {
        private int x;
        private int y;

        public void setPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public String getPoint() {
            return this.x + " " + this.y;
        }
    }
}