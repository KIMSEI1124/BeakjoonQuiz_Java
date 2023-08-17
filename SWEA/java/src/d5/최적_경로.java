package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최적_경로 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int COMPANY = 0;
    private static final int HOME = 1;

    private static boolean[] visited;
    private static int optimumPath; // 최적 경로

    private static int customerCount;   // 고객의 수
    private static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(optimumPath).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        customerCount = Integer.parseInt(br.readLine());

        /* grid, optimumPath 초기화 */
        visited = new boolean[customerCount + 2];
        optimumPath = Integer.MAX_VALUE;
        nodes = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x;  // `x`좌표
        int y;  // `y`좌표

        /* 회사 입력 */
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        nodes.add(Node.of(0, y, x));

        /* 집 입력 */
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        nodes.add(Node.of(1, y, x));

        /* 고객 입력 */
        for (int i = 2; i < customerCount + 2; i++) {
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nodes.add(Node.of(i, y, x));
        }
    }

    private static void solve() {
        getPath();
        dfs(COMPANY, 1, 0);    // 회사부터 출발
    }

    private static void getPath() {
        for (int i = 0; i < nodes.size() - 1; i++) {
            Node node = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                node.addPath(nodes.get(j));
            }
        }
    }

    /**
     * @param id   방문 노드의 고유 번호
     * @param cnt  방문 횟수
     * @param path 경로의 합
     */
    private static void dfs(int id, int cnt, int path) {
        /* 최적 경로보다 더 먼 경로이면 종료 */
        if (path > optimumPath) {
            return;
        }

        /* 집에 도달하였지만 모든 고객의 집에 방문하지 않았으면 종료 */
        if (id == HOME && cnt != customerCount + 2) {
            return;
        }

        /* 집에 도달하였고 모든 고객의 집에 방문하였으면 종료 */
        if (id == HOME) {
            optimumPath = path;
            return;
        }

        for (int i = 1; i < customerCount + 2; i++) {
            /* 방문하지 않았으면 방문한 뒤 방문 여부를 `true`로 변경 후 재귀 탐색을 진행한 후 방문여부를 `false`로 변경 */
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1, path + nodes.get(id).getPath(i));
                visited[i] = false;
            }
        }
    }

    /* 0은 회사, 1은 집, 나머지는 고객 */
    private static class Node {
        private final int id;
        private final int y;
        private final int x;
        private final Map<Integer, Integer> path; // Key : `Node`의 고유 번호, Value : `Node`와의 거리

        private Node(int id, int y, int x) {
            this.id = id;
            this.y = y;
            this.x = x;
            path = new HashMap<>();
        }

        public static Node of(int id, int y, int x) {
            return new Node(id, y, x);
        }

        public void addPath(Node node) {
            int distance = Math.abs(this.x - node.getX()) + Math.abs(this.y - node.getY());
            /* 양방향 매핑 */
            this.path.put(node.getId(), distance);
            node.getPath().put(this.id, distance);
        }

        public int getId() {
            return id;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public Map<Integer, Integer> getPath() {
            return path;
        }

        public int getPath(int id) {
            return path.get(id);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", y=" + y +
                    ", x=" + x +
                    ", path=" + path +
                    '}';
        }
    }
}
