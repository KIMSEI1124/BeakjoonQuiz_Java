import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q5430 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static final char REMOVE = 'D';
    private static final char REVERSE = 'R';

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            List<Integer> x = getX(n);
            Deque<Integer> deque = new ArrayDeque<>(getX(n));
            deque.stream().map(String::valueOf).collect(Collectors.joining(",","[","]"));

            try {
                for (char fun : p) {
                    if (fun == REMOVE) {
                        x = D(x);
                        continue;
                    }
                    if (fun == REVERSE) {
                        x = R(x);
                    }
                }
                answer.append(x.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")));
            } catch (Exception e) {
                answer.append("error");
            }

            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static List<Integer> getX(int n) throws IOException {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        String str = br.readLine();
        if (n != 0) {
            list = Arrays.stream(str.substring(1, str.length() - 1)
                    .split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return list;
    }

    private static List<Integer> D(List<Integer> x) {
        x.remove(0);
        return x;
    }

    private static List<Integer> R(List<Integer> x) {
        Collections.reverse(x);
        return x;
    }
}