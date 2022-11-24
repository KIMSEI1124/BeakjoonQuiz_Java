import java.io.*;
import java.util.*;

public class Q1764 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Set<String> set = new LinkedHashSet<>();
        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        answer.append(list.size()).append("\n");
        list.stream().sorted().forEach(t -> answer.append(t).append("\n"));

        System.out.println(answer);
    }
}