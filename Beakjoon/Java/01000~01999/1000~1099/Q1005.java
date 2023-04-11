import java.io.*;
import java.util.*;

public class Q1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T; // 테스트케이스의 개수
    static int N; // 건물의 개수
    static int K; // 건물간의 건설순서 규칙의 총 개수
    static int W; // 승리하기 위해 건설해야 할 건물의 번호

    static int[] real_time; // 실제 건물이 건설되는 시간
    static int[] craft_time; // 건물의 건설 시간
    static boolean[] visited; // 방문 확인
    static List<List<Integer>> cp_list; // 선행조건 리스트
    static List<List<Integer>> build_list; // 건설할 수 있는 건물들

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            // input
            st = new StringTokenizer(br.readLine()); // 건물의 개수와 건설순서 규칙의 총 개수
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            real_time = new int[N + 1];
            craft_time = new int[N + 1];
            visited = new boolean[N + 1];
            cp_list = new ArrayList<>();

            st = new StringTokenizer(br.readLine()); // 각 건물당 건설에 걸리는 시간
            for (int i = 0; i <= N; i++) {
                cp_list.add(new ArrayList<>());
                if (i != 0) {
                    craft_time[i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= K; i++) { // 2차원 배열 설정
                st = new StringTokenizer(br.readLine());
                int cp = Integer.parseInt(st.nextToken()); // 선행 조건
                int target = Integer.parseInt(st.nextToken()); // 짓는 건물
                cp_list.get(target).add(cp);
                build_list.get(cp).add(target);
            }

            W = Integer.parseInt(br.readLine()); // 건설해야할 건물 번호

            // solve
            /*
             * 조건들
             * 1) 시작이 1번 건물이 아닐수도 있다.
             * 2) 선행 조건이 종료 조건일수도 있다.
             * 2-1) 전체 탐색을 안하고도 종료 조건을 달성할수 있다.
             */
            Queue<Integer> queue = new LinkedList<>();
            // 큐로 돌린다?
            for (int i = 1; i <= N; i++) { // 조건1 해결
                if (cp_list.get(i).size() == 0) {
                    visited[i] = true;
                    queue.add(i);
                    real_time[i] = craft_time[i];
                }
            }

            while (!queue.isEmpty()) {
                int id = queue.poll();
                for (Integer build_id : build_list.get(id)) {
                    for (int i = 0; i < cp_list.get(build_id).size(); i++) {
                        
                    }
                }
                for (Integer build_id : build_list.get(id)) {
                    queue.add(build_id);
                }
            }

            System.out.println(queue);
            System.out.println("craft_time" + Arrays.toString(craft_time));
            System.out.println("real_time" + Arrays.toString(real_time));
            ans.append(real_time[W] + "\n");
            T--;
        }

        // output
        System.out.println(ans);
    }

    /**
     * 건설한 건물의 시간을 구한다.
     * 
     * @param id 건설할 건물의 번호
     * @return 건설할 건물의 총 걸리는 시간
     */
    static public int max_craft_time(int id) {
        int max_time = 0;
        for (Integer start_id : cp_list.get(id)) {
            max_time = Math.max(max_time, real_time[start_id]);
        }
        return max_time;
    }
}