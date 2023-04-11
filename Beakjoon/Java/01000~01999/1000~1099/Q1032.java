import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1032 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        String[] arr = br.readLine().split("");
        N--;
        while (N > 0) {
            str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (!arr[i].equals("?") && !arr[i].equals(str.substring(i, i+1))) {
                    arr[i] = "?";
                }
            }
            N--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.print(sb);
    }
}