import java.io.*;
import java.util.*;

public class Q10282 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성의 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호
            List<List<HashMap<Integer,Integer>>> com = set_com(n, d);
            hack(com, c);
            T--;
        }

        // output
        System.out.println(ans);
    }

    /**
     * 컴퓨터를 설정한다.
     * @param n 컴퓨터의 개수
     * @param d 의존성의 개수
     * @return  세팅된 컴퓨터의 정보
     * @throws IOException
     */
    public static List<List<HashMap<Integer,Integer>>> set_com(int n, int d) throws IOException {
        List<List<HashMap<Integer,Integer>>> com = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            com.add(new ArrayList<>());
        }
        for (int i = 0; i < d; i++) {
            com = set_edge(com);
        }
        return com;
    }

    /**
     * 컴퓨터의 의존성을 추가한다.
     * @param com 비어있는 컴퓨터 정보
     * @return  세팅된 컴퓨터 정보
     * @throws IOException
     */
    public static List<List<HashMap<Integer,Integer>>> set_edge(List<List<HashMap<Integer,Integer>>> com) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // a 컴퓨터가
        int b = Integer.parseInt(st.nextToken()); // b 컴퓨터를 의존
        int s = Integer.parseInt(st.nextToken()); // s초 후 컴퓨터 a 감염

        //HashMap 생성후 데이터 입력
        com.get(b).add(new HashMap<>());
        com.get(b).get(com.get(b).size()-1).put(a, s);
        System.out.println(com.get(b).get(com.get(b).size()-1).values());
        return com;
    }

    public static void hack(List<List<HashMap<Integer,Integer>>> com, int c) {
        boolean[] visited = new boolean[com.size()];
        /*
         * t_1 + t_2 < t_3 이면 t_1 + t_2 로 교체
         */
        int[] timer = new int[com.size()];
        dfs(c, visited);
    }

    public static void dfs(int i, boolean[] visited) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;
    }
}