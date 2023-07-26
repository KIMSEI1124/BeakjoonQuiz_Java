import java.io.*;

public class Q27866 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        /* Input */
        String str = br.readLine();
        int i = Integer.parseInt(br.readLine());

        /* Solve */
        char answer = str.charAt(i - 1);

        System.out.println(answer);
    }
}