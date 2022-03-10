import java.io.*;
import java.util.*;

public class Q11053 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> check = new ArrayList<>();   // 중복값 확인하기 위한 리스트
        int[] arr = new int[N];
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 1;
            if (check.contains(arr[i])) {
                continue;
            } else {
                check.add(arr[i]);
                for (int j = i + 1; j < arr.length; j++) {
                    if (Math.max(num, arr[j]) == arr[j]) {
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(maxCount);
    }
}