import java.io.*;
import java.util.*;

public class Q1935 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int A = 'A';

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        int[] numbers = getNumbers(N);
        System.out.println(getAnswer(postfix, numbers));
    }

    private static int[] getNumbers(int N) throws IOException {
        int[] numbers = new int[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        return numbers;
    }

    private static String getAnswer(String postfix, int[] numbers) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String temp : postfix.split("")) {
            if (isOperation(temp)) {
                stack.push(calc(temp, stack.pop(), stack.pop()));
                continue;
            }
            int index = temp.charAt(0) - A;
            stack.push(Double.valueOf(numbers[index]));
        }
        return String.format("%.2f", stack.pop());
    }

    private static final String[] operations = { "+", "-", "*", "/" };

    private static boolean isOperation(String temp) {
        for (String operation : operations) {
            if (temp.equals(operation)) {
                return true;
            }
        }
        return false;
    }

    private static double calc(String operation, double num2, double num1) {
        if (operation.equals("+")) {
            return num1 + num2;
        }
        if (operation.equals("-")) {
            return num1 - num2;
        }
        if (operation.equals("*")) {
            return num1 * num2;
        }
        if (operation.equals("/")) {
            return num1 / num2;
        }
        return 0D;
    }
}