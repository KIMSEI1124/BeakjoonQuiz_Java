import java.io.*;
import java.util.*;

public class Q1092 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M;

    static List<Integer> C;
    static HashMap<Integer, Integer> B; // Key : 박스의 무게, Value : 박스의 개수

    public static void main(String[] args) throws IOException {
        // input
        int max_C = 0, max_B = 0, min_B = 1000000, day = 0;
        N = Integer.parseInt(br.readLine()); // 크레인의 수
        C = new ArrayList<>(); // 크레인의 무게 제한
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            C.add(Integer.parseInt(st.nextToken()));
            max_C = Math.max(max_C, C.get(C.size() - 1));
        }
        M = Integer.parseInt(br.readLine()); // 박스의 수
        B = new HashMap<>(); // 박스들의 집합
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int b = Integer.parseInt(st.nextToken()); // 박스의 무개
            max_B = Math.max(max_B, b);
            min_B = Math.min(min_B, b);
            if (!B.containsKey(b)) {
                B.put(b, 1);
            } else {
                B.put(b, B.get(b) + 1);
            }
        }

        // solve
        if (max_B > max_C) {
            ans.append("-1");
        } else {
            /* 1. 크레인은 자신이 옴길수 있는 가장 큰 박스를 먼저 움긴다. */
            int c_power;
            int b_count;
            while (M > 0) {
                for (int i = 0; i < C.size(); i++) {
                    c_power = C.get(i);
                    for (int j = c_power; j >= min_B; j--) {
                        if (B.containsKey(j)) {
                            b_count = B.get(j);
                            if (b_count > 0) {
                                // System.out.println(B);
                                B.replace(j, b_count - 1);
                                M--;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                day++;
            }
            ans.append(day);
        }

        // output
        System.out.println(ans);
    }
}