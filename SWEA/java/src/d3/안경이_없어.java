package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 안경이_없어 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final List<String> ALPHA_0 = Arrays.asList("CEFGHIJKLMNSTUVWXYZ".split(""));
    private static final List<String> ALPHA_1 = Arrays.asList("ADOPQR".split(""));
    private static final String SAME = "SAME";
    private static final String DIFF = "DIFF";


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            answer.append("#").append(i).append(" ").append(getResult()).append("\n");
        }

        System.out.println(answer);
    }

    private static String getResult() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word1 = st.nextToken();
        String word2 = st.nextToken();

        if (word1.length() != word2.length()) {
            return DIFF;
        }

        for (int i = 0; i < word1.length(); i++) {
            if (getAlpha(word1.substring(i, i + 1)) != getAlpha(word2.substring(i, i + 1))) {
                return DIFF;
            }
        }

        return SAME;
    }

    private static int getAlpha(String s) {
        if (ALPHA_0.contains(s)) {
            return 0;
        }
        if (ALPHA_1.contains(s)) {
            return 1;
        }
        return 2;
    }
}
