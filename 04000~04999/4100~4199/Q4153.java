import java.io.*;
import java.util.*;

public class Q4153 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while ((str = br.readLine()) != null && str.length() > 0) {
            st = new StringTokenizer(str);
            int A = (int) (Math.pow(Double.parseDouble(st.nextToken()), 2));
            int B = (int) (Math.pow(Double.parseDouble(st.nextToken()), 2));
            int C = (int) (Math.pow(Double.parseDouble(st.nextToken()), 2));
            if (A != 0) {
                if (A == B + C) {
                    sb.append("right\n");
                } else if (B == A + C) {
                    sb.append("right\n");
                } else if (C == A + B) {
                    sb.append("right\n");
                } else {
                    sb.append("wrong\n");
                }
            }
        }
        System.out.println(sb);
    }
}