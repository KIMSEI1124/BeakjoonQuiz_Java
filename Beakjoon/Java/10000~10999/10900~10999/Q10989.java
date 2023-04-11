import java.io.*;
import java.util.*;

public class Q10989 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve2();
    }

    public static void solve1() throws NumberFormatException, IOException { // 메모리 418192KB, 시간 : 2624ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            ans.append(arr[i] + "\n");
        }
        System.out.println(ans);
    }

    public static void solve2() throws NumberFormatException, IOException { // 메모리 385036KB, 시간 : 1748ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        while (N > 0) {
            int num = Integer.parseInt(br.readLine());
            arr[num - 1] += 1;
            N--;
        }
        for (int i = 0; i < 10000; i++) {
            int count = arr[i];
            while (count > 0) {
                ans.append((i + 1) + "\n");
                count--;
            }
        }
        System.out.println(ans);
    }
}