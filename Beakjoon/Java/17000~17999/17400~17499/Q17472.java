import java.io.*;
import java.util.*;

public class Q17472 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int N, M;

    private static int id;
    private static int[][] area;
    private static boolean[][] visitedByIslands;

    private static boolean[] visitedByIslandsId;
    private static Island[] islands;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(Arrays.toString(islands));
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        visitedByIslands = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }

        islands = new Island[7];
        for (int i = 0; i < 7; i++) {
            islands[i] = Island.Init();
        }
        visitedByIslandsId = new boolean[7];
    }

    private static void solve() {
        setIslandId();
        getIslandsDistance();

        boolean[] visitedByBridge = new boolean[7];
        PriorityQueue<Bridge> pq = new PriorityQueue<>();

        visitedByBridge[1] = true;
        for (int i = 0; i < islands[1].getBridgeQuantity(); i++) {
            for (int j = 1; j <= id; j++) {
                if (islands[1].getDistanceById(j) == -1) {
                    continue;
                }
                pq.offer(Bridge.of(j, islands[1].getDistanceById(j)));
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq);
            Bridge bridge = pq.poll();
            answer += bridge.getDistance();
            for (int i = 0; i < islands[bridge.getId()].getBridgeQuantity(); i++) {
                for (int j = 1; j <= id; j++) {
                    if (visitedByBridge[j] || islands[bridge.getId()].getDistanceById(j) == -1) {
                        continue;
                    }
                    visitedByBridge[bridge.getId()] = true;
                    pq.offer(Bridge.of(j, islands[bridge.getId()].getDistanceById(j)));
                }
            }
        }
    }

    private static int[] dy = { -1, 0, 0, 1 };
    private static int[] dx = { 0, -1, 1, 0 };

    private static void setIslandId() {

        id = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == -1) {
                    setIslandIdWithDfs(i, j, id++);
                }
            }
        }
    }

    private static void setIslandIdWithDfs(int y, int x, int id) {
        area[y][x] = id;
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY < 0 || newY >= N || newX < 0 || newX >= M || area[newY][newX] != -1) {
                continue;
            }
            setIslandIdWithDfs(newY, newX, id);
        }
    }

    private static void getIslandsDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0 && !visitedByIslandsId[area[i][j]]) {
                    searchDistanceToIsland(i, j, area[i][j]);
                    visitedByIslandsId[area[i][j]] = true;
                }
            }
        }
    }

    private static void searchDistanceToIsland(int y, int x, int id) {
        visitedByIslands[y][x] = true;

        /* 다리 놓으면서 탐색 2인 이유는 다리는 한번만 탐색하면 되기 때문에 */
        for (int i = 0; i < 2; i++) {
            searchDistanceWithDfs(y, x, area[y][x], i, 0);
        }

        /* 붙어 있는 섬 탐색 */
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY < 0 || newY >= N || newX < 0 || newX >= M || visitedByIslands[newY][newX]) {
                continue;
            }
            searchDistanceToIsland(newY, newX, id);
        }
    }

    private static void searchDistanceWithDfs(int y, int x, int id, int delta, int distance) {
        int newY = y + dy[delta];
        int newX = x + dx[delta];

        if (newY < 0 || newY >= N || newX < 0 || newX >= M || area[newY][newX] == id) {
            return;
        }

        if (area[newY][newX] != 0 && area[newY][newX] != id) {
            /* 다리의 길이가 2 중복하여 탐색하지 않도록 저장 */
            if (distance >= 2) {
                islands[id].updateDistanceById(area[newY][newX], distance);
                islands[area[newY][newX]].updateDistanceById(id, distance);
            }
            return;
        }

        searchDistanceWithDfs(newY, newX, id, delta, distance + 1);
    }

    private static class Island {
        private Map<Integer, Integer> distances;

        private Island() {
            distances = new HashMap<>();
        }

        public static Island Init() {
            return new Island();
        }

        public int getBridgeQuantity() {
            return distances.size();
        }

        public int getDistanceById(int id) {
            return distances.getOrDefault(id, -1);
        }

        public void updateDistanceById(int id, int distance) {
            distances.put(id, Math.min(distance, distances.getOrDefault(id, Integer.MAX_VALUE)));
        }

        @Override
        public String toString() {
            return "{" + distances + "}";
        }
    }

    private static class Bridge implements Comparable<Bridge> {
        private int id;
        private int distance;

        private Bridge(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        public static Bridge of(int id, int distance) {
            return new Bridge(id, distance);
        }

        public int getId() {
            return id;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Bridge other) {
            return Integer.compare(distance, other.getDistance());
        }

        @Override
        public String toString() {
            return "{ id : " + id + ", distance : " + distance + "}";
        }
    }
}