import java.io.*;

public class Q10808 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static final int a = 'a';
    private static final int z = 'z';

    public static void main(String[] args) throws IOException {
        int[] alpha = new int[z - a + 1];
        for (char word : br.readLine().toCharArray()) {
            alpha[word - a]++;
        }
        for (int count : alpha) {
            answer.append(count).append(" ");
        }
        System.out.println(answer);
    }
}