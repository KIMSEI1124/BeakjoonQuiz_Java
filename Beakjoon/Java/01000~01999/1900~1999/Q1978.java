import java.io.*;
import java.util.*;

public class Q1978 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        br.readLine();
        int[] numbers = getNumbers();
        List<Integer> prime = getPrime(Arrays
                .stream(numbers)
                .max()
                .getAsInt());
        int answer = getAnswer(prime, numbers);
        System.out.println(answer);
    }

    private static List<Integer> getPrime(int index) {
        List<Integer> prime = new ArrayList<>(List.of(2));
        boolean flag;
        for (int i = 3; i <= index; i++) {
            flag = true;
            for (Integer number : prime) {
                if (i % number == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prime.add(i);
            }
        }
        return prime;
    }

    private static int[] getNumbers() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int getAnswer(List<Integer> prime, int[] numbers) {
        int answer = 0;
        for (int number : numbers) {
            if (prime.contains(number)) {
                answer++;
            }
        }
        return answer;
    }
}