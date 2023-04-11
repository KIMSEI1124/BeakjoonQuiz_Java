import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q11053 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
        for (int i = 0; i < N; i++) {
            dp.put(list.get(i), getCount(copyListOf(list, i)) + 1);
            System.out.println(dp);
        }
    }

    private static int getCount(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int number = list.get(i);
            if (list.get(list.size() - 1) > number) {
                System.out.println(dp.get(number));
                return dp.get(number);
            }
        }
        return 0;
    }

    private static List<Integer> copyListOf(List<Integer> list, int endIndex) {
        List<Integer> copyList = new ArrayList<>();
        int target = list.get(endIndex);
        for (int i = 0; i <= endIndex; i++) {
            int number = list.get(i);
            if (target > number) {
                copyList.add(list.get(i));
            }
        }
        return copyList;
    }
}