import java.io.*;
import java.util.*;

public class Q15997 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] country = br.readLine().split(" ");
        Double[] score = { 0.0, 0.0, 0.0, 0.0 };
        for (int i = 0; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken(),
                    B = st.nextToken();
            Double W = Double.parseDouble(st.nextToken()),
                    D = Double.parseDouble(st.nextToken()) / 2,
                    L = Double.parseDouble(st.nextToken());
            check(country, score, A, W, D);
            check(country, score, B, L, D);
        }
        for (int i = 0; i < 4; i++) {
            score[i] /= 3;
            sb.append(score[i] + "\n");
        }
        System.out.println(sb);
    }

    public static Double[] check(String[] country, Double[] score, String countryName, Double win, Double draw) {
        for (int i = 0; i < 4; i++) {
            if (country[i].equals(countryName)) {
                score[i] += win + draw;
                break;
            }
        }
        return score;
    }
}