import java.io.*;
import java.util.Arrays;

public class Q10820 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static final char a = 'a';
    private static final char z = 'z';
    private static final char A = 'A';
    private static final char Z = 'Z';
    private static final char space = ' ';

    public static void main(String[] args) throws IOException {
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            getResult(input.toCharArray());
        }
        System.out.println(answer);
    }

    private static void getResult(char[] arr) {
        int[] result = new int[4]; // 소문자, 대문자, 숫자, 공백
        for (char word : arr) {
            if (isSmallAlpha(word)) {
                result[0]++;
                continue;
            }
            if (isLargeAlpha(word)) {
                result[1]++;
                continue;
            }
            if (isNumber(word)) {
                result[2]++;
                continue;
            }
            if (isSpace(word)) {
                result[3]++;
            }
        }
        Arrays.stream(result).forEach(value -> {
            answer.append(value).append(" ");
        });
        answer.append("\n");
    }

    private static boolean isSmallAlpha(char word) {
        return a <= word && word <= z;
    }

    private static boolean isLargeAlpha(char word) {
        return A <= word && word <= Z;
    }

    private static boolean isSpace(char word) {
        return word == space;
    }

    private static boolean isNumber(char word) {
        return Character.isDigit(word);
    }
}