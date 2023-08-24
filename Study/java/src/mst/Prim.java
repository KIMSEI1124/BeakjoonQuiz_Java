package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 방문 정점 (트리 정점 표시) */
        boolean[] visited = new boolean[V];
        int[] minEdge = new int[V]; // 자신과 트리의 정점들 간 최소 비용

        Arrays.fill(minEdge, Integer.MAX_VALUE);    // 최소값 갱신을 위해 큰 값으로 설정
        minEdge[0] = 0; // 임의의 0정점을 트리 구성의 시작으로 하기 위해서 설정

        int result = 0; // 최소 신장 트리의 비용
        int min = 0;
        int minVertex = 0;

        for (int c = 0; c < V; c++) {
            min = Integer.MAX_VALUE;
            minVertex = -1;
            // STEP 1 : 미 방문(비트리) 정점 중 최소간선비용의 정점을 선택
            for (int i = 0; i < V; i++) {
                if (!visited[i] && min > minEdge[i]) {
                    minVertex = i;
                    min = minEdge[i];
                }
            }

            // STEP 2 : 방문 정점에 추가
            visited[minVertex] = true;  // 방문 처리
            result += min;              // 신장트리 비용 누적

            // STEP 3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려(aka, 영업타임)
            for (int i = 0; i < V; i++) {
                if (!visited[i] && matrix[minVertex][i] != 0 && minEdge[i] > matrix[minVertex][i]) {
                    minEdge[i] = matrix[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}
