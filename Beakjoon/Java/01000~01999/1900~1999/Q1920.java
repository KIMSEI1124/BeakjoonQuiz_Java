import java.io.*;
import java.util.*;

public class Q1920 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];

        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];

        for (int i = 0; i < Math.max(N, M); i++) {
            if (i < N) {
                arr1[i] = Integer.parseInt(stN.nextToken());
            }
            if (i < M) {
                arr2[i] = Integer.parseInt(stM.nextToken());
            }
        }
        Arrays.sort(arr1);
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr1, arr2[i])).append("\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == arr[mid]) {
                return 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
        }
        return 0;
    }
}