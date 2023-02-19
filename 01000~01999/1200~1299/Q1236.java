import java.io.*;
import java.util.*;

public class Q1236 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] castle = getCastle(N, M);
        System.out.println(getAnswer(castle));
    }

    private static char[][] getCastle(int N, int M) throws IOException {
        char[][] castle = new char[N][M];
        for (int i = 0; i < castle.length; i++) {
            castle[i] = br.readLine().toCharArray();
        }
        return castle;
    }

    private static int getAnswer(char[][] castle) {
        int answer = 0;
        boolean[][] visited = new boolean[castle.length][castle[0].length];
        for (int i = 0; i < castle.length; i++) {
            for (int j = 0; j < castle[i].length - i; j++) {
                answer++;
            }
        }
        return answer;
    }
}

/*
OOOOXXXX
OO.OOOOO
XXOXOXXO
OO.OOOOO
OO.OOOOO
 */