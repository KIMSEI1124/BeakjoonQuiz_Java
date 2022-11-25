import java.io.*;
import java.util.*;

public class Q1269 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        setA.stream().forEach(t -> {
            if (setB.contains(t)) {
                count++;
            }
        });

        int answer = (A - count) + (B - count);

        System.out.println(answer);
    }
}