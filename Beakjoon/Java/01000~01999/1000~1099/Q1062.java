import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1062 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final char[] alphabet = { 'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's',
            'u', 'v', 'w', 'x', 'y', 'z' };
    private static final List<Word> words = new LinkedList<>();
    private static int answer;
    private static int n; // 단어의 개수
    private static int k; // 가르킬 수 있는 단어의 개수

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 단어 정보 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        /* 단어 입력 */
        for (int i = 0; i < n; i++) {
            words.add(Word.from(br.readLine()));
        }
    }

    private static void solve() {
        /* 남극단어의 시작과 끝어 있는 단어를 읽기 위해서는 최소 5글자를 알아야 하는데 알지 못하면 하나의 단어도 말을 할 수 없다. */
        if (k < 5) {
            return;
        }

        combination(0, 0, defaultAlphabet());
    }

    private static Set<Character> defaultAlphabet() {
        return new HashSet<>(List.of('a', 'c', 'i', 'n', 't'));
    }

    private static void combination(int count, int start, Set<Character> learnAlphabet) {
        if (learnAlphabet.size() == k) {
            answer = Math.max(answer, speakingWordsCount(learnAlphabet));
            return;
        }

        for (int i = start; i < alphabet.length; i++) {
            if (learnAlphabet.contains(alphabet[i])) {
                continue;
            }

            learnAlphabet.add(alphabet[i]);
            combination(count + 1, i + 1, learnAlphabet);
            learnAlphabet.remove(alphabet[i]);
        }
    }

    private static int speakingWordsCount(Set<Character> learnAlphabet) {
        int count = 0;
        for (Word word : words) {
            if (word.canSpeaking(learnAlphabet)) {
                count++;
            }
        }
        return count;
    }

    private static class Word {
        private final Set<Character> alphabet;

        private Word(String word) {
            alphabet = new HashSet<>();
            addAlphabet(word);
        }

        public static Word from(String word) {
            return new Word(word);
        }

        private void addAlphabet(String word) {
            for (char alpha : word.toCharArray()) {
                alphabet.add(alpha);
            }
        }

        private boolean canSpeaking(Set<Character> learnAlphabet) {
            for (Character alpha : alphabet) {
                if (!learnAlphabet.contains(alpha)) {
                    return false;
                }
            }
            return true;
        }
    }
}
