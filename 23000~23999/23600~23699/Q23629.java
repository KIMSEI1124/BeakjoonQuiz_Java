import java.io.*;
import java.util.*;

public class Q23629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        String str = br.readLine();
        String[] arr1 = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
        int[] arr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Long> lq = new ArrayList<>();
        List<String> meq = new ArrayList<>();
        // solve
        for (int i = 0; i < arr1.length; i++) {
            str = str.replaceAll(arr1[i], String.valueOf(arr2[i]));
        }
        ans.append(str).append("\n"); // 숫자로된 수식 저장
        st = new StringTokenizer(str, "+-x/=", true);
        int run = 0;
        while (st.hasMoreTokens()) {
            if (run % 2 == 0) {
                try {
                    lq.add(Long.valueOf(st.nextToken()));
                } catch (Exception e) { // 수식이 연속으로 나오면
                    ans.delete(0, ans.length());
                    ans.append("Madness!");
                    run = 0;
                    break;
                }
            } else {
                meq.add(st.nextToken());
            }
            run++;
        }
        // 정상적으로 while문을 통과한다면
        if (run != 0) {

        }

        // 소수점이하는 무조건 버림

        // output
        System.out.println(lq);
        System.out.println(meq);
        System.out.println(ans);
    }

    public static Long add() {  // 더하기
        Long add = 0L;
        return add;
    }

    public static Long substract() {    // 빼기 
        Long add = 0L;
        return add;
    }

    public static Long multiply() { // 곱하기
        Long add = 0L;
        return add;
    }

    public static Long divide() {   // 나누기
        Long add = 0L;
        return add;
    }
}