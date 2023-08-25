import java.io.*;
import java.util.*;

public class Main_1759_김정욱 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static final Set<String> VOWELS = new HashSet<>(List.of("a", "e", "i", "o", "u"));

    private static int L, C; // L : 암호의 길이, C : 문자의 개수
    private static List<String> alpha = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, 0, "");
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            alpha.add(st.nextToken());
        }
        Collections.sort(alpha);
    }

    private static void solve(int idx, int vowelsCount, int anotherCount, String password) {
        if (password.length() > L) {
            return;
        }

        if (password.length() == L) {
            if (vowelsCount >= 1 && anotherCount >= 2) {
                answer.append(password).append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            String temp = alpha.get(i);
            if (isVowels(temp)) {
                solve(i + 1, vowelsCount + 1, anotherCount, password + temp);
                continue;
            }
            solve(i + 1, vowelsCount, anotherCount + 1, password + temp);
        }
    }

    private static boolean isVowels(String s) {
        return VOWELS.contains(s);
    }
}