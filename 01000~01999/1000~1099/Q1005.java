import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1005 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            // input 단계
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드의 개수
            int K = Integer.parseInt(st.nextToken()); // 간선의 개수
            ArrayList<craft<Integer, Integer, ArrayList<Integer>, Boolean>> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // 노드의 제작 시간
                list.add(new craft<Integer, Integer, ArrayList<Integer>, Boolean>());
                ArrayList<Integer> startList = new ArrayList<>();
                list.get(i).setCraft(i + 1, Integer.parseInt(st.nextToken()), startList, false);
            }
            for (int i = 0; i < K; i++) { // 간선의 개수 만큼
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                ArrayList<Integer> startList = new ArrayList<>(list.get(end - 1).getStart());
                startList.add(start);
                list.get(end - 1).addStart(startList);
            }
            int W = Integer.parseInt(br.readLine());
            for (int i = 0; i < list.size(); i++) {
                list.get(i).print();
            }
            //solve
            Queue<craft<Integer, Integer, ArrayList<Integer>, Boolean>> queue = new LinkedList<>();
            while(list.get(W-1).getBuild() == false) {
                
            }
            T--;
        }
        System.out.println(sb);
    }
}

class craft<N, T, S, B> {
    private int node; // 노드의 번호
    private int time; // 제작 시간
    private ArrayList<Integer> start; // 선행 조건
    private Boolean build; // Boolean

    public void setCraft(Integer node, Integer time, ArrayList<Integer> start, Boolean build) {
        this.node = node;
        this.time = time;
        ArrayList<Integer> startList = new ArrayList<>();
        this.start = startList;
        this.build = build;
    }

    public void addStart(ArrayList<Integer> start) {
        this.start = start;
    }

    public void setBuild(Boolean build) {
        this.build = build;
    }

    public int getTime() {
        return this.time;
    }

    public ArrayList<Integer> getStart() {
        return this.start;
    }

    public Boolean getBuild() {
        return this.build;
    }

    public void print() {
        System.out.println("node : " + this.node +
                ", Time : " + this.time + ", Start : " + this.start + ", Build : "
                + this.build);
    }
}