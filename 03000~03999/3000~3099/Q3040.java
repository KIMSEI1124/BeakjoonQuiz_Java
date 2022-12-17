import java.io.*;
import java.util.*;

public class Q3040 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Long> list = getList();
        List<Long> result = getResult(list);
        StringBuilder answer = getAnswer(result);
        System.out.println(answer);
    }

    private static List<Long> getList() throws IOException {
        List<Long> list = new ArrayList<>();
        int count = 9;
        while (count-- > 0) {
            list.add(Long.parseLong(br.readLine()));
        }
        return list;
    }

    private static List<Long> getResult(List<Long> list) {
        Long total = list.stream()
                .mapToLong(value -> value)
                .summaryStatistics()
                .getSum();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Long sum = list.get(i) + list.get(j);
                if (total - sum == 100) {
                    list.remove(j);
                    list.remove(i);
                    break;
                }
            }
        }
        
        return list;
    }

    private static StringBuilder getAnswer(List<Long> result) {
        StringBuilder answer = new StringBuilder();
        for (Long number : result) {
            answer.append(number).append("\n");
        }
        return answer;
    }
}