import java.io.*;
import java.util.*;

public class Q1753 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int V;
    private static int E;
    private static int start;

    public static void main(String[] args) throws IOException {
        input();

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
    }
}