import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1920 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(stN.nextToken()));
            arr[i] = Integer.parseInt(stM.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if (list.contains(arr[i])) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}