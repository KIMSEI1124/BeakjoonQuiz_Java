import java.io.*;
import java.util.*;

public class Q1063 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder ans = new StringBuilder();
	static StringTokenizer st;

	static char[] king_pos, stone_pos;
	static int N, K_yPos, K_xPos, S_yPos, S_xPos;

	public static void main(String[] args) throws IOException {
		// input
		st = new StringTokenizer(br.readLine());
		/*
		 * A~H : [y][0] ~ [y][7] -> [y][x.pos - 'A']
		 * 1~8 : [7][x] ~ [0][x] -> [y.pos][x]
		 */
		king_pos = st.nextToken().toCharArray(); // 킹의 시작 좌표
		K_yPos = (int) king_pos[1]; // 왕의 y좌표
		K_xPos = king_pos[0] - 'A'; // 왕의 x좌표
		stone_pos = st.nextToken().toCharArray(); // 돌의 시작 좌표
		S_yPos = (int) stone_pos[1]; // 돌의 y좌표
		S_xPos = stone_pos[0] - 'A'; // 돌의 x좌표
		N = Integer.parseInt(st.nextToken()); // 움직이는 회수

		// solve
		while (N > 0) {
			String code = br.readLine();
			for (int i = 0; i < op.length; i++) {
				if (code.equals(op[i])) {
					move(i);
					break;
				}
			}
			N--;
		}

		br.close();

		// output
		ans.append(String.valueOf((char) (K_xPos + 'A'))).append((char) K_yPos).append("\n");
		ans.append(String.valueOf((char) (S_xPos + 'A'))).append((char) S_yPos);
		System.out.println(ans);
	}

	static String[] op = {
			"R", "L", "B", "T",
			"RT", "LT", "RB", "LB" };
	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void move(int i) {
		int new_K_xPos = K_xPos + dx[i];
		int new_K_yPos = K_yPos + dy[i];
		if (check(new_K_xPos, new_K_yPos)) { // 킹의 새로운 좌표에 대한 오류 체크
			return;
		}
		// 1. 만약 이동한 곳에 돌이 있다면
		if (new_K_xPos == S_xPos && new_K_yPos == S_yPos) {
			// 1.1. 돌의 새로운 좌표에 대한 오류 체크
			int new_S_xPos = S_xPos + dx[i];
			int new_S_yPos = S_yPos + dy[i];
			if (check(new_S_xPos, new_S_yPos)) {
				return;
			}
			// 1.2. 돌 이동
			S_xPos = new_S_xPos;
			S_yPos = new_S_yPos;
		}
		// 2. 킹 이동
		K_xPos = new_K_xPos;
		K_yPos = new_K_yPos;
	}

	/**
	 * 오류 체크
	 */
	public static boolean check(int xPos, int yPos) {
		if (xPos < 0 || xPos > 7) {
			return true;
		}
		if (yPos < 49 || yPos > 56) {	// 아스키 코드
			return true;
		}
		return false;
	}
}