import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Q1158 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String answer;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = solve(initList(n), k);
        answer = list.stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">"));
        System.out.println(answer);
    }

    private static List<Integer> initList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    private static List<Integer> solve(List<Integer> list, int k) {
        List<Integer> removeNumbers = new ArrayList<>();
        int idx = k - 1;
        while (!list.isEmpty()) {
            while (idx >= list.size()) {
                idx -= list.size();
            }
            removeNumbers.add(list.remove(idx));
            idx += k - 1;
        }
        return removeNumbers;
    }
}