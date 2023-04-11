import java.io.*;
import java.util.*;

public class Q23629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static String[] str_arr = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
    static int[] int_arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    static String S;
    static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        // input
        S = br.readLine();
        deque = new LinkedList<>();
        for (int i = 0; i < str_arr.length; i++) { // 문자 -> 숫자 변환
            S = S.replaceAll(str_arr[i], String.valueOf(int_arr[i]));
        }
        
        // solve
        st = new StringTokenizer(S, "+-x/=", true); // 숫자와 연산자 분리

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals("=")) { // 결과
                while (deque.size() != 1) {
                    try {
                        int num_1 = Integer.parseInt(deque.pollFirst());
                        String op_code = deque.pollFirst(); // 연산자
                        int num_2 = Integer.parseInt(deque.pollFirst());
                        int result_num; // 결과값
                        if (op_code.endsWith("+")) { // 더하기
                            result_num = num_1 + num_2;
                        } else {
                            result_num = num_1 - num_2;
                        }
                        deque.addLast(String.valueOf(result_num));
                    } catch (Exception e) {
                        ans.append("Madness!");
                        break;
                    }
                }
                if (ans.length() == 0) {
                    ans.append(S + "\n");
                    S = deque.pollLast();
                    for (int i = 0; i < str_arr.length; i++) {
                        S = S.replaceAll(String.valueOf(int_arr[i]), str_arr[i]);
                    }
                    ans.append(S);
                }
            } else if (str.equals("x") || str.equals("/")) { // 곱하기, 나누기
                try {
                    int num_1 = Integer.parseInt(deque.pollLast());
                    int num_2 = Integer.parseInt(st.nextToken());
                    int result_num;
                    if (str.equals("x")) { // 곱하기
                        result_num = num_1 * num_2;
                    } else { // 나누기
                        result_num = num_1 / num_2;
                        // 정수 나눗셈의 처리 방식은 C의 방식을 따른다.
                        // 즉, 0에 가까운 정수를 취한다.
                        if (num_1 % num_2 != 0 && deque.peekLast().equals("-")) {
                            result_num += 1;
                        }
                    }
                    deque.addLast(String.valueOf(result_num));
                } catch (Exception e) {
                    ans.append("Madness!");
                    break;
                }
            } else { // 숫자, 더하기, 빼기
                deque.addLast(str);
            }
        }

        // output
        System.out.println(ans);
    }
}