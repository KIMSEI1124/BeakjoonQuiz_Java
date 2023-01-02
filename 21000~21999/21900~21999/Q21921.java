import java.io.*;
import java.util.*;

public class Q21921 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] array = getArray(N);

        long max = 0L;
        int count = 0;
        for (int i = X; i < array.length; i++) {
            int temp = array[i] - array[i - X];
            if (temp > max) {
                max = temp;
                count = 1;
            } else if (temp == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max + "\n" + count);
    }

    private static int[] getArray(int N) throws IOException {
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i == 0) {
                array[i] = number;
                continue;
            }
            array[i] = array[i - 1] + number;
        }
        return array;
    }
}