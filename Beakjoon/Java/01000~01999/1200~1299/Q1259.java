import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1259 {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] arr = br.readLine().split("");
            if (arr.length == 1 && arr[0].equals("0")) { // 배열의 크기가 1이고 값이 0이면 종료
                break;
            } else if (arr.length == 1 && !arr[0].equals("0")) { // 배열의 크기가 1이면 팰린드롬수이므로 yes
                ans.append("yes\n");
            } else { // 배열의 크기가 홀수 이며 3 이상일 경우 확인
                for (int i = 0; i < arr.length / 2; i++) {
                    if (!arr[i].equals(arr[arr.length - 1 - i])) { // 값 확인시 다르면 no
                        ans.append("no\n");
                        break;
                    }
                    if (arr.length / 2 - 1 == i) { // 마지막까지 정상이면 팰린드롬수
                        ans.append("yes\n");
                    }
                }
            }
        }
        System.out.println(ans);
    }
}