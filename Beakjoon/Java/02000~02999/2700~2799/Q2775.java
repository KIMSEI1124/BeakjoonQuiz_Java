import java.io.*;

public class Q2775 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] address = new int[T][2]; // 층과 호수 저장
        int maxK = 0;
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j <= 1; j++) {
                address[i][j] = Integer.parseInt(br.readLine());
                if (j == 0 && address[i][j] > maxK) {
                    maxK = address[i][j];
                } else if (j == 1 && address[i][j] > maxN) {
                    maxN = address[i][j];
                }
            }
        }
        int[][] apt = new int[maxK + 1][maxN];
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt[i].length; j++) {
                if (i == 0) {
                    apt[i][j] = j + 1;
                } else if (j == 0) {
                    apt[i][j] = apt[i - 1][j];
                } else {
                    apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
                }
            }
        }
        for (int i = 0; i < T; i++) {
            int k = address[i][0];
            int n = address[i][1];
            sb.append(apt[k][n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}