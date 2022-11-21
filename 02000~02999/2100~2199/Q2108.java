import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q2108 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list = list.stream().sorted().collect(Collectors.toList());

        Double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        answer.append(String.format("%.0f", avg) + "\n");
        answer.append(list.get(list.size() / 2) + "\n");
        answer.append(list.get(list.size() - 1) - list.get(0));
        System.out.println(answer);
    }
}