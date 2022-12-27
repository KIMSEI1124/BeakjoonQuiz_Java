import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1037 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted().collect(Collectors.toList());
        if (N == 1) {
            answer.append(list.get(0) * list.get(0));
        } else {
            answer.append(list.get(0) * list.get(N - 1));
        }
        System.out.println(answer);
    }
}