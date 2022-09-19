import java.io.*;
import java.util.*;

public class Q10282 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T, n, d, c;
    static List<List<Computer_10282<Integer, Integer>>> net;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());
        int a, b, sec;
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            net = new ArrayList<>();
            n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
            d = Integer.parseInt(st.nextToken()); // 의존성의 개수
            c = Integer.parseInt(st.nextToken()); // 해킹당할 컴퓨터의 번호
            for (int i = 0; i < n; i++) {
                net.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());   // a 컴퓨터가
                b = Integer.parseInt(st.nextToken());   // b 를 의존
                sec = Integer.parseInt(st.nextToken()); // 감염되기까지 걸리는 시간
                Computer_10282<Integer, Integer> com = new Computer_10282<>();
                com.set_computer(a, sec);
                net.get(b).add(com);
            }
            // solve

            T--;
        }

        // output
        System.out.println(ans);
    }
}

class Computer_10282<id, sec> {
    private int id;
    private int sec;

    public void set_computer(int id, int sec) {
        this.id = id;
        this.sec = sec;
    }

    public int get_id() {
        return this.id;
    }

    public int get_sec() {
        return this.sec;
    }
}