import java.io.*;
import java.util.*;

public class Q1241 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //HashMap<Integer, Integer> hash = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] student = new int[N];
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                /*
                if (hash.containsKey(student[i])) { // 중복된 값을 확인하여 있으면 꺼내쓰기
                    count = hash.get(student[i]);
                    break;
                }
                */
                int check = student[i] % student[j];
                if (check == 0) {
                    count++;
                }
            }
            sb.append(count + "\n");
            /*
            if (!hash.containsKey(student[i])) {
                hash.put(student[i], count);
            }
            */
        }
        System.out.println(sb);
    }
}