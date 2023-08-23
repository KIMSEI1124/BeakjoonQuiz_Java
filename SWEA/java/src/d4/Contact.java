package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Contact {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static int size;    // 데이터의 길이
    private static int start;   // 시작 지점

    private static List<Set<Integer>> networks;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 10; i++) {
            input();
            answer.append("#").append(i).append(" ").append(solve()).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        /* 네트워크 초기화 : 인원은 최대 100명 */
        networks = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            networks.add(new HashSet<>());
        }

        /* 데이터 추가 */
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            networks.get(from).add(to);
        }
    }

    private static int solve() {
        /* 최대값 저장 변수 초기화 */
        int maxValue;

        /* BFS 변수 초기화 */
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[networks.size()];

        /* 기본값 설정 */
        queue.add(start);
        visited[start] = true;

        /* BFS 탐색 */
        while (true) {
            /* 새로운 시간이 되면 초기화 */
            int loop = queue.size();
            maxValue = 0;
            while (loop-- > 0) {
                int id = queue.poll();
                maxValue = Math.max(maxValue, id);

                for (int nextId : networks.get(id)) {
                    if (visited[nextId]) {
                        continue;
                    }
                    visited[nextId] = true;
                    queue.offer(nextId);
                }
            }
            /* 더 이상 연락할 수 없으면 종료 */
            if (queue.isEmpty()) {
                break;
            }
        }

        return maxValue;
    }
}
