import java.io.*;
import java.util.*;

public class Q1786 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> result;
    private static StringBuilder answer = new StringBuilder();

    private static String T;
    private static String P;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        result = new ArrayList<>();
        T = br.readLine();
        P = br.readLine();
    }

    private static void solve() {
        int[] table = makeTable();

        System.out.println(Arrays.toString(table));

        int tLength = T.length();
        int pLength = P.length();

        int index = 0;
        for (int i = 0; i < tLength; i++) {
            while (index > 0 && T.charAt(i) != P.charAt(index)) {
                index = table[index - 1];
            }

            if (T.charAt(i) == P.charAt(index)) {
                if (index == pLength - 1) {
                    result.add(i - index + 1);
                    index = table[index];
                } else {
                    index++;
                }
            }
        }
    }

    private static int[] makeTable() {
        int[] table = new int[P.length() - 1];
        int index = 0;
        for (int i = 1; i < table.length; i++) {
            while (index > 0 && P.charAt(i) != P.charAt(index)) {
                index = table[index - 1];
            }
            if (P.charAt(i) == P.charAt(index)) {
                index++;
                table[i] = index;
            }
        }
        return table;
    }

    private static void print() {
        answer.append(result.size()).append("\n");
        for (Integer idx : result) {
            answer.append(idx).append(" ");
        }
        System.out.println(answer);
    }
}