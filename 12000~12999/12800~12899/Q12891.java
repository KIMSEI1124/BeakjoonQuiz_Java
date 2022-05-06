import java.io.*;
import java.util.*;

public class Q12891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 사용되어야할 문자열의 길이
        char[] arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int[] check_arr = {
                Integer.parseInt(st.nextToken()), // A
                Integer.parseInt(st.nextToken()), // C
                Integer.parseInt(st.nextToken()), // G
                Integer.parseInt(st.nextToken()) // T
        };
        int[] result_arr = new int[5]; // { A, C, G, T, Another }
        // solve
        for (int i = 0; i < S; i++) {
            int delete_point = i - P;
            int insert_point = i;
            if (i == 0) {
                for (int j = 0; j < P; j++) {
                    if (arr[j] == 'A') {
                        result_arr[0]++;
                    } else if (arr[j] == 'C') {
                        result_arr[1]++;
                    } else if (arr[j] == 'G') {
                        result_arr[2]++;
                    } else if (arr[j] == 'T') {
                        result_arr[3]++;
                    } else {
                        result_arr[4]++;
                    }
                }
                i += P - 1;
            } else { // 슬라이딩 윈도우 사용
                // insert
                char insert_check = arr[insert_point];
                if (insert_check == 'A') {
                    result_arr[0]++;
                } else if (insert_check == 'C') {
                    result_arr[1]++;
                } else if (insert_check == 'G') {
                    result_arr[2]++;
                } else if (insert_check == 'T') {
                    result_arr[3]++;
                } else {
                    result_arr[4]++;
                }
                // delete
                char delete_check = arr[delete_point];
                if (delete_check == 'A') {
                    result_arr[0]--;
                } else if (delete_check == 'C') {
                    result_arr[1]--;
                } else if (delete_check == 'G') {
                    result_arr[2]--;
                } else if (delete_check == 'T') {
                    result_arr[3]--;
                } else {
                    result_arr[4]--;
                }
            }
            // check구간
            if (result_arr[4] == 0) {
                ans++;
                for (int j = 0; j < 4; j++) {
                    if (result_arr[j] < check_arr[j]) {
                        ans--;
                        break;
                    }
                }
            }
        }
        // output
        System.out.println(ans);
    }
}