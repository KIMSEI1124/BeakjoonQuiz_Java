import java.io.*;
import java.util.*;

public class Q17471 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    /* 입력 관련 변수 */
    private static int n;
    private static int[] cities;
    private static List<List<Integer>> roadList;

    /* 풀이 관련 변수 */
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        cities = new int[n];
        isSelected = new boolean[n];

        /* 각 도시의 인구수 입력받기 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        roadList = new ArrayList<>();
        /* 각 도시의 연결된 도시를 입력받기 */
        for (int i = 0; i < n; i++) {
            roadList.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int roadQuantity = Integer.parseInt(st.nextToken());
            for (int j = 0; j < roadQuantity; j++) {
                roadList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void solve() {

    }

    private static void combi(int count) {
        if (count == n) {
            // TODO: 검증하기
        }

        combi(count + 1);
        isSelected[count] = true;
        combi(count + 1);
    }
}