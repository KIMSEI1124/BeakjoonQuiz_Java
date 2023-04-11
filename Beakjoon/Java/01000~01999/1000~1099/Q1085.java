import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1085 {
    public static void main(String[] args) throws IOException {
        int[] xywh = new int[4];
        input(xywh);
        int xMin = Math.min(xywh[0], xywh[2]-xywh[0]);
        int yMin = Math.min(xywh[1], xywh[3]-xywh[1]);
        int min = Math.min(xMin, yMin);
        System.out.print(min);
    }

    public static int[] input(int[] xywh) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = 0;
        while (num <= 3) {
            xywh[num] = Integer.parseInt(st.nextToken());
            num++;
        }
        return xywh;
    }
}
