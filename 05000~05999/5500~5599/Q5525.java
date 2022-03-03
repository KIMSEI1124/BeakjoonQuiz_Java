import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // O의 개수
        int M = Integer.parseInt(br.readLine()); // 문자열의 길이
        String S = br.readLine();
        StringBuilder check = new StringBuilder("I");
        int answer = 0;
        while (N > 0) {
            check.append("OI");
            N--;
        }
        int size = check.length();
        String str = String.valueOf(check);
        for (int i = 0; i < M - size; i++) {
            if (S.subSequence(i, i + size).equals(str)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}