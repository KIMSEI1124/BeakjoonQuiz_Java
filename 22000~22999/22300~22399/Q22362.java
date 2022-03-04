import java.io.*;
import java.util.*;

public class Q22362 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Boom<Integer, Integer, Boolean>> list = new ArrayList<>();
        Queue<Boom<Integer, Integer, Boolean>> queue = new LinkedList<>();
        int[] WHNDB = { 100, 100, 100, 100, 100 }; // 폭, 높이, 폭탄의 수, 폭탄의 폭팔 범위, 첫 폭탄의 번호
        while (WHNDB[0] != 0) {
            int count = 1;
            list.clear();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) { // 세팅
                WHNDB[i] = Integer.parseInt(st.nextToken());
            }
            if (WHNDB[0] == 0) { // 종료 조건
                break;
            }
            for (int i = 0; i < WHNDB[2]; i++) { // 폭탄 세팅
                st = new StringTokenizer(br.readLine());
                int xPos = Integer.parseInt(st.nextToken());
                int yPos = Integer.parseInt(st.nextToken());
                list.add(new Boom<Integer, Integer, Boolean>());
                list.get(i).setBoom(xPos, yPos, false);
            }
            // 폭탄
            queue.add(list.get(WHNDB[4] - 1));
            list.get(WHNDB[4] - 1).setisBoom(true);
            while (queue.isEmpty() == false) {
                int xBoom = queue.peek().getxPos();
                int yBoom = queue.peek().getyPos();
                int xMin = xBoom - WHNDB[3];
                int xMax = xBoom + WHNDB[3];
                int yMin = yBoom - WHNDB[3];
                int yMax = yBoom + WHNDB[3];
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getisBoom() == false) { // 안터진 폭탄인것을 확인
                        int xPos = list.get(i).getxPos();
                        int yPos = list.get(i).getyPos();
                        if (yPos == yBoom && xMin <= xPos && xPos <= xMax) { // x범위 확인
                            queue.add(list.get(i));
                            list.get(i).setisBoom(true);
                            count++;
                        }
                        if (xPos == xBoom && yMin <= yPos && yPos <= yMax) { // y범위 확인
                            queue.add(list.get(i));
                            list.get(i).setisBoom(true);
                            count++;
                        }
                    }
                }
                queue.remove(); // 확인된 폭탄 제거
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

class Boom<x, y, is> {
    private x xPos;
    private y yPos;
    private is isBoom; // ture 터짐, false 안터짐

    public void setBoom(x xPos, y yPos, is isBoom) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isBoom = isBoom;
    }

    public int getxPos() {
        return (int) this.xPos;
    }

    public int getyPos() {
        return (int) this.yPos;
    }

    public boolean getisBoom() {
        return (boolean) this.isBoom;
    }

    public void setisBoom(is isBoom) {
        this.isBoom = isBoom;
    }

    public void printBoom() {   // 폭탄 확인
        System.out.println("xPos : " + this.xPos + ", yPos : " + this.yPos + ", isBoom : " + isBoom);
    }
}