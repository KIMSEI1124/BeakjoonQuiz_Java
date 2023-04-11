import java.util.Scanner;

public class Q13458 {
    static Scanner sc = new Scanner(System.in);
    static final int roomNum = sc.nextInt();

    public static void main(String[] args) {
        int[] people = new int[roomNum]; // 각 시험장에 있는 응시자의 수
        for (int i = 0; i < roomNum; i++) {
            people[i] = sc.nextInt();
        }
        int main = sc.nextInt(); // 총감독관이 감시할 수 있는 응시자의 수
        int sub = sc.nextInt(); // 부감독관이 감시할 수 있는 응시자의 수
        long total = 0; // 총 필요한 감독관 수
        for (int i = 0; i < roomNum; i++) {
            total++; // 각 시험장에는 한명의 총 감독관이 있다.
            int roomPeople = people[i];
            if (roomPeople > main) {   // 총감독관이 전부를 감시할 수 없는 경우
                roomPeople -= main;
                total += roomPeople / sub;
                if (roomPeople % sub != 0) {
                    total++;
                }
            }
        }
        System.out.print(total);
    }
}