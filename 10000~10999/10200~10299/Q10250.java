import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
            int W = Integer.parseInt(st.nextToken()); // 호텔의 방 수
            int N = Integer.parseInt(st.nextToken()); // 몇번째 손님
            // 층수 구하기
            int floor = floor(H, N);
            System.out.println("층수 : " + floor);
            // 호수 구하기
            T--;
        }
    }

    public static int floor(int H, int N) {
        int floor = N % H;
        return floor;
    }

    public static int room(int H, int N) {
        int room = 0;
        /*
         * if (N / H == 0) {
         * room = 1;
         * } else if (N % H <= 9 && N / H )
         */
        return room;
    }
}