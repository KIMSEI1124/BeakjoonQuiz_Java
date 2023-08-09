package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산_유효성_검사 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n;
    private static String[] tree;

    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            input();
            answer.append("#").append(testCase).append(" ").append(solve()).append("\n");
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            tree[idx] = temp;
        }
    }

    private static int solve() {
        try {
            for (int i = n - 1; i > 1; i -= 2) {
                int a = Integer.parseInt(tree[i]);
                int b = Integer.parseInt(tree[i + 1]);

                int parentIdx = i / 2;
                String code = tree[parentIdx];

                /* 연산 후 부모 노드에 저장 */
                if (code.equals("+")) {
                    tree[parentIdx] = String.valueOf(a + b);
                } else if (code.equals("-")) {
                    tree[parentIdx] = String.valueOf(a - b);
                } else if (code.equals("*")) {
                    tree[parentIdx] = String.valueOf(a * b);
                } else if (code.equals("/")) {
                    tree[parentIdx] = String.valueOf(Math.max(a, 1) / Math.max(b, 1));
                }
            }
            return 1;
        } catch (RuntimeException e) {
            return 0;
        }
    }
}
