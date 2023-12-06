package LEVEL2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 석유_시추 {

    private static final int[] dr = {-1, 0, 0, 1};
    private static final int[] dc = {0, -1, 1, 0};
    private static Map<Integer, Integer> map = new HashMap<>(); // Key: Id, Value: Size
    private static boolean[][] visited;
    private static int answer = Integer.MIN_VALUE;
    private static int size;
    private static int id = 1;

    public int solution(int[][] land) {
        getMap(land);
        getMaxSize(land);
        return answer;
    }

    public void getMap(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    size = 0;
                    dfs(land, r, c);
                    map.put(id++, size);
                }
            }
        }
    }

    public void dfs(int[][] land, int r, int c) {
        visited[r][c] = true;
        land[r][c] = id;
        size++;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (newR < 0 || newR >= land.length || newC < 0 || newC >= land[0].length || land[newR][newC] == 0 || visited[newR][newC]) {
                continue;
            }
            dfs(land, newR, newC);
        }
    }

    private void getMaxSize(int[][] land) {
        for (int c = 0; c < land[0].length; c++) {
            Set<Integer> isSelected = new HashSet<>();
            int size = 0;
            for (int r = 0; r < land.length; r++) {
                if (land[r][c] != 0 && !isSelected.contains(land[r][c])) {
                    isSelected.add(land[r][c]);
                    size += map.get(land[r][c]);
                }
            }
            answer = Math.max(answer, size);
        }
    }
}
