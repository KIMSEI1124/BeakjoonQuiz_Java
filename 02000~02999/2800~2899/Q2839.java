import java.util.*;

public class Q2839 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int suger = sc.nextInt();
        int count = 0;
        int max_5kg = suger / 5;
        int max_3kg = suger / 3;
        for (int i = 0; i <= max_5kg; i++) {
            for (int j = 0; j <= max_3kg; j++) {
                int suger_count = (5 * i) + (3 * j);
                if (suger_count == suger) {
                    count = i + j;
                    break;
                }
            }
        }
        if ( count == 0 ) {
            count = -1;
        }
        System.out.println(count);
    }
}