import java.io.*;

public class Q10870 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[21];
        numbers[0] = 0;
        numbers[1] = 1;

        for(int i = 2; i <= N; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.println(numbers[N]);
    }
}