import java.util.*;
import java.io.*;

public class Q10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다
        int N = Integer.parseInt(br.readLine());    // 줄의 개수
        char[][] grid = new char[N][];
        boolean[][] visited = new boolean[N][];
        for(int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        dfs(grid, visited, 0, 0);

    }

    public static void dfs(char[][] grid, boolean[][] visited, int y, int x) {

    }
}