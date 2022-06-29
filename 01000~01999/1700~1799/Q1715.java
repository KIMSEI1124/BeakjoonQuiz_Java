import java.io.*;
import java.util.*;

public class Q1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static List<Integer> list;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        queue = new LinkedList<>();
        while (N > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        // solve

        // 배열 정렬
        Collections.sort(list);
        // 앞부터 더해 가면서 비교
        // 만약 크다면 새로운 배열로 저장
        // 작으면 더한다.

        // 새로운 배열의 크기가 1이상이면
        // 더하고 비교후 새로운 배열에 있는 값과 비교

        // output
        System.out.println(ans);
    }
}