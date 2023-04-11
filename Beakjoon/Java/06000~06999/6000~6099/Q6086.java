import java.io.*;
import java.util.*;

public class Q6086 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static List<String> pipe_id;
    static List<List<Node6068<String, String, Integer>>> pipe;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine()); // 파이프 정보의 개수

        pipe = new ArrayList<>(); // 파이프의 정보
        pipe_id = new ArrayList<>(); // 파이프의 id

        String start_node; // 파이프의 시작 지점
        String target_node; // 파이프의 끝나는 지점
        int water; // 유량

        Node6068<String, String, Integer> node;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start_node = st.nextToken();
            target_node = st.nextToken();
            water = Integer.parseInt(st.nextToken());
            node = new Node6068<>();
            node.set_node(start_node, target_node, water);

            if (!pipe_id.contains(start_node)) { // 시작 노드가 존재하지 않으면
                pipe_id.add(start_node); // Id 저장
                pipe.add(new ArrayList<>());
                pipe.get(pipe.size() - 1).add(node);
            } else {    // 시작 노드가 존재하면
                for (int j = 0; j < pipe.size(); j++) { // Id 찾기
                    if (pipe_id.get(j).equals(start_node)) {
                        pipe.get(j).add(node);
                        break;
                    }
                }
            }
        }
        // solve


        // output
        System.out.println(ans);
    }

    public static void dfs() {
        
    }
}

class Node6068<S, T, W> {
    private String start; // 시작 지점
    private String target; // 끝나는 지점
    private int water; // 유량

    public void set_node(String start, String target, int water) {
        this.start = start;
        this.target = target;
        this.water = water;
    }

    public String get_start() {
        return this.start;
    }

    public String get_target() {
        return this.target;
    }

    public int get_water() {
        return this.water;
    }
}