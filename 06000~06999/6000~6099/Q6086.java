import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q6086 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<pipe<Integer, Integer, Integer>> pipeList = new ArrayList<>();
        char StartPoint;
        char EndPoint;
        int water;
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            StartPoint = st.nextToken().charAt(0);
            EndPoint = st.nextToken().charAt(0);
            water = Integer.parseInt(st.nextToken());
            if (pipeList.size() == 0) {
                pipeList.add(new pipe<Integer, Integer, Integer>());
            }
            N--;
        }
    }
}

class pipe<SP, EP, W> {
    private SP StartPoint;
    private EP EndPoint;
    private W water;

    public void setPipe(SP StartPoint, EP EndPoint, W water) {
        this.StartPoint = StartPoint;
        this.EndPoint = EndPoint;
        this.water = water;
    }

    public SP getSP() {
        return this.StartPoint;
    }

    public EP getEP() {
        return this.EndPoint;
    }

    public W getW() {
        return this.water;
    }
}