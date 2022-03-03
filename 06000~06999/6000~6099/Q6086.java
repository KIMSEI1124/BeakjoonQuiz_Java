import java.io.*;
import java.util.*;

public class Q6086 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<pipe<String, String, Integer>> pipeList = new ArrayList<>();
        String StartPoint;
        String EndPoint;
        int water;
        for (int i = 0; i < N; i++) { // 파이프의 정보를 담기
            st = new StringTokenizer(br.readLine());
            StartPoint = st.nextToken();
            EndPoint = st.nextToken();
            water = Integer.parseInt(st.nextToken());
            pipeList.add(new pipe<String, String, Integer>());
            pipeList.get(i).setPipe(StartPoint, EndPoint, water);
        }
        while (N > 0) {
            for (int i = 0; i < pipeList.size() - 1; i++) {
                for (int j = i + 1; j < pipeList.size(); j++) {
                    String pipeOneSP = pipeList.get(i).getSP();
                    String pipeOneEP = pipeList.get(i).getEP();
                    String pipeTwoSP = pipeList.get(j).getSP();
                    String pipeTwoEP = pipeList.get(j).getEP();
                    int pipeOneW = pipeList.get(i).getW();
                    int pipeTwoW = pipeList.get(j).getW();
                    // POSP가 A이고 PTED가 Z이면서 POED와 PTSP가 같을경우 합침
                    if (pipeOneSP.equals("A") && pipeTwoEP.equals("Z") && pipeOneEP.equals(pipeTwoSP)) {
                        pipeList.add(new pipe<String, String, Integer>());
                        pipeList.get(0).setPipe(pipeOneSP, pipeTwoEP, Math.min(pipeOneW, pipeTwoW));
                        // 두개의 파이프를 합쳤으므로 삭제한다.
                        pipeList.remove(j+1);
                        pipeList.remove(i+1);
                    } else if (pipeTwoSP.equals("A") && pipeOneEP.equals("Z") && pipeTwoEP.equals(pipeOneSP)) {
                        pipeList.add(new pipe<String, String, Integer>());
                        pipeList.get(0).setPipe(pipeTwoSP, pipeOneEP, Math.min(pipeOneW, pipeTwoW));
                        // 두개의 파이프를 합쳤으므로 삭제한다.
                        pipeList.remove(j+1);
                        pipeList.remove(i+1);
                    }
                    if (pipeOneSP.equals(pipeTwoSP) && pipeOneEP.equals(pipeTwoEP)) { // 두개의 파이프의 SP와 EP가 동일할때 W를 합친다.
                        pipeList.add(new pipe<String, String, Integer>());
                        pipeList.get(pipeList.size() - 1).setPipe(pipeOneSP, pipeOneSP,
                                pipeOneW + pipeTwoW);
                        pipeList.remove(j+1);
                        pipeList.remove(i+1);
                    } else if (pipeOneEP.equals(pipeTwoSP)) { // 1번 파이프의 EP와 2번 파이프의 SP가 1번 파이프의 SP와 2번 파이프의 EP와 두개의
                                                              // 파이프중 W가 작은 것을 저장한다.
                        pipeList.add(new pipe<String, String, Integer>());
                        pipeList.get(0).setPipe(pipeOneSP, pipeTwoEP, Math.min(pipeOneW, pipeTwoW));
                        pipeList.remove(j+1);
                        pipeList.remove(i+1);
                    }
                }
            }
            N--;
        }
        for (int i = 0; i < pipeList.size(); i++) {
            pipeList.get(i).printPipe();
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

    public void printPipe() {
        System.out.println("SP : " + this.StartPoint + ", EP : " + this.EndPoint + ", W : " + this.water);
    }
}