import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] HWN = new int[3];
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <= 2; i++) {
                HWN[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(floor(HWN)).append(room(HWN)).append("\n");
            T--;
        }
        System.out.println(sb);
    }

    public static String floor(int[] HWN) {
        int floor = 0;
        if(HWN[2] / HWN[0] != 0 && HWN[2] % HWN[0] == 0) {
            floor = HWN[0];
        } else {
            floor = HWN[2] % HWN[0];
        }
        String strFloor = String.valueOf(floor);
        return strFloor;
    }

    public static String room(int[] HWN) {
        int room = (int) Math.ceil((double) HWN[2] / HWN[0]);
        String strRoom;
        if ((room / 10) == 0) {
            strRoom = "0" + room;
        } else {
            strRoom = "" + room;
        }
        return strRoom;
    }
}