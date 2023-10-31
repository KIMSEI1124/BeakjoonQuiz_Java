import java.io.*;
import java.util.*;

public class Q2822 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        list = new ArrayList<>();
        list.add(-1); // 더미
        for (int i = 0; i < 8; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
    }

    private static void solve() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(list.get(o2), list.get(o1));
        });
        for (int i = 1; i <= 8; i++) {
            priorityQueue.offer(i);
        }

        int sum = 0;
        boolean[] selected = new boolean[9];
        for (int i = 1; i <= 5; i++) {
            int index = priorityQueue.poll();
            selected[index] = true;
            sum += list.get(index);
        }
        answer.append(sum).append("\n");
        for (int i = 1; i <= 8; i++) {
            if (selected[i]) {
                answer.append(i).append(" ");
            }
        }
    }
}