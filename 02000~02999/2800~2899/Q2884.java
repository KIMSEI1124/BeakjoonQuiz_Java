import java.util.Scanner;

public class Q2884 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int hour = sc.nextInt();
        int min = sc.nextInt();
        System.out.println(Setting(hour, min));
    }

    public static String Setting(int hour, int min) {
        String alram = "";
        min -= 45; //  45분 일찍 알람 설정하기
        if ( min < 0) {
            hour--; // 한시간 앞으로 앞당기기
            if ( hour < 0) {    // 만약 전날로 설정을 해야한다면
                hour = 23;
            }
            min += 60;  // -된 숫자 수정
        }
        alram = String.valueOf(hour) + " " + String.valueOf(min);
        return alram;
    }
}
