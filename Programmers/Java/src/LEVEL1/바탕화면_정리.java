package LEVEL1;

import java.util.ArrayDeque;
import java.util.Deque;

public class 바탕화면_정리 {
    private static int[] answer;
    private static Deque<File> deque;

    public int[] solution(String[] wallpaper) {
        init(wallpaper);
        solve();
        return answer;
    }

    private void init(String[] wallpaper) {
        answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        deque = new ArrayDeque<>();
        for (int i = 0; i < wallpaper.length; i++) {
            String[] split = wallpaper[i].split("\"");
            for (int j = 0; j < split.length; j++) {
                deque.offer(new File(i, j));
            }
        }
    }

    private void solve() {
        while (!deque.isEmpty()) {
            File file = deque.poll();
            answer[0] = Math.min(answer[0], file.getX());
            answer[1] = Math.min(answer[1], file.getY());
            answer[2] = Math.max(answer[2], file.getX());
            answer[3] = Math.max(answer[3], file.getY());
        }
    }

    private static class File {
        private int y;
        private int x;

        public File(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
