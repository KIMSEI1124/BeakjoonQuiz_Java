import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1715 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Long> cards = new ArrayList<>(getList(N));
        System.out.println(getResult(cards));
    }

    private static List<Long> getList(int size) throws IOException {
        List<Long> list = new ArrayList<>();
        while (size-- > 0) {
            list.add(Long.parseLong(br.readLine()));
        }
        return list.stream().sorted().collect(Collectors.toList());
    }

    private static long getResult(List<Long> list) {
        long total = 0L;
        while (list.size() != 1) {
            System.out.println(list);
            long sum = list.get(0) + list.get(1);
            list.remove(1);
            list.remove(0);
            total += sum;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= sum) {
                    list.add(i, sum);
                    break;
                }
            }
        }
        return total;
    }
}

// 10 + 20 = 30 {30, 30, 40, 50}
// 30 + 30 = 60 {40, 50, 60}
// 40 + 50 = 90 {60, 90}
// 60 + 90 = 150 {150}
// 30 + 60 + 90 + 150 = 330