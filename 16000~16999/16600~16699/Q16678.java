import java.io.*;
import java.util.*;

public class Q16678 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = getList(N);
        System.out.println(list);
    }

    private static List<Integer> getList(int N) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        return list;
    }

    private static int getResult(List<Integer> list, int N) {
        int result = 0;
        int start = 0;
        int end = list.size() - 1;
        int index = 1;
        while (N > index++) {
            list.get(start);
            if (list.get(start) <= index) {
                start++;
                continue;
            }
        }
        return result;
    }
}