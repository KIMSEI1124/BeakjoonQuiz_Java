import java.util.ArrayList;
import java.util.Scanner;

public class Q9012 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(sc.nextLine());
        while (T > 0) {
            String[] PS = sc.nextLine().split("");
            if (PS.length % 2 == 0) {
                solve(PS);
                sb.append("1\n");
            } else {
                sb.append("NO\n");
            }
            T--;
        }
        System.out.println(sb);
    }

    public static void solve(String[] PS) {
        ArrayList<String> list = new ArrayList<>();
        for(String i : PS) {
            list.add(i);
        }
        int N = list.size();
        while(N>0){
            
        }
    }
}