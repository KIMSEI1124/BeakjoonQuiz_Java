import java.io.*;

public class Q5585 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static int[] array = { 500, 100, 50, 10, 5, 1 };

    public static void main(String[] args) throws IOException {
        int input = 1000 - Integer.parseInt(br.readLine());
        int total = 0;
        for (int money : array) {
            total += input / money;
            input %= money;
        }
        System.out.println(total);
    }
}