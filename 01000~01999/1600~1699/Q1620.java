import java.io.*;
import java.util.*;

// 이분탐색

public class Q1620 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> poekmon = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            poekmon.put(i, br.readLine());
        }
        while (M > 0) {
            String str = br.readLine();
            int strInt;
            try { // 성공시 도감번호로 이름 검색
                strInt = Integer.parseInt(str);
                sb.append(poekmon.get(strInt)).append("\n");
            } catch (Exception e) { // 실패시 이름으로 도감 번호 검색
                for (int i = 1; i <= poekmon.size(); i++) {
                    if (poekmon.get(i).equals(str)) {
                        sb.append(i).append("\n");
                        break;
                    }
                }
            }
            M--;
        }
        System.out.println(sb);
    }
}