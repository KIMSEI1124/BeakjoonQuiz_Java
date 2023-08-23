package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static long totalWeight;
    private static int V;
    private static int E;
    private static int[] parents;
    private static Edge[] edges;


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(totalWeight).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        totalWeight = 0L;

        /* Union - Find */
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = Edge.from(new StringTokenizer(br.readLine()));
        }
    }

    private static void solve() {
        /* 크루스칼 알고리즘은 가중치로 오름차순 정렬이 되어 있어야 합니다. */
        Arrays.sort(edges);

        int count = 0;
        for (Edge edge : edges) {
            if (union(edge.getFrom(), edge.getTo())) {
                totalWeight += edge.getWeight();
                count++;
            }
            if (count == V) {
                break;
            }
        }
    }

    private static int find(int a) {
        return a == parents[a] ? a : (parents[a] = find(parents[a]));
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }

        parents[rootB] = rootA;
        return true;
    }

    private static class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private int weight;

        private Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public static Edge from(StringTokenizer st) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            return new Edge(from, to, weight);
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.getWeight());
        }
    }
}
