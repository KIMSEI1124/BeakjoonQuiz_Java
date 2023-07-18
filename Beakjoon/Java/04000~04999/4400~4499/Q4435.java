import java.util.*;
import java.io.*;

public class Q4435 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int[] gandalfArmyScore = { 1, 2, 3, 3, 4, 10 };
        int[] sauronArmyScore = { 1, 2, 2, 2, 3, 5, 10 };

        for (int i = 1; i <= t; i++) {
            int[] gandalfArmy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] sauronArmy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int gandalfScore = getScore(gandalfArmy, gandalfArmyScore);
            int sauronScore = getScore(sauronArmy, sauronArmyScore);

            answer.append("Battle ").append(i).append(": ");
            if (gandalfScore > sauronScore) {
                answer.append("Good triumphs over Evil");
            } else if (gandalfScore < sauronScore) {
                answer.append("Evil eradicates all trace of Good");
            } else {
                answer.append("No victor on this battle field");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static int getScore(int[] army, int[] armyScore) {
        int score = 0;
        for (int i = 0; i < army.length; i++) {
            score += army[i] * armyScore[i];
        }
        return score;
    }
}