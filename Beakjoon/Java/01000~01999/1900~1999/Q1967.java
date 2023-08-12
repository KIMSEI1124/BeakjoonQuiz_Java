
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1967 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Integer, Node> tree = new HashMap<>();
    private static final Set<Integer> parentsNode = new HashSet<>();

    private static int answer;
    private static int n; // 노드의 개수 `1 <= n <= 10,000`

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 기본 정보 입력 */
        n = Integer.parseInt(br.readLine());

        /* 트리 정보 입력 */
        tree.put(1, new Node(0, 0)); // 루트 노드를 저장
        for (int i = 0; i < n - 1; i++) { // 둘째 줄 부터 `n - 1` 줄에 정보가 들어오기 때문에 `n - 1`로 설정
            addNode();
        }
    }

    /**
     * parent : 부모 노드의 인덱스<br />
     * child : 자식 노드의 인덱스<br />
     * weight : 자식 노드의 가중치<br />
     * <p>
     * 트리에 노드의 정보를 저장한다.
     */
    private static void addNode() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        int child = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        tree.put(child, new Node(weight, parent));
        parentsNode.add(parent);
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            if (parentsNode.contains(i)) { // `leaf`가 아닐 경우 continue
                continue;
            }
            dfs(i);
        }
    }

    /**
     * `Bottom-Top` 방식으로 조회
     */
    private static void dfs(int index) {
        /* 자식 노드 조회 */
        Node childNode = tree.get(index);

        /* 최대 지름 수정 */
        answer = Math.max(answer, childNode.getMaxWeight());

        /* 루트 노드 도달시 종료 */
        if (index == 1) {
            return;
        }

        /* 부모 노드 조회 */
        int parentIndex = childNode.getParentEdge();
        Node parentNode = tree.get(parentIndex);

        /* 부모 노드의 간선 가중치 수정 및 탐색 */
        parentNode.updateWeight(new Weight(childNode.getFirstWeightEdge() + parentNode.getWeight(), index));

        dfs(childNode.getParentEdge());
    }

    private static class Node {
        private final int weight;
        private final int parentEdge;
        private Weight firstWeightEdge = new Weight(0, 0); // 가중치가 가장 큰 것
        private Weight secondWeightEdge = new Weight(0, 0); // 가중치가 두번째로 큰 것

        public Node(int weight, int parentEdge) {
            this.weight = weight;
            this.parentEdge = parentEdge;
        }

        /**
         * 자식 노드의 가중치를 입력받는다.<br />
         * 해당 가중치가 저장된 가중치 보다 큰 경우 값을 교체한다.
         *
         * @param weight 자식 노드의 가중치
         */
        public void updateWeight(Weight weight) {
            if (weight.getWeight() > firstWeightEdge.getWeight()) { // 가장 큰 간선보다 클 경우
                if (weight.getChildEdge() != firstWeightEdge.getChildEdge()) { // 첫 번째 간선과 두 번째 간선이 중복되지 않게
                    secondWeightEdge = firstWeightEdge;
                }
                firstWeightEdge = weight;
            }
            if (weight.getWeight() > secondWeightEdge.getWeight()
                    && weight.getChildEdge() != firstWeightEdge.getChildEdge()) { // 두 번째 간선보다 크고 첫 번째 간선과 중복되지 않게
                secondWeightEdge = weight;
            }
        }

        /**
         * 간선 중 가장 가중치가 높은 두개의 간선의 합을 반환합니다.<br/>
         * Weight 에는 자신의 가중치도 포함되어 있기 때문에 제거합니다.
         *
         * @return 두 간선의 최대 가중치의 합
         */
        public int getMaxWeight() {
            return Math.max(firstWeightEdge.getWeight() - weight, 0) +
                    Math.max(secondWeightEdge.getWeight() - weight, 0);
        }

        public int getWeight() {
            return weight;
        }

        public int getParentEdge() {
            return parentEdge;
        }

        public int getFirstWeightEdge() {
            if (firstWeightEdge.getChildEdge() == 0) { // `leaf`일 경우
                return weight;
            }
            return firstWeightEdge.getWeight();
        }
    }

    private static class Weight {
        private final int value;
        private final int childEdge;

        public Weight(int value, int childEdge) {
            this.value = value;
            this.childEdge = childEdge;
        }

        public int getWeight() {
            return value;
        }

        public int getChildEdge() {
            return childEdge;
        }
    }
}