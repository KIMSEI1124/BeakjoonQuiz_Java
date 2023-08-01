import java.io.*;
import java.util.*;

public class Q1244 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        /* Input */
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        /* Solve */
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                man(array, number);
            } else {
                woman(array, number);
            }
        }

        System.out.println(getAnswer(array));
    }

    private static void man(int[] array, int number) {
        int idx = 1;
        /* 배수 단위로 스위칭 */
        for (int i = number; i * idx < array.length; idx++) {
            array[i * idx] = array[i * idx] ^ 1;
        }
    }

    private static void woman(int[] array, int number) {
        array[number] = array[number] ^ 1;
        int count = 1;
        while (true) {
            int leftIdx = number - count;
            int rightIdx = number + count;
            /* 예외 발생시 종료 */
            if (leftIdx <= 0 || rightIdx > array.length - 1) {
                break;
            }
            if (array[leftIdx] == array[rightIdx]) { /* 대칭일 경우 수정 */
                array[leftIdx] = array[leftIdx] ^ 1;
                array[rightIdx] = array[rightIdx] ^ 1;
                count++;
            } else { /* 대칭이 아니면 종료 */
                break;
            }
        }
    }

    private static String getAnswer(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            sb.append(array[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}