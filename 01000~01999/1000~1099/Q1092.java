import java.io.*;
import java.util.*;

public class Q1092 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int sec = 0;
        // 크래인 배열 생성하기
        int crane = Integer.parseInt(br.readLine());
        int[] craneArr = new int[crane];
        craneArr = input(craneArr);
        // 박스 배열 생성하기
        int box = Integer.parseInt(br.readLine());
        int[] boxArr = new int[box];
        boolean[] boxIsArr = new boolean[box];
        boxArr = input(boxArr);
        // 배열 정렬하기
        // Arrays.sort(craneArr);
        Arrays.sort(boxArr);
        // 풀이
        while (box > 0) {
            for (int i = craneArr.length - 1; i >= 0; i--) {
                for (int j = boxArr.length - 1; j >= 0; j--) {
                    if (craneArr[i] >= boxArr[j] && boxIsArr[j] == false) {
                        box--;
                        boxIsArr[j] = true;
                        break;
                    }
                }
            }
            sec++;
        }
        System.out.println(sec);
    }

    public static int[] input(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}