import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q1174 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;
    private static int n;
    private static List<Integer> negativeNumbers = new ArrayList<>();
    private static List<Integer> positiveNumbers = new ArrayList<>();
    private static boolean hasZero;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 1) {
                positiveNumbers.add(number);
            } else if (number == 0) {
                hasZero = true;
            } else if (number == 1) {
                answer++;
            } else {
                negativeNumbers.add(number);
            }
        }
    }

    private static void solve() {
        /* 양수 처리 */
        positiveNumbers.sort(Comparator.reverseOrder());
        for (int i = 0; i < positiveNumbers.size() - 1; i += 2) {
            answer += positiveNumbers.get(i) * positiveNumbers.get(i + 1);
        }

        if (positiveNumbers.size() % 2 == 1) {
            answer += positiveNumbers.get(positiveNumbers.size() - 1);
        }

        /* 음수 처리 */
        negativeNumbers.sort(Comparator.naturalOrder());
        if (negativeNumbers.size() % 2 == 1 && !hasZero) {
            answer += negativeNumbers.get(negativeNumbers.size() - 1);
        }

        for (int i = 0; i < negativeNumbers.size() - 1; i += 2) {
            answer += negativeNumbers.get(i) * negativeNumbers.get(i + 1);
        }
    }
}
