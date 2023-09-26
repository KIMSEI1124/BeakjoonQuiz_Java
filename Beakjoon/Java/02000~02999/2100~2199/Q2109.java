import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2109 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PriorityQueue<Work> works;
    private static int n;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        works = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works.offer(Work.from(st));
        }
    }

    private static void solve() {
        boolean[] visited = new boolean[10_001];
        while (!works.isEmpty()) {
            Work work = works.poll();
            for (int day = work.getDay(); day >= 1; day--) {
                if (!visited[day]) {
                    visited[day] = true;
                    answer += work.getFee();
                    break;
                }
            }
        }
    }

    private static class Work implements Comparable<Work> {
        private final int day;
        private final int fee;

        private Work(int day, int fee) {
            this.day = day;
            this.fee = fee;
        }

        public static Work from(StringTokenizer st) {
            int fee = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            return new Work(day, fee);
        }

        public int getDay() {
            return day;
        }

        public int getFee() {
            return fee;
        }

        @Override
        public int compareTo(Work o) {
            if (this.fee != o.getFee()) {
                return o.getFee() - this.fee;
            }
            return this.day - o.getDay();
        }

        @Override
        public String toString() {
            return "{" +
                    "day=" + day +
                    ", fee=" + fee +
                    '}';
        }
    }
}