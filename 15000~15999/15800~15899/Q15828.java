import java.io.*;
import java.util.*;

public class Q15828 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static final int QUIT = -1;
    private static final int POLL = 0;

    public static void main(String[] args) throws IOException {
        Deque<Integer> buffer = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while (true) {
            int number = Integer.parseInt(br.readLine());
            if (number == QUIT) {
                break;
            }
            if (number == POLL) {
                buffer.poll();
                continue;
            }
            if (buffer.size() < N) {
                buffer.add(number);
            }
        }

        if (buffer.isEmpty()) {
            System.out.println("empty");
            return;
        }

        buffer.stream().forEach(t -> {
            answer.append(t + " ");
        });
        System.out.println(answer);
    }
}