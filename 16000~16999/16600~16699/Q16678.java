import java.io.*;
import java.util.*;

public class Q16678 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = getList(N);
        System.out.println(getResult(list));
    }

    private static List<Integer> getList(int N) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        return list;
    }

    private static int getResult(List<Integer> list) {
        int result = 0;
        int start = 0;
        int end = list.size() - 1;
        int index = 1;
        while (end > start) {
            System.out.println(list);
            if (list.get(start) <= index) {
                start++;
                continue;
            }
            if (index < list.get(start)) {
                if (list.get(start) - 1 == index && start != 0) {
                    index++;
                } else {
                    result += list.get(end) - index;
                    list.add(start, index);
                    index++;
                    list.remove(list.size() - 1);
                }
                start++;
                continue;
            }
            start++;
            index++;
        }
        return result;
    }
}