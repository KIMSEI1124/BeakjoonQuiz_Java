import java.io.*;
import java.util.*;

public class Q2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static Stack<int[]> stack = new Stack<>();
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        int count = 0;
        List<Integer> apt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        // solve
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '1') {
                    count++;    // 단지의 수
                    arr[i][j] = '0';
                    int[] pos = { i, j };
                    apt.add(bfs(pos));
                }
            }
        }
        ans.append(count).append("\n");
        Collections.sort(apt);
        for (int i = 0; i < apt.size(); i++) {
            ans.append(apt.get(i)).append("\n");
        }
        // output
        System.out.println(ans);
    }

    public static void up_search(int[] check_pos) {
        int y_pos = check_pos[0];
        int x_pos = check_pos[1];
        if (y_pos == 0) {
            return;
        }
        if (arr[y_pos - 1][x_pos] == '1') {
            int[] pos = { y_pos - 1, x_pos };
            arr[y_pos - 1][x_pos] = '0';
            stack.push(pos);
        }
    }

    public static void down_search(int[] check_pos) {
        int y_pos = check_pos[0];
        int x_pos = check_pos[1];
        if (y_pos == arr.length - 1) {
            return;
        }
        if (arr[y_pos + 1][x_pos] == '1') {
            int[] pos = { y_pos + 1, x_pos };
            arr[y_pos + 1][x_pos] = '0';
            stack.push(pos);
        }
    }

    public static void left_search(int[] check_pos) {
        int y_pos = check_pos[0];
        int x_pos = check_pos[1];
        if (x_pos == 0) {
            return;
        }
        if (arr[y_pos][x_pos - 1] == '1') {
            int[] pos = { y_pos, x_pos - 1 };
            arr[y_pos][x_pos - 1] = '0';
            stack.push(pos);
        }
    }

    public static void right_search(int[] check_pos) {
        int y_pos = check_pos[0];
        int x_pos = check_pos[1];
        if (x_pos == arr.length - 1) {
            return;
        }
        if (arr[y_pos][x_pos + 1] == '1') {
            int[] pos = { y_pos, x_pos + 1 };
            arr[y_pos][x_pos + 1] = '0';
            stack.push(pos);
        }
    }

    public static int bfs(int[] pos) {
        int count = 0;
        stack.push(pos);
        while (!stack.isEmpty()) { // 스택이 비어있지 않을경우
            count++;
            int[] check_pos = stack.pop();
            up_search(check_pos);
            down_search(check_pos);
            left_search(check_pos);
            right_search(check_pos);
        }
        return count;
    }
}