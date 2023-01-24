import java.io.*;
import java.util.*;

public class Q10814 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            String key = st.nextToken();
            map.put(key, value);
        }
        // List<String> keyList = new ArrayList<>(map.keySet());
        // keyList.sort((a, b) -> a.compareTo(b));
        List<Integer> valueList = new ArrayList<>(map.values());
        valueList.sort((a, b) -> a.compareTo(b));
        for (String name : map.keySet()) {
            int age = map.get(name);
            answer.append(age).append(" ").append(name).append("\n");
        }
        System.out.println(answer);
    }
}