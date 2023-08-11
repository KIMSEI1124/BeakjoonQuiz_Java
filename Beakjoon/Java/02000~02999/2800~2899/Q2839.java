import java.util.*;

public class Q2839 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int sugar = sc.nextInt();
        int count = 0;
        int max_5kg = sugar / 5;
        int max_3kg = sugar / 3;
        for (int i = 0; i <= max_5kg; i++) {
            for (int j = 0; j <= max_3kg; j++) {
                int sugar_count = (5 * i) + (3 * j);
                if (sugar_count == sugar) {
                    count = i + j;
                    break;
                }
            }
        }
        if (count == 0) {
            count = -1;
        }
        System.out.println(count);
    }
}