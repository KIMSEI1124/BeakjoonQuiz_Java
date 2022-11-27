import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q10815 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<Integer> setN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toSet());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if(setN.contains(number)) {
                answer.append("1 ");
                continue;
            }
            answer.append("0 ");
        }

        warmException(N, M);

        System.out.println(answer);
    }

    private static void warmException(int N, int M) {
        return;
    }
}