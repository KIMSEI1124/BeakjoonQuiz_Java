import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * IDEA 01 : 0번 부터 시작하여 크루스칼 알고리즘을 사용하여 최소 거리를 구합니다.
 * 정점과 간선의 수가 비슷하기 때문에 프림과 큰 차이가 없습니다.
 * 이후 전체 금액에서 구한 최소 금액을 빼면 절약할 수 있는 금액을 얻을 수 있습니다.
 */
public class Q6497 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int END = 0;
    private static final StringBuilder answer = new StringBuilder();
    private static int totalPrice;

    private static int m; // 집의 수 (1 <= m <= 200,000)
    private static int n; // 길의 수 (m-1 <= n <= 200,000)
    private static List<Home> homes;

    public static void main(String[] args) throws IOException {
        while (input()) {
            solve();
        }
        System.out.println(answer);
    }

    private static boolean input() throws IOException {
        /* 도시 정보 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        if (m == END && n == END) {
            return false;
        }

        /* 집 정보 초기화 및 입력 */
        totalPrice = 0;
        homes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            homes.add(Home.init());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            /* 마지막 줄에는 `0 0`이 입력 */
            int z = Integer.parseInt(st.nextToken());
            /* 전체 비용 구하기 */
            totalPrice += z;

            /* 왕래할 수 있는 경로를 설정 */
            homes.get(x).addRoad(Road.of(y, z));
            homes.get(y).addRoad(Road.of(x, z));
        }

        return true;
    }

    private static void solve() {
        /* 우선순위 큐 초기화 및 시작지점 추가 */
        PriorityQueue<Road> priorityQueue = initQueue();
        homes.get(0).offerTo(priorityQueue, homes);
        homes.get(0).visit();

        int price = 0;

        while (!priorityQueue.isEmpty()) {
            Road road = priorityQueue.poll();
            Home toHome = homes.get(road.toHome());

            /* 이미 방문한 집이면 */
            if (toHome.isVisited()) {
                continue;
            }

            /* 방문 여부 확인후 거리 추가 및 큐 업데이트 */
            toHome.visit();
            toHome.offerTo(priorityQueue, homes);
            price += road.getDistance();
        }

        /* 절약한 비용 구하기 */
        answer.append(totalPrice - price).append("\n");
    }

    private static PriorityQueue<Road> initQueue() {
        return new PriorityQueue<>(Comparator.comparingInt(Road::getDistance));
    }

    private static class Home {
        private final List<Road> roads;
        private boolean visited;

        private Home() {
            roads = new ArrayList<>();
        }

        public static Home init() {
            return new Home();
        }

        public void visit() {
            visited = true;
        }

        public boolean isVisited() {
            return visited;
        }

        public void addRoad(Road road) {
            roads.add(road);
        }

        public void offerTo(PriorityQueue<Road> queue, List<Home> homes) {
            for (Road road : roads) {
                if (homes.get(road.toHome()).isVisited()) {
                    continue;
                }
                queue.offer(road);
            }
        }
    }

    private static class Road {
        private final int to;
        private final int distance;

        private Road(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        public static Road of(int to, int distance) {
            return new Road(to, distance);
        }

        public int toHome() {
            return to;
        }

        public int getDistance() {
            return distance;
        }
    }
}
