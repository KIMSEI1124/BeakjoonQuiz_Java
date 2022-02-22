import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1089 {
    static final String S3 = "###";
    static final String S2 = "#.#";
    static final String S1L = "#..";
    static final String S1R = "..#";
    static final String[] zero = new String[] { S3, S2, S2, S2, S3 };
    static final String[] one = new String[] { S1R, S1R, S1R, S1R, S1R };
    static final String[] two = new String[] { S3, S1R, S3, S1L, S3 };
    static final String[] three = new String[] { S3, S1R, S3, S1R, S3 };
    static final String[] four = new String[] { S2, S2, S3, S1R, S1R };
    static final String[] five = new String[] { S3, S1L, S3, S1R, S3 };
    static final String[] six = new String[] { S3, S1L, S3, S2, S3 };
    static final String[] seven = new String[] { S3, S1R, S1R, S1R, S1R };
    static final String[] eight = new String[] { S3, S2, S3, S2, S3 };
    static final String[] nine = new String[] { S3, S2, S3, S1R, S3 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] number = new int[N][5];
        for (int i = 0; i < N; i++) {
            
        }
    }
}