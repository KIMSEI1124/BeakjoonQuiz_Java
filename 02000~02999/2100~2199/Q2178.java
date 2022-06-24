import java.io.*;
import java.util.*;

public class Q2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        // solve
        
        // output
        System.out.println(ans);
    }

    public static void up_search() {

    }

    public static void down_search() {

    }
    
    public static void left_search() {

    }

    public static void right_search() {

    }
}