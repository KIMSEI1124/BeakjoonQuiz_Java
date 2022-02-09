import java.util.*;

public class Q1546 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        Double[] arr = new Double[N];
        Double maxScore;
        Double totalScore = 0.0;
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(sc.next());
        }
        Arrays.sort(arr);
        maxScore = arr[N - 1];
        for (int i = 0; i < N; i++) {
            arr[i] = (arr[i]/maxScore)*100;
            totalScore += arr[i];
        }
        System.out.println(totalScore/N);
    }
}