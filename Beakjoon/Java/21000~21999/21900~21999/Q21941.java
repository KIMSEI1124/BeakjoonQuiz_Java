import java.io.*;
import java.util.*;

public class Q21941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String S;
    static int M;

    public static void main(String[] args) throws IOException {
        // input
        int ans = 0;
        S = br.readLine();
        M = Integer.parseInt(br.readLine());
        String A;
        int V;

        // solve
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken(); // 문자열
            V = Integer.parseInt(st.nextToken());   // 점수
            S = S.replaceAll(A, "-");   // 변환

            st = new StringTokenizer(S, "-", true); // 나누기
            S = ""; // 초기화
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (str.equals("-")) {  // "-" 이면 점수 추가
                    ans += V;
                } else {    // 아니면 S 문자열에 추가
                    S += str;
                }
            }
        }
        ans += S.length();

        // output
        System.out.println(ans);
    }
}

/*
input : 
abcdabcd
2
abcd 8
bcdabc 13

output : 
16

정담 : 17점
 */