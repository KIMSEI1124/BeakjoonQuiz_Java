import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Q2309_re {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Integer> answerList = new ArrayList<>();
    private final static int ONE_HUNDRED = 100;

    public static void main(String[] args) throws IOException {
        List<Integer> list = getList(9);
        get(-1, list);
    }

    private static List<Integer> getList(int n) throws IOException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void get(int start, List<Integer> list) {
        int sum = answerList.stream().mapToInt(i -> i).sum();
        if (answerList.size() == 7 && sum == ONE_HUNDRED) {
            print();
            System.exit(0);
            return;
        }

        for (int i = start + 1; i < list.size(); i++) {
            answerList.add(list.get(i));
            get(i, list);
            answerList.remove(answerList.size() - 1);
        }
    }

    private static void print() {
        String answer = answerList.stream().map(String::valueOf).collect(Collectors.joining(" \n"));
        System.out.println(answer);
    }
}
