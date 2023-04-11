import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24723 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, N);
        System.out.println(N);
    }
}