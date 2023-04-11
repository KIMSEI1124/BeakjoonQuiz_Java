import java.io.*;

public class Q9498 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int score;

    public static void main(String[] args) throws IOException {
        score = Integer.parseInt(br.readLine());
        String credit;
        if ( 90 <= score && score <= 100) {
            credit = "A";
        } else if ( 80 <= score) {
            credit = "B";
        } else if ( 70 <= score ) {
            credit = "C";
        } else if ( 60 <= score) {
            credit = "D";
        } else {
            credit = "F";
        }
        System.out.println(credit);
    }
}
