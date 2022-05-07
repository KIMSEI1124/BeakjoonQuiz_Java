import java.io.*;
import java.util.*;

public class Q1427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // input
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        // solve
        for(int i = arr.length-1; i >=0; i--) {
            ans.append(arr[i]);
        }
        // output
        System.out.println(ans);
    }
}