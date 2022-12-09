import java.io.*;
import java.util.*;

public class Q3078 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Long answer = 0L;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> namesLength = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while (N-- > 0) {
            namesLength.add(br.readLine().length());
        }
        for (int i = 0; i < K; i++) {
            int nameLength = namesLength.get(i);
            map.put(nameLength, map.getOrDefault(nameLength, 0) + 1);
        }

        for (int i = 0; i < namesLength.size(); i++) {
            int remove = namesLength.get(i);
            int inputIndex = i + K;
            map.put(remove, map.get(remove) - 1);
            if (inputIndex < namesLength.size()) {
                int nameLength = namesLength.get(inputIndex);
                map.put(nameLength, map.getOrDefault(nameLength, 0) + 1);
            }
            answer += map.get(namesLength.get(i));
        }

        System.out.println(answer);
    }
}