import java.io.*;
import java.util.*;

public class Q25304 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String answer = "No";
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int money = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());
            money += price * unit;
        }
        if( X == money) {
            answer = "Yes";
        }
        System.out.println(answer);
    }
}