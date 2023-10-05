package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 보물상자_비밀번호 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int T;
    private static int result;

    private static int N, K;
    private static List<Deque<Character>> list;
    private static Set<String> hexPasswords;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayDeque<>());
        }

        char[] inputNumber = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            list.get(i / (N / 4)).add(inputNumber[i]);
        }

        hexPasswords = new HashSet<>();
    }

    private static void solve() {
        searchPassword();
        searchByK();
    }

    private static void searchPassword() {
        int count = N / 4;
        while (count-- > 0) {
            rotate();
        }
    }

    private static void rotate() {
        for (int i = 0; i < 4; i++) {
            Deque<Character> to = list.get(i % 4);
            Deque<Character> from = list.get((i + 1) % 4);
            from.addFirst(to.pollLast());
        }
        save();
    }

    private static void save() {
        for (Queue<Character> queue : list) {
            hexPasswords.add(queue.stream().map(String::valueOf).collect(Collectors.joining("", "0x", "")));
        }
    }

    private static void searchByK() {
        List<Integer> passwords = new ArrayList<>();
        for (String hexPassword : hexPasswords) {
            passwords.add(Integer.decode(hexPassword));
        }
        passwords.sort(Collections.reverseOrder());
        result = passwords.get(K - 1);
    }
}
