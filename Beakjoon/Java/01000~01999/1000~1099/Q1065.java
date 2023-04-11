import java.io.*;
import java.util.stream.Stream;

public class Q1065 {
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
                total += arr[j];
                if (j == 0) { // 중앙값 구하기
                    median = ((arr[0] + arr[arr.length - 1]) / 2.0);
                }
                if (j == arr.length - 1) { // total값을 구했을때
                    double checkMedian = (1.0 * total) / arr.length; // 중앙값과 비교
                    if (checkMedian == median) { // 비교했을시 동일하면 한수찾음
                        answer++;
                        System.out.println(i);
                    }
                }
            }
        }
        return answer;
    }
}