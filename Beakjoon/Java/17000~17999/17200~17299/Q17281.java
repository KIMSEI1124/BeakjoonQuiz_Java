import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q17281 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;
    private static int n;
    private static int[][] innings;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 이닝 수 입력 */
        n = Integer.parseInt(br.readLine());

        /* 이닝 정보 초기화 및 입력받기 */
        innings = new int[n][9];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        int[] players = { 1, 2, 3, 4, 5, 6, 7, 8 };
        do {
            answer = Math.max(playBaseball(players), answer);
        } while (np(players));
    }

    private static int playBaseball(int[] playerIndex) {
        /* 야구 게임하기 전 초기화 작업 */
        int score = 0;
        int index = 0;

        /* 타자들의 순서 정하기 */
        List<Integer> players = Arrays.stream(playerIndex).boxed().collect(Collectors.toList());
        players.add(3, 0);

        for (int inning = 0; inning < n; inning++) {
            int out = 0;
            boolean[] bases = new boolean[4];
            while (out < 3) {
                int result = innings[inning][players.get(index++ % 9)];
                if (result == 0) {
                    out++;
                    continue;
                }
                if (result == 4) {
                    score++;
                    for (int i = 1; i < 4; i++) {
                        if (bases[i]) {
                            score++;
                            bases[i] = false;
                        }
                    }
                } else if (result == 3) {
                    for (int i = 1; i < 4; i++) {
                        if (bases[i]) {
                            score++;
                            bases[i] = false;
                        }
                    }
                    bases[3] = true;
                } else if (result == 2) {
                    for (int i = 3; i > 0; i--) {
                        if (i >= 2 && bases[i]) {
                            score++;
                            bases[i] = false;
                        } else if (i < 2 && bases[i]) {
                            bases[i] = false;
                            bases[i + 2] = true;
                        }
                    }
                    bases[2] = true;
                } else if (result == 1) {
                    for (int i = 3; i > 0; i--) {
                        if (i >= 3 && bases[i]) {
                            bases[i] = false;
                            score++;
                        } else if (i < 3 && bases[i]) {
                            bases[i] = false;
                            bases[i + 1] = true;
                        }
                    }
                    bases[1] = true;
                }
            }
        }

        return score;
    }

    private static boolean np(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (p[i - 1] >= p[j]) {
            j--;
        }

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }

        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
}