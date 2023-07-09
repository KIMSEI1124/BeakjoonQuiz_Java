import java.io.*;
import java.util.*;

public class Q2530 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int maxTime = getMaxTime();
        int time = getTime() % maxTime;

        br.close();

        String answer = convertTime(time);
        System.out.println(answer);
    }

    private static int getMaxTime() {
        /* 초 분 시 */
        return 60 * 60 * 24;
    }

    private static int getTime() throws IOException {
        st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken()) * 60 * 60;
        int min = Integer.parseInt(st.nextToken()) * 60;
        int sec = Integer.parseInt(st.nextToken());
        return Integer.parseInt(br.readLine()) + hour + min + sec;
    }

    private static String convertTime(int time) {
        int hour = time / (60 * 60) % 24;
        int min = time / 60 % 60;
        int sec = time % 60;
        return new StringBuilder()
                .append(hour)
                .append(" ")
                .append(min)
                .append(" ")
                .append(sec).toString();
    }
}