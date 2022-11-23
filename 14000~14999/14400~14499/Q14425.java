import java.io.*;
import java.util.*;

public class Q14425 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int count = 0;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (list.contains(br.readLine())) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}