import java.io.*;
import java.util.*;

public class Q18186 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long ans = 0;
    static StringTokenizer st;
    static int N, B, C;
    static int[] factory;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        factory = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            factory[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int count;
        for (int i = 0; i < N;) {
            if (factory[i] != 0) {
                count = factory[i];
                if (i + 1 < N && factory[i + 1] != 0) {
                    count = Math.min(count, factory[i + 1]);
                    if (i + 2 < N && factory[i + 2] != 0) {
                        count = Math.min(count, factory[i + 2]);
                        factory[i + 2] -= count;
                        ans += (B + C * 2) * count;
                        if (factory[i + 1] - count > factory[i + 2]) {
                            factory[i + 2] += count;
                            ans -= C;
                        }
                    } else {
                        ans += (B + C) * count;
                    }
                    factory[i + 1] -= count;
                } else {
                    ans += B * count;
                }
                factory[i] -= count;
            } else { // 공장에 라면이 존재하지 않을경우에만 증가
                i++;
            }
        }

        // output
        System.out.println(ans);
    }
}