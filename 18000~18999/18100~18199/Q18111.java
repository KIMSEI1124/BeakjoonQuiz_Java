import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken()); // y좌표 N
        int X = Integer.parseInt(st.nextToken()); // x좌표 M
        int B = Integer.parseInt(st.nextToken()); // 블록의 개수

        int sec = 1000000000;
        int h = 0;

        int[][] world = new int[Y][X];
        int min_Block = 0, max_Block = 500;
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                int block = Integer.parseInt(st.nextToken());
                world[i][j] = block;
                if (block > max_Block) {
                    max_Block = block;
                } else if (block < min_Block) {
                    min_Block = block;
                }
            }
        }

        for (int i = min_Block; i <= max_Block; i++) {
            int remove_Block = 0, build_Block = 0;
            // 제거해야할 블록, 생성해야할 블록의 개수 구하기
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    int world_Block = world[j][k];
                    if (world_Block > i) { // 제거하는 블록 개수
                        remove_Block += world_Block - i;
                    } else if (world_Block < i) { // 생성하는 블록 개수
                        build_Block += i - world_Block;
                    }
                }
            }
            int check_B = B - build_Block + remove_Block;
            if (check_B >= 0) {
                int check_Sec = build_Block + 2 * remove_Block;
                if (check_Sec <= sec) {
                    sec = check_Sec;
                    h = i;
                }
            }
        }
        System.out.println(sec + " " + h);
    }
}