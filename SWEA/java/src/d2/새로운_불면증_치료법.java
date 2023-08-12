package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 새로운_불면증_치료법 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스의 갯수
        for (int i = 1; i <= t; i++) {
            answer.append("#").append(i).append(" ").append(getBitResult()).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        Set<Integer> container = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int count = n;

        while (true) {
            int[] numbers = Arrays.stream(String.valueOf(count)
                            .split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (Integer number : numbers) {
                if (container.contains(number)) {  // 해당 숫자를 이미 읽었을 경우
                    continue;
                }
                container.add(number);
            }
            if (container.size() == 10) { // 종료 조건
                break;
            }
            count += n;
        }

        return count;
    }

    private static int getBitResult() throws IOException {
        int bit = 0;
        int end = (1 << 10) - 1;    // 모든 숫자가 등장했을 때의 값
        int n = Integer.parseInt(br.readLine());
        int count = n;

        while (true) {
            int[] numbers = Arrays.stream(String.valueOf(count)
                            .split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (Integer number : numbers) {
                bit = bit | (1 << number);
            }
            if (bit == end) {
                break;
            }
            count += n;
        }

        return count;
    }
}
