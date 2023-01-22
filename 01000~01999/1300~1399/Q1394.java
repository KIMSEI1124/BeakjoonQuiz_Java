import java.io.*;

public class Q1394 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] words = br.readLine().split("");
        String password = br.readLine();
        String word = password.substring(password.length() - 1);    // 마지막 단어
        Long answer = (password.length() - 1) * words.length * 1L;
        for (String string : words) {
            answer++;
            if(string.equals(word)) {
                break;
            }
        }
        System.out.println(answer % 900528);
    }
}