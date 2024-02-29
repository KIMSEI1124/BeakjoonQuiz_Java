import java.io.*;
import java.util.*;

public class Q27527 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String answer = "NO";

    private static int N;
    private static int M;
    private static int[] arr;
    private static Map<Integer, Integer> map = new HashMap<>();

    private static int target;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        target = (9 * M) / 10 + ((9 * M) % 10 == 0 ? 0 : 1);
        int head = 1;
        int tail = M;
        if (init()) {
            return;
        }
        while (canSlide(head++, tail++)) {
            if (tail > N) {
                break;
            }
        }
    }

    private static boolean init() {
        for (int i = 1; i <= M; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) >= target) {
                answer = "YES";
                return true;
            }
        }
        return false;
    }

    private static boolean canSlide(int head, int tail) {
        // head 는 제거
        int headKey = arr[head];
        int headValue = map.get(headKey);
        if (headValue == 1) {
            map.remove(headKey);
        } else {
            map.put(headKey, headValue - 1);
        }

        // tail은 추가 후 검증
        if (tail + 1 > N) {
            return false;
        }
        int tailKey = arr[tail + 1];
        int tailValue = map.getOrDefault(tailKey, 0) + 1;
        if (tailValue >= target) {
            answer = "YES";
            return false;
        }
        map.put(tailKey, tailValue);
        return true;
    }
}