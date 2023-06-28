package algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class 조합 {
    private static final int n = 5;
    private static final int k = 3;

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        recursion(-1, deque);
        System.out.println("----------");
        loop();
    }

    private static void recursion(int start, Deque<Integer> deque) {
        if (deque.size() == k) {
            /* logic */
            return;
        }

        for (int i = start + 1; i < n; i++) {
            deque.addLast(i);
            recursion(i, deque);
            deque.pollLast();
        }
    }

    private static void loop() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}
