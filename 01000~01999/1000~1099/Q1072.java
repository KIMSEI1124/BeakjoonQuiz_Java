import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int total;
    static int win;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(total+" "+win);
    }
    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        total = br.read();
        win = br.read();
    }
}
