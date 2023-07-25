import java.io.*;
import java.util.*;

public class Q1449 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        boolean[] visited = new boolean[1001];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물이 세는 곳
        int l = Integer.parseInt(st.nextToken()); // 테이프의 길이

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) { // hasMoreToken 사용 가능
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        for (int idx : list) {
            if (visited[idx]) {
                continue;
            }
            for (int i = idx; i < idx + l; i++) {
                if (i > 1000) {
                    break;
                }
                visited[i] = true;
            }
            answer++;
        }

        System.out.println(answer);
    }
}