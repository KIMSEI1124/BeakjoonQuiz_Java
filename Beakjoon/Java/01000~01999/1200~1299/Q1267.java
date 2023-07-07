import java.io.*;
import java.util.*;

public class Q1267 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static final int Y_COST = 10;
    private static final int Y_TIME = 30;
    private static final int M_COST = 15;
    private static final int M_TIME = 60;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = inputArray();

        int totalYCost = 0;
        int totalMCost = 0;
        for (int i = 0; i < n; i++) {
            int time = array[i];
            totalYCost += getCost(time, Y_COST, Y_TIME);
            totalMCost += getCost(time, M_COST, M_TIME);
        }

        if (totalMCost > totalYCost) {
            answer.append("Y ").append(totalYCost);
        } else if (totalYCost > totalMCost) {
            answer.append("M ").append(totalMCost);
        } else {
            answer.append("Y M ").append(totalMCost);
        }
        System.out.println(answer);
    }

    private static int[] inputArray() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int getCost(int useTime, int cost, int time) {
        int useCost = ((useTime / time) + 1) * cost;
        return useCost;
    }
}