import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1092 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> ship = getList(N);
        int M = Integer.parseInt(br.readLine());
        List<Integer> box = getList(M);

        System.out.println(ship);
        System.out.println(box);
    }

    private static List<Integer> getList(int size) throws IOException {
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
        }
        return list.stream().sorted().collect(Collectors.toList());
    }
}