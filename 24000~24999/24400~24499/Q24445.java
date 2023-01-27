import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q24445 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = getList(N, M);
        getAnswer(R, list);
        System.out.println(answer);
    }

    private static List<List<Integer>> getList(int N, int M) throws IOException {
        List<List<Integer>> list = new ArrayList<>();
        while (M-- > 0) {
            list.add(new ArrayList<>());
        }
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        return list;
    }

    private static void getAnswer(int R, List<List<Integer>> list) {
        int[] visited = new int[list.size() + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(R);
        int count = 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> visitList = list.get(num).stream().sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
            visited[num] = count;
            count++;
            for (Integer integer : visitList) {
                if (visited[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        for (int i = 1; i < visited.length; i++) {
            answer.append(visited[i]).append("\n");
        }
    }
}