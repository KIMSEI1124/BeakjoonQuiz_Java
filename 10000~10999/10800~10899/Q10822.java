import java.io.*;
import java.util.*;

public class Q10822 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int sum = Arrays.stream(br.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);
    }
}