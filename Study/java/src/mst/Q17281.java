package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q17281 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int HIT = 1;       // 안타
    private static final int DOUBLE = 2;    // 2루타
    private static final int TRIPLE = 3;    // 3루타
    private static final int HOME_RUN = 4;  // 홈런
    private static int answer;
    private static int n;   // 이닝 수
    private static Inning[] innings;
    private static int[] index = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        innings = new Inning[n];
        for (int i = 0; i < n; i++) {
            innings[i] = Inning.from(br.readLine());
        }
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            do {
                int score = getScore();
                if (Math.max(answer, score) > answer) {
                    answer = Math.max(answer, getScore());
                    System.out.println(Arrays.toString(index));
                }
            } while (nextPermutation(index));
        }
    }

    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[i - 1] >= array[j]) {
            j--;
        }

        swap(array, i - 1, j);

        int k = array.length - 1;
        while (i < k) {
            swap(array, i++, k--);
        }

        return true;
    }

    private static int getScore() {
        List<Integer> ids = Arrays.stream(index).boxed().collect(Collectors.toList());
        ids.add(3, 0);

        int score = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            int out = 0;
            boolean[] bases = new boolean[4];
            while (out < 3) {
                int result = innings[i].getResult()[index++ % 9];
                if (result == HIT) {
                    score = doHit(score, bases);
                } else if (result == DOUBLE) {
                    score = doDouble(score, bases);
                } else if (result == TRIPLE) {
                    score = doTriple(score, bases);
                } else if (result == HOME_RUN) {
                    score = doHomeRun(score, bases);
                } else {
                    out++;
                }
            }
        }

        return score;
    }

    private static int doHomeRun(int score, boolean[] bases) {
        int temp = 1;
        for (int i = 1; i <= 3; i++) {
            if (bases[i]) {
                temp++;
                bases[i] = false;
            }
        }
        score += temp;
        return score;
    }

    private static int doTriple(int score, boolean[] bases) {
        if (bases[3]) {
            score++;
            bases[3] = false;
        }
        if (bases[2]) {
            score++;
            bases[2] = false;
        }
        if (bases[1]) {
            score++;
            bases[1] = false;
        }
        bases[3] = true;
        return score;
    }

    private static int doDouble(int score, boolean[] bases) {
        if (bases[3]) {
            score++;
            bases[3] = false;
        }
        if (bases[2]) {
            score++;
            bases[2] = false;
        }
        if (bases[1]) {
            bases[3] = true;
            bases[1] = false;
        }
        bases[2] = true;
        return score;
    }

    private static int doHit(int score, boolean[] bases) {
        if (bases[3]) {
            score++;
            bases[3] = false;
        }
        if (bases[2]) {
            bases[3] = true;
            bases[2] = false;
        }
        if (bases[1]) {
            bases[2] = true;
            bases[1] = false;
        }
        bases[1] = true;
        return score;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static class Inning {
        private final int[] players = new int[9];

        private Inning(String input) {
            StringTokenizer st = new StringTokenizer(input);
            for (int i = 0; i < 9; i++) {
                players[i] = Integer.parseInt(st.nextToken());
            }
        }

        public static Inning from(String input) {
            return new Inning(input);
        }

        public int[] getResult() {
            return players;
        }
    }
}
