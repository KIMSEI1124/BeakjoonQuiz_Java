import java.io.*;
import java.util.*;

public class Q17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] nge_arr = new int[N + 1];
        Stack<Integer> stack = new Stack<>(); // arr의 index값 저장
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // solve
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (!stack.isEmpty() && num > arr[stack.peek()]) {
                int arr_id = stack.pop();
                nge_arr[arr_id] = num;
            }
            stack.push(i);
        }
        for (int i = 1; i < nge_arr.length; i++) {
            if (nge_arr[i] == 0) { // 값이 없으면
                ans.append("-1").append(" "); // -1
            } else { // 값이 있으면
                ans.append(nge_arr[i]).append(" "); // 오큰수
            }
        }
        // output
        System.out.println(ans);
    }
}