import java.io.*;
import java.util.*;

public class Q22251 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int N; // 건물의 층수
    private static int K; // 디스플레이 자리의 수
    private static int P; // LED 최대 반전의 수
    private static int X; // 실제로 멈춰있는 층

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }
}