import java.io.*;

public class Q1436 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        for(int i = 666; i < Integer.MAX_VALUE; i++) {
            if(String.valueOf(i).contains("666")) {
                count--;
            }
            if(count == 0) {
                answer.append(i);
                break;
            }
        }
        System.out.println(answer);
    }
}