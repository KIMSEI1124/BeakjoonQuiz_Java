import java.io.*;
import java.util.*;

public class Q1264 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static final List<Character> VOWELS = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
    private static final String SHARP = "#";

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine().toLowerCase().trim();
            if (isSharp(input)) {
                break;
            }
            answer.append(countVowels(input)).append("\n");
        }

        System.out.println(answer);
    }

    private static boolean isSharp(String input) {
        return input.equals(SHARP);
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (VOWELS.contains(c)) {
                count++;
            }
        }
        return count;
    }
}