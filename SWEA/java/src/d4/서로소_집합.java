package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int UNION = 0;
    private static StringTokenizer st;

    private static int t;   // 테스트 케이스의 개수
    private static int n;   // 초기 집합의 개수
    private static int m;   // 연산의 개수
    private static Node[] nodes;  // 서로소

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            answer.append("#").append(i).append(" ").append(solve()).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 문제 정보 입력 */
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = Node.from(i);
        }
    }

    private static String solve() throws IOException {
        StringBuilder result = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (code == UNION) {
                union(a, b);
                continue;
            }
            result.append(isSameRepresentative(a, b) ? "1" : "0");
        }
        return result.toString();
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        nodes[bRoot].setRepresentative(nodes[aRoot]);
        return true;
    }

    private static int find(int id) {
        if (nodes[id].getRepresentativeId() == nodes[id].getId()) {
            return id;
        }
        nodes[id].setRepresentative(nodes[find(nodes[id].getRepresentativeId())]);
        return nodes[id].getId();
    }

    private static boolean isSameRepresentative(int a, int b) {
        return find(a) == find(b);
    }

    private static class Node {
        private final int id;
        private Node representative;

        private Node(int id) {
            this.id = id;
            this.representative = this;
        }

        public static Node from(int id) {
            return new Node(id);
        }

        public int getId() {
            return id;
        }

        public int getRepresentativeId() {
            return representative.getId();
        }

        public void setRepresentative(Node representative) {
            this.representative = representative;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", representative=" + representative.getId() +
                    '}';
        }
    }
}
