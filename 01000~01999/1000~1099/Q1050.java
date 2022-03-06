import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 재료의 개수
        int M = Integer.parseInt(st.nextToken()); // 물약의 식
        HashMap<String, Integer> hash = new HashMap<>();
        while (N > 0) { // 재료 저장
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            N--;
        }
        while (M > 0) {
            st = new StringTokenizer(br.readLine(), "=");
            System.out.println(st.countTokens());
            M--;
        }
    }
}