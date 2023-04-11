import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1076 {
    public static void main(String[] args) throws IOException {
        long answer = 0L;
        String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = { br.readLine(), br.readLine(), br.readLine() };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                if (arr[i].equals(colors[j])) {
                    if (i == 0) {
                        answer += j * 10;
                    } else if (i == 1) {
                        answer += j;
                    } else {
                        answer *= (int) Math.pow(10, j);
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}