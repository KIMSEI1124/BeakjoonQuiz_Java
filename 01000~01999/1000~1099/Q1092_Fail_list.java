import java.io.*;
import java.util.*;

public class Q1092 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int sec = 0;
        // 크래인 리스트 생성하기
        int crane = Integer.parseInt(br.readLine());
        ArrayList<Integer> craneList = new ArrayList<>();
        craneList = input(craneList);
        // 박스 리스트 생성하기
        int box = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxList = new ArrayList<>();
        boxList = input(boxList);
        // 리스트 정렬하기
        Collections.sort(craneList);
        Collections.sort(boxList);
        while (boxList.size() > 0) {
            for (int i = 0; i < crane; i++) {
                for (int j = 0; j < boxList.size(); j++) {
                    if (i >= crane) {
                        break;
                    }
                    if (craneList.get(i) >= boxList.get(j)) {
                        boxList.remove(j);
                        i++;
                        j--;
                    }
                }
            }
            sec++;
        }
        System.out.println(sec);
    }

    public static ArrayList<Integer> input(ArrayList<Integer> list) throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        return list;
    }
}