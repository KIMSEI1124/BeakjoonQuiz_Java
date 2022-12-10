import java.io.*;

public class Q11718 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = "";
        try {
            // https://gre-eny.tistory.com/307 정리하기
            while ((input = br.readLine()) != null && !input.isEmpty()) {
                    answer.append(input).append("\n");
            }
        } catch (Exception e) {

        }
        System.out.println(answer);
    }
}