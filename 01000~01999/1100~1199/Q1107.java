import java.io.*;
import java.util.*;

public class Q1107 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();
        int N = Integer.parseInt(nStr);
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        if (N == 100) {
            System.out.println("0");
        } else {
            int ch = 0;
            int count = 0;
            // 숫자 버튼 누르기
            for (int i = 0; i < nStr.length(); i++) { // 맨 앞자리부터 버튼 누르기
                int num = Integer.parseInt(nStr.substring(i, i + 1));
                if (!list.contains(num)) {
                    ch += num * (int) Math.pow(10, nStr.length() - 1 - i);
                } else {
                    
                }
            }
            // +, - 버튼 누르기
        }
    }
}