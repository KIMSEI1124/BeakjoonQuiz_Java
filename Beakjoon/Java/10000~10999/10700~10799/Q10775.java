import java.io.*;
import java.util.stream.IntStream;

public class Q10775 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;
    private static int[] gates;

    public static void main(String[] args) throws IOException {
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        gates = IntStream.range(0, G).toArray();

        while (P-- > 0) {
            int plane = Integer.parseInt(br.readLine());
            int gate = find(plane);
            if (gate != 0) {
                union(gate, gate - 1);
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    private static int find(int plane) {
        return plane == gates[plane] ? plane : (gates[plane] = find(gates[plane]));
    }

    private static void union(int gate1, int gate2) {
        gate1 = find(gate1);
        gate2 = find(gate2);
        gates[gate1] = gate2;
        answer++;
    }
}