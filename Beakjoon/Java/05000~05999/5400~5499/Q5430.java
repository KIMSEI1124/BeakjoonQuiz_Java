import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q5430 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static final char REMOVE = 'D';
    private static final char REVERSE = 'R';
    private static final char FRONT = 'F';
    private static final char BACK = 'B';

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> x = new ArrayDeque<>(getX(n));
            char pointer = FRONT;

            try {
                for (char fun : p) {
                    if (fun == REMOVE) {
                        x = D(x, pointer);
                    }
                    if (fun == REVERSE) {
                        pointer = R(pointer);
                    }
                }
                if (pointer == BACK) {
                    List<Integer> list = new ArrayList<>(x);
                    Collections.reverse(list);
                    answer.append(
                            list.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(",", "[", "]")));
                }
                if (pointer == FRONT) {
                    answer.append(x.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",", "[", "]")));
                }
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

    private static Deque<Integer> D(Deque<Integer> x, char pointer) {
        if (x.isEmpty()) {
            throw new NullPointerException();
        }
        if (pointer == FRONT) {
            x.pollFirst();
        }
        if (pointer == BACK) {
            x.pollLast();
        }
        return x;
    }

    private static char R(char pointer) {
        if (pointer == FRONT) {
            return BACK;
        }
        if (pointer == BACK) {
            return FRONT;
        }
        return pointer;
    }
}