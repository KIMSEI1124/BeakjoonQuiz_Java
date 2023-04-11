import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q26556 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int count = getCount();
            if(count == 0) {
                answer.append("Not possible");
            } else {
                answer.append(count);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static int getCount() throws IOException {
        int quantity = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        int goal = Integer.parseInt(br.readLine());
        long total = 0;
        int count = 0;
        for (Integer size : list) {
            total += size;
            if(total <= goal) {
                count++;
                continue;
            }
            if(total > goal) {
                break;
            }
        }
        return count;
    }
}