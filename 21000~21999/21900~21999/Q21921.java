import java.io.*;
import java.util.*;

public class Q21921 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Integer> list = getList(N);

        long max = 0L;
        int count = 0;
        for (int i = X; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - X);
            if (temp > max) {
                max = temp;
                count = 1;
            } else if (temp == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max + "\n" + count);
    }

    private static List<Integer> getList(int N) throws IOException {
        List<Integer> list = new ArrayList<>(List.of(0));
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list.add(Integer.parseInt(st.nextToken()) + list.get(i - 1));
        }
        return list;
    }
}