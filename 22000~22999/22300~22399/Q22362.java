import java.util.*;

public class Q22362 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Bomb> list = new ArrayList<>();
        int[] WHNDB = new int[5];
        for (int i = 0; i < 5; i++) {
            WHNDB[i] = sc.nextInt();
            if (WHNDB[i] == 0) {
                System.out.println(sb);
                break;
            }
        }
        for (int i = 0; i < WHNDB[2]; i++) {
            list.add(Bomb(sc.nextInt(),sc.nextInt(),true));
        }
        System.out.println(list.get(0));
    }

    private static Q22362.Bomb Bomb(int nextInt, int nextInt2, boolean b) {
        return null;
    }

    public class Bomb {
        private int xPos;  // X좌표
        private int yPos;  // Y좌표
        private boolean bombStatus;  // 폭탄의 상태(터짐,안터짐)

        public Bomb(int xPos, int yPos, boolean bombStatus) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.bombStatus = bombStatus;
        }

        void setBombStatus(int xPos, int yPos, boolean bombStatus) {
            this.bombStatus = bombStatus;
        }
    }
}