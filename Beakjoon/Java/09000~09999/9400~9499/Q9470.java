import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * IDEA1 : 부모에서 자식을 조회하며 가장 큰 간선 2개를 저장한 후 가중치를 구한다.
 * 결과 : 12% Failed
 */

/*
 * IDEA2 : 1번 생각에서 반례를 찾았다. 자신의 모든 부모가 조회 했을 때 자식을 조회해야 한다.
 * 결과
 * 시간 : 128ms
 * 메모리 : 14228KB
 */
public class Q9470 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static int K; // (1 <= K <= 1,000) 테스트 케이스 번호
    private static int M; // (2 <= M <= 1,000) 노드의 수
    private static int P; // 간선의 수
    private static River[] rivers;
    private static Set<Integer> notStart;
    private static boolean[] visited;
    private static int result; // 가장 큰 하천계의 크기

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append(K).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st;

        /* 테스트 케이스 입력 */
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        result = 0;

        /* 하천 초기화 및 입력 */
        rivers = new River[M + 1];
        notStart = new HashSet<>();
        visited = new boolean[M + 1];
        for (int i = 1; i <= M; i++) {
            rivers[i] = River.from(i);
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int children = Integer.parseInt(st.nextToken());
            notStart.add(children);
            rivers[parent].addChildren(children);
            rivers[children].addParent(parent);
        }
    }

    private static void solve() {
        Queue<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= M; i++) {
            if (!notStart.contains(i)) {
                visited[i] = true;
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int parent = deque.poll();
            for (int children : rivers[parent].getChildren()) {
                rivers[children].addParentWeight(rivers[parent].getWeight());
                if (rivers[children].removeParent(parent)) {
                    deque.add(children);
                }
            }
        }

        result = rivers[M].getWeight();
    }

    private static class River {
        private final int id;
        private final int[] parentsWeight;
        private final List<Integer> children;
        private final Set<Integer> parents;
        private int weight;

        private River(int id) {
            this.id = id;
            parentsWeight = new int[] { 0, 0, 0 };
            this.weight = swapWeight();
            children = new ArrayList<>();
            parents = new HashSet<>();
        }

        public static River from(int id) {
            return new River(id);
        }

        public int getId() {
            return id;
        }

        public int getWeight() {
            return weight;
        }

        public void addParentWeight(int weight) {
            /* 더미 영역을 만들어서 `0`번 자리는 정렬 후 사용하지 않음 */
            parentsWeight[0] = weight;
            Arrays.sort(parentsWeight);
            /* 가장 큰 값이 두개 이면 i + 1, 아니면 i */
            this.weight = swapWeight();
        }

        private int swapWeight() {
            return parentsWeight[2] == parentsWeight[1]
                    ? parentsWeight[2] + 1
                    : parentsWeight[2];
        }

        public void addChildren(int child) {
            children.add(child);
        }

        public List<Integer> getChildren() {
            return children;
        }

        public void addParent(int parent) {
            parents.add(parent);
        }

        public boolean removeParent(int parent) {
            parents.remove(parent);
            return parents.isEmpty();
        }
    }
}
