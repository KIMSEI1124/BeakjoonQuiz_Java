import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1259 {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (true) {
            str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            String[] arr = str.split("");
            for (int i = 1; i < arr.length / 2; i++) {
                if (arr.length % 2 == 0 || !arr[i].equals(arr[arr.length - i])) {
                    ans.append("no\n");
                    break;
                }
                if (i - 1 == arr.length / 2) {
                    ans.append("yes\n");
                }
            }
        }
        System.out.println(ans);
    }
}