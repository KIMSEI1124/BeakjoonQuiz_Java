import java.io.*;
import java.util.*;

/**
 * 오류 발생
 * 6
 */
public class Q1014 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            answer.append(getResult()).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] Class = get_Class(N, M);
        return getMax(Class);
    }

    private static int[] get_Class(int N, int M) throws IOException {
        int[] Class = new int[M];
        for (int i = 0; i < N; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (isDot(array[j])) {
                    Class[j]++;
                }
            }
        }
        return Class;
    }

    private static boolean isDot(char word) {
        return word == '.';
    }

    private static int getMax(int[] Class) {
        for (int i = 2; i < Class.length; i++) {
            if (i == 2) {
                Class[i] += Class[i - 2];
                continue;
            }
            Class[i] += Math.max(Class[i - 2], Class[i - 3]);
            // System.out.println(Arrays.toString(Class));
        }
        Arrays.sort(Class);
        return Class[Class.length - 1];
    }
}