package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQ {

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
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        Arrays.fill(minEdge, Integer.MAX_VALUE);    // 최소값 갱신을 위해 큰 값으로 설정
        minEdge[0] = 0; // 임의의 0정점을 트리 구성의 시작으로 하기 위해서 설정
        priorityQueue.add(new Vertex(0, minEdge[0]));

        int result = 0; // 최소 신장 트리의 비용
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            // STEP 1 : 미 방문(비트리) 정점 중 최소간선비용의 정점을 선택
            Vertex cur = priorityQueue.poll();

            /* 이미 방문한 정점이면 무시하기 */
            if (visited[cur.no]) {
                continue;
            }

            // STEP 2 : 방문 정점에 추가
            visited[cur.no] = true;  // 방문 처리
            result += cur.weight;              // 신장트리 비용 누적

            if (++count == V) {
                break;
            }

            // STEP 3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려(aka, 영업타임)
            for (int i = 0; i < V; i++) {
                if (!visited[i] && matrix[cur.no][i] != 0 && minEdge[i] > matrix[cur.no][i]) {
                    minEdge[i] = matrix[cur.no][i];
                    priorityQueue.offer(new Vertex(i, minEdge[i]));
                }
            }
        }
        System.out.println(result);
    }

    private static class Vertex implements Comparable<Vertex> {
        int no;     // 정점 번호
        int weight; // 트리정점과 연결했을 때의 간선 비용

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
