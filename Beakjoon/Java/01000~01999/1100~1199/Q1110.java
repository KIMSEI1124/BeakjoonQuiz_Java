import java.util.*;

public class Q1110 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        solve2();
    }

    // 에러 발생
    // StringIndexOutOfBounds
    public static void solve() {
        ArrayList<String> list = new ArrayList<>();
        String tmp;
        if(N == 0) {
            tmp = "00";
        } else {
            tmp = String.valueOf(N);
        }
        String check = tmp;
        while (true) {
            tmp = ten(tmp) + one(tmp);
            list.add(tmp);
            if (list.contains(check)) {
                System.out.println(list.size());
                break;
            }
        }
    }

    public static String ten(String tmp) { // 십의 자리
        String str = tmp.substring(1, 2);
        return str;
    }

    public static String one(String tmp) { // 일의 자리
        String str = "";
        int num = Integer.parseInt(tmp.substring(0, 1)) + Integer.parseInt(tmp.substring(1, 2));
        if (num >= 10) {
            str = String.valueOf(num).substring(1, 2);
        } else {
            str = String.valueOf(num);
        }
        return str;
    }

    // 정답
    public static void solve2() {
        ArrayList<Integer> list = new ArrayList<>();
        int tmp = N;
        while(true){
            int A = tmp / 10;
            int B = tmp % 10;
            int C = (A + B) % 10;
            tmp = B*10+C;
            list.add(tmp);
            if(list.contains(N)) {
                break;
            }
        }
        System.out.println(list.size());
    }
}   