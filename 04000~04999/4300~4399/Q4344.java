import java.util.Scanner;

public class Q4344 {
    static Scanner sc = new Scanner(System.in);
    static int testCase = sc.nextInt();

    public static void main(String[] args) {
        for (int i = 0; i < testCase; i++) {
            solve();
        }
    }

    public static void solve() {
        int student = sc.nextInt();
        int[] arrScore = new int[student];
        int totalScore = 0; // 학생들의 총 점수
        int count = 0; // 평균을 넘는 학생을 구하는 수

        // 학생들의 점수를 배열에 저장하고 학생들의 총 점수를 구한다.
        for (int i = 0; i < student; i++) {
            arrScore[i] = sc.nextInt();
            totalScore += arrScore[i];
        }

        double averageScore = totalScore / student;

        for (int i = 0; i < student; i++) {
            if (arrScore[i] > averageScore) {
                count++;
            }
        }
        
        double ratio = ((100)/(double) student)*count;  // 비율 계산
        System.out.println(String.format("%.3f", ratio)+"%");
    }
}