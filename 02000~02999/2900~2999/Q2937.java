import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q2937 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
        while(isNotSort(list)) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    list = swap(list, i);
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isNotSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i + 1) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> swap(List<Integer> list, int index) {
        int temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
        answer.append(list.stream().map(String::valueOf).collect(Collectors.joining(" ", "", ""))).append("\n");
        return list;
    }
}