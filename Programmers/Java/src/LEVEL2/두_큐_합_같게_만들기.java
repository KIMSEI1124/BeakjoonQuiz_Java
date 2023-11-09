package LEVEL2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 두_큐_합_같게_만들기 {

    private static Deque<Integer> deque1;
    private static Deque<Integer> deque2;

    private static int answer = -1;
    private static long sum1;
    private static long sum2;
    private static long avg;
    private static int length;

    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        solve();
        return answer;
    }

    private void init(int[] q1, int[] q2) {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
        for (int i = 0; i < q1.length; i++) {
            deque1.offer(q1[i]);
            deque2.offer(q2[i]);
        }

        length = (deque1.size() + deque2.size() * 2) + 1;
        sum1 = deque1.stream().mapToLong(i -> i).sum();
        sum2 = deque2.stream().mapToLong(i -> i).sum();
        avg = (sum1 + sum2) / 2;
    }

    private void solve() {
        int count = 0;
        while (canDoing(count)) {
            if (sum1 == sum2) {
                answer = count;
                return;
            } else if (sum1 > sum2) {
                int poll = deque1.poll();
                sum1 -= poll;
                sum2 += poll;
                deque2.offer(poll);
            } else {
                int poll = deque2.poll();
                sum2 -= poll;
                sum1 += poll;
                deque1.offer(poll);
            }
            count++;
        }
    }

    private boolean canDoing(int count) {
        return count <= length;
    }
}
