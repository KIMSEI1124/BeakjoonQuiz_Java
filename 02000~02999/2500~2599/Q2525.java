import java.io.*;
import java.util.StringTokenizer;

public class Q2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int run = Integer.parseInt(br.readLine());
        solve(hour, min, run);
    }

    public static void solve(int hour, int min, int run) {
        min += run;
        if (min >= 60) {
            hour += min / 60;
            if (hour >= 24) {
                hour %= 24;
            }
            min %= 60;
        }
        System.out.println(hour+" "+min);
    }
}