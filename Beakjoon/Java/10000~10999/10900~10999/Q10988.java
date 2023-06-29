import java.io.*;

public class Q10988 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        String input = br.readLine();
        String reverse = new StringBuilder(input).reverse().toString();

        if (input.equals(reverse)) {
            answer = 1;
        }

        System.out.println(answer);
    }
}