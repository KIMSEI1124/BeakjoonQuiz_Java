import java.io.*;
import java.util.*;

public class Q18185 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static StringTokenizer st;
    static int N;
    static int[] factory;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        factory = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        for (int i = 0; i < N;) {
            if (factory[i] != 0) {
                if (i + 1 < N && factory[i + 1] != 0) {
                    if (i + 2 < N && factory[i + 2] != 0) {
                        factory[i + 2]--;
                        ans += 7;
                        if (factory[i + 1] - 1 > factory[i + 2]) {
                            factory[i + 2]++;
                            ans -= 2;
                        }
                    } else {
                        ans += 5;
                    }
                    factory[i + 1]--;
                } else {
                    ans += 3;
                }
                factory[i]--;
            } else { // 공장에 라면이 존재하지 않을경우에만 증가
                i++;
            }
        }

        // output
        System.out.println(ans);
    }
}