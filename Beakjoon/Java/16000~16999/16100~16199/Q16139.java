import java.io.*;
import java.util.*;

public class Q16139 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    private static final StringBuilder answer = new StringBuilder();
    private static Score[] arr;
    private static String S;
    private static int T;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        S = br.readLine();
        T = Integer.parseInt(br.readLine());
        arr = new Score[S.length() + 1];
        arr[0] = new Score();
    }

    private static void solve() throws IOException {
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            Score score = new Score(arr[i - 1].array);
            score.array[c - 'a']++;
            arr[i] = score;
        }
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;
            int count = arr[end].array[target - 'a'] - arr[start - 1].array[target - 'a'];
            answer.append(count).append("\n");
        }
    }

    private static class Score {
        private int[] array;

        public Score() {
            array = new int['z' - 'a' + 1];
        }

        public Score(int[] arr) {
            array = Arrays.copyOf(arr, 'z' - 'a' + 1);
        }
    }
}