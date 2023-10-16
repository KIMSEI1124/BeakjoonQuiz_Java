package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Q22251 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] array = new int[][]{
            // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2}, // 0
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4}, // 1
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3}, // 2
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1}, // 3
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2}, // 4
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1}, // 5
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2}, // 6
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3}, // 7
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1}, // 8
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0} // 9
    };
    private static int answer;
    private static int N, K, P, X;

    private static Set<Integer> visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
        System.out.println(visited);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 최대 층 수
        K = Integer.parseInt(st.nextToken()); // 자리 수
        P = Integer.parseInt(st.nextToken()); // 반전 시킬 수 있는 최대 수
        X = Integer.parseInt(st.nextToken()); // 실제 층 수

        visited = new TreeSet<>();
    }

    private static void solve() {
        int[] floor = makeFloorArray();
        search(0, 0, floor);
        visited.remove(convertArrayToInt(floor));
        visited.remove(0);
        answer = visited.size();
    }

    /**
     * 입력 받은 현재 층 수를 배열로 만듭니다.
     * ex) 35층에 최대 3자리 이라면, [0, 3, 5]
     */
    private static int[] makeFloorArray() {
        int[] floor = new int[K];
        int temp = X;
        for (int i = K - 1; i >= 0; i--) {
            floor[i] = (temp % 10);
            temp /= 10;
        }

        return floor;
    }

    private static void search(int index, int count, int[] floorArray) {
        int floor = convertArrayToInt(floorArray);
        if (count > P || floor > N) {
            return;
        }

        visited.add(floor);

        if (index >= K) {
            return;
        }

        int number = floorArray[index];
        int[] convert = array[number]; // 반전 횟수 배열

        for (int i = 0; i <= 9; i++) {
            floorArray[index] = i;
            search(index + 1, count + convert[i], floorArray);
            floorArray[index] = number;
        }
    }

    private static int convertArrayToInt(int[] floor) {
        return Integer.parseInt(Arrays.stream(floor).mapToObj(String::valueOf).collect(Collectors.joining()));
    }
}
