import java.io.*;
import java.util.*;

public class Q1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        char[] word;
        boolean[] visited;

        // solve
        while (N > 0) {
            word = br.readLine().toCharArray();
            visited = new boolean[(int) 'z' - 'a' + 1];
            if (word_check(visited, word)) {
                ans++;
            }
            N--;
        }

        // output
        System.out.println(ans);
    }

    public static boolean word_check(boolean[] visited, char[] word) {
        char save = ' ';
        for (int i = 0; i < word.length; i++) {
            if (i == 0) {
                save = word[i];
            } else {
                if (word[i] != save) { // 새로운 문자면
                    if (visited[(int) word[i] - 'a']) { // 방문한적이 있으면
                        return false; // 그룹 단어 아님
                    }
                    visited[(int) save - 'a'] = true;
                    save = word[i];
                }
            }
        }
        return true;
    }
}