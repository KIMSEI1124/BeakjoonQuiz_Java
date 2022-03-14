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
            ArrayList<craft<Integer, Integer, Integer, ArrayList<Integer>, Boolean>> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(new craft<Integer, Integer, Integer, ArrayList<Integer>, Boolean>());
                list.get(i).setCraft(Integer.parseInt(st.nextToken()), i + 1, false); // 노드의 비용
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                ArrayList<Integer> endList = new ArrayList<>(list.get(start - 1).getEnd());
                endList.add(end);
                list.get(start - 1).addEnd(endList);
            }
            int W = Integer.parseInt(br.readLine()); // 도착해야할 노드

            // solve 단계
            int time = 0;
            Queue<craft<Integer, Integer, Integer, ArrayList<Integer>, Boolean>> queue = new LinkedList<>();
            while (list.get(W - 1).getBuild() == false) {
                int max = 0;
                if (queue.size() == 0 && list.get(0).getBuild() == false) {
                    queue.add(list.get(0));
                    time += queue.peek().getTime();
                }
                ArrayList<Integer> endList = new ArrayList<>(queue.peek().getEnd());
                for (int i = 0; i < queue.peek().getEnd().size(); i++) {
                    queue.add(list.get(endList.get(i) - 1));
                    max = Math.max(max, list.get(endList.get(i) - 1).getStart());
                }
                time += max;
                list.get(queue.poll().getStart() - 1).setBuild(true); // 생산이 완료 되었으므로 true로 변경
            }
            sb.append(time + "\n");
            T--;
            for (int i = 0; i < list.size(); i++) {
                list.get(i).print();
            }
        }
        System.out.println(sb);
    }
}

class craft<N, T, S, E, B> {
    private N num;
    private T time; // int
    private S start; // int
    private ArrayList<Integer> end; // ArrayList<Integer>
    private B build; // Boolean

    public void setCraft(N num, T time, S start, B build) {
        this.num = num;
        this.time = time;
        this.start = start;
        ArrayList<Integer> endlist = new ArrayList<>();
        this.end = endlist;
        this.build = build;
    }

    public void addEnd(ArrayList<Integer> end) {
        this.end = end;
    }

    public void setBuild(B build) {
        this.build = build;
    }

    public T getTime() {
        return this.time;
    }

    public S getStart() {
        return this.start;
    }

    public ArrayList<Integer> getEnd() {
        return this.end;
    }

    public B getBuild() {
        return this.build;
    }

    public void print() {
        System.out.println("num : " + this.num +
                ", Time : " + this.time + ", Start : " + this.start + ", End : " + this.end + ", Build : "
                + this.build);
    }
}