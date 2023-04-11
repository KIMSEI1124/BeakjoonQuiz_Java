import java.io.*;
import java.util.*;

public class Q17219 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        map = getMap(map, N);
        getAnswer(map, M);

        System.out.println(answer);
    }

    private static Map<String, String> getMap(Map<String, String> map, int N) throws IOException {
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        return map;
    }

    private static void getAnswer(Map<String, String> map, int M) throws IOException {
        while (M-- > 0) {
            answer.append(map.get(br.readLine()) + "\n");
        }
    }
}