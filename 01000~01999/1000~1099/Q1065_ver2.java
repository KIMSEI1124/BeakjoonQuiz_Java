import java.io.*;
import java.util.stream.Stream;

public class Q1065_ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int num;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static public void input() throws IOException {
        num = Integer.parseInt(br.readLine());
    }

    static public int solve() {
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            int[] arr = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            Double median = 0.0;
            for (int j = 0; j < arr.length; j++) {
                
            }
        }
        return answer;
    }
}