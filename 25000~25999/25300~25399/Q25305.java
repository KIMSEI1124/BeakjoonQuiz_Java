import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q25305 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(k - 1);

        System.out.println(answer);
    }
}