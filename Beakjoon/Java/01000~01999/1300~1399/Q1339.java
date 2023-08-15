import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q1339 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> words = new LinkedList<>();
    private static final Map<Character, Long> alphaScore = new HashMap<>(); // Key : 문자, Value : 문자의 개수
    private static int answer;
    private static int n; // 단어의 개수 `1 <= N <= 10`

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 단어의 개수 입력 */
        n = Integer.parseInt(br.readLine());

        /* 단어 입력 */
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add("0".repeat(10 - word.length()) + word);
        }
    }

    private static void solve() {
        /* 알파벳의 점수 구하기 */
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n; j++) {
                char alpha = words.get(j).charAt(i);
                if (alpha != '0') {
                    /* 단어에서 위치에 따른 알파벳의 가중치 부여 */
                    alphaScore.put(alpha, alphaScore.getOrDefault(alpha, 0L) + (long) Math.pow(10, 10D - i));
                }
            }
        }

        /* 점수가 높은 알파벳부터 9점으로 지정 */
        List<Map.Entry<Character, Long>> entries = new LinkedList<>(alphaScore.entrySet());
        entries.sort(((o1, o2) -> (int) (alphaScore.get(o2.getKey()) - alphaScore.get(o1.getKey()))));

        /* 점수가 높은 알파벳 부터 바꾸기 */
        int score = 9;
        for (Map.Entry<Character, Long> entry : entries) {
            String key = String.valueOf(entry.getKey());
            String strScore = String.valueOf(score);
            for (int i = 0; i < n; i++) {
                words.set(i, words.get(i).replace(key, strScore)); // 숫자로 변환
            }
            score--;
        }

        /* 단어들 더하기 */
        for (int i = 0; i < n; i++) {
            answer += Integer.parseInt(words.get(i));
        }
    }
}