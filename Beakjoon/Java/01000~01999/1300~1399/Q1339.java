import java.io.*;
import java.util.*;

public class Q1339 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int n;
    private static String[] words;
    private static Set<String> set = new HashSet<>();
    private static List<String> list;
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (Character c : words[i].toCharArray()) {
                set.add(String.valueOf(c));
            }
        }
    }

    private static void solve() throws IOException {
        list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            logic(i, 9, new ArrayList<>());
        }
    }

    private static void logic(int idx, int number, List<String> wordList) {
        if (map.containsKey(list.get(idx))) {
            return;
        }

        wordList.add(list.get(idx));
        map.put(list.get(idx), number);

        if (list.size() == wordList.size()) {
            getMax(wordList);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            logic(i, number - 1, wordList);
        }

        wordList.remove(list.get(idx));
        map.remove(list.get(idx));
    }

    private static void getMax(List<String> wordList) {
        for (String s : wordList) {
            for (int i = 0; i < words.length; i++) {
                System.out.println("====");
                System.out.println(words[i]);
                words[i] = words[i].replace(s, String.valueOf(map.get(s)));
                System.out.println(words[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            sum += Integer.parseInt(words[i]);
        }
        answer = Math.max(answer, sum);
    }
}