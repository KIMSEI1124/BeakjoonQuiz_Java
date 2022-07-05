import java.io.*;
import java.util.*;

public class Q9080 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int[][] day_hour_min;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            input();
            // solve
            // 22:00 - 8 : 00 야간 요금 이용 가능 -> 5,000원
            // - 야간 요금은 241분 이상 즐기면 이득 그외에는 일반 요금이 이득
            
            T--;
        }

        // output
        System.out.println(ans);
    }

    public static void input() throws IOException {
        day_hour_min = new int[2][3]; // 일, 시, 분
        st = new StringTokenizer(br.readLine());
        String time_str = st.nextToken();
        int play_time = Integer.parseInt(st.nextToken()); // 이용 시간
        st = new StringTokenizer(time_str, ":"); // hour, min 분리
        day_hour_min[0][1] = Integer.parseInt(st.nextToken());
        day_hour_min[0][2] = Integer.parseInt(st.nextToken());

        day_hour_min[1][1] = day_hour_min[0][1] + play_time / 60;
        day_hour_min[1][2] = day_hour_min[0][2] + play_time % 60;
        if (day_hour_min[1][2] >= 60) { // min 계산기
            day_hour_min[1][2] -= 60;
            day_hour_min[1][1] += 1;
        }
        if (day_hour_min[1][1] >= 24) { // hour 계산기
            day_hour_min[1][1] -= 24;
            day_hour_min[1][0] += 1;
        }
    }
}