package LEVEL3;

import java.util.ArrayList;
import java.util.List;

public class 등산코스_정하기 {

    private static int n;
    private static List<Road> paths;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        init(n, paths, gates, summits);
        return answer;
    }

    private void init(int n, int[][] paths, int[] gates, int[] summits) {
        this.n = n;

        this.paths = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            this.paths.add(new Road());
        }

        for (int gate : gates) {
            this.paths.get(gate).changeGate();
        }

        for (int summit : summits) {
            this.paths.get(summit).changeSummit();
        }

        for (int[] path : paths) {
            int to = path[0];
            int from = path[1];
            int value = path[2];
            this.paths.get(to).addEdge(from, value);
            this.paths.get(from).addEdge(to, value);
        }
    }

    private void solve(int[] gates) {
        for (int gate : gates) {

        }
    }

    private void dfs(int idx) {

    }

    private static class Road {
        private List<Edge> edge;

        private String type;    // path, gate, summit

        public Road() {
            this.edge = new ArrayList<>();
            this.type = "path";
        }

        public List<Edge> getEdge() {
            return edge;
        }

        public String getType() {
            return type;
        }

        public void changeGate() {
            type = "gate";
        }

        public void changeSummit() {
            type = "summit";
        }

        public void addEdge(int from, int value) {
            edge.add(new Edge(from, value));
        }
    }

    private static class Edge {
        private int from;
        private int value;

        public Edge(int from, int value) {
            this.from = from;
            this.value = value;
        }

        public int getFrom() {
            return from;
        }

        public int getValue() {
            return value;
        }
    }
}
