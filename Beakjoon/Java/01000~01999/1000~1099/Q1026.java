import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1026 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        List<Integer> a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < N; i++) {
            answer += a.get(i) * b.get(i);
        }

        System.out.println(answer);
    }
}