package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소_집합 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int UNION = 0;
    private static StringTokenizer st;

    private static int t;   // 테스트 케이스의 개수
    private static int n;   // 초기 집합의 개수
    private static int m;   // 연산의 개수
    private static int[] parents;

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

        /* `n`개 만큼의 집합 만들기 */
        make();
    }

    private static void make() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
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
            result.append(isSameParent(a, b) ? "1" : "0");
        }
        return result.toString();
    }

    private static int find(int id) {
        if (id == parents[id]) {
            return id;
        }
        return parents[id] = find(parents[id]);
    }

    private static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}
