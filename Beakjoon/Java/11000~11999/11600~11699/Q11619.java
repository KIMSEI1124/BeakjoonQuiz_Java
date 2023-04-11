import java.io.*;
import java.util.*;

public class Q11619 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // GreenHouse의 크기
        int m = Integer.parseInt(st.nextToken()); // Day
        int[] house = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        /*
         * A : 왼쪽의 값이 자신보다 크면 +1
         * B : 오른쪽의 값이 자신보다 크면 +1
         */
        char[] day = br.readLine().toCharArray();

        // solve
        for(int i = 0; i < m; i++) {
            house = grow(house, day[i]);
        }

        for(int i = 1; i <= n; i++) {
            ans.append(house[i]+" ");
        }
        // output
        System.out.println(ans);
    }

    public static int[] grow(int[] house, char c) {
        if (c == 'B') {
            for (int i = house.length - 2; i > 0; i--) {
                if (house[i] < house[i + 1]) {
                    house[i]++;
                }
            }
        } else {
            for (int i = 2; i < house.length; i++) {
                if (house[i] < house[i - 1]) {
                    house[i]++;
                }
            }
        }
        return house;
    }
}