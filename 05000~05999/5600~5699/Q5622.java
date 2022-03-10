import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622 {
    public static void main(String[] args) throws IOException {
        char[] D2 = { 'A', 'B', 'C' }; // 3초
        char[] D3 = { 'D', 'E', 'F' };
        char[] D4 = { 'G', 'H', 'I' };
        char[] D5 = { 'J', 'K', 'L' };
        char[] D6 = { 'M', 'N', 'O' };
        char[] D7 = { 'P', 'Q', 'R', 'S' };
        char[] D8 = { 'T', 'U', 'V' };
        char[] D9 = { 'W', 'X', 'Y', 'Z' };
        char[][] D = { D2, D3, D4, D5, D6, D7, D8, D9 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();
        int sec = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < D.length; j++) {
                for (int k = 0; k < D[j].length; k++) {
                    if (num[i] == D[j][k]) {
                        sec += 3 + j;
                    }
                }
            }
        }
        System.out.println(sec);
    }
}