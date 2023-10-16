package LEVEL3;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 풀이 : 단순 그래프 탐색 문제입니다.
 * 인접 행렬로 되어 있는 그래프를 인접 리스트로 변경후 `DFS`를 돌렸습니다.
 * 시간: 1.28ms
 * 메모리: 79.4MB
 */
public class 네트워크 {
    private int answer;
    private int n;
    private List<List<Integer>> networks;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        init(n, computers);
        solve();
        return answer;
    }

    private void init(int n, int[][] computers) {
        this.n = n;

        networks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            networks.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] computer = computers[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (computer[j] == 1) {
                    networks.get(i).add(j);
                    networks.get(j).add(i);
                }
            }
        }

        visited = new boolean[n];
    }

    private void solve() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
    }

    private void dfs(int index) {
        visited[index] = true;

        for (int network : networks.get(index)) {
            if (visited[network]) {
                continue;
            }
            dfs(network);
        }
    }
}
