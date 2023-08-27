import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8911 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final char FRONT_MOVE = 'F';
    private static final char BACK_MOVE = 'B';
    private static final char LEFT_TURN = 'L';
    private static final char RIGHT_TURN = 'R';
    private static char[] orders;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            input();
            solve();
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        orders = br.readLine().toCharArray();
    }

    public static void solve() {
        Turtle turtle = Turtle.init();
        for (char order : orders) {
            turtle.carryOutAnOrder(order);
        }
        answer.append(turtle.getMaxArea()).append("\n");
    }

    private static class Turtle {
        /* 북, 동, 남, 서 */
        private final int[] dy = { -1, 0, 1, 0 };
        private final int[] dx = { 0, 1, 0, -1 };
        private final Pos pos;
        private final Pos maxPos;
        private final Pos minPos;
        private int direction;

        private Turtle() {
            pos = Pos.init();
            maxPos = Pos.init();
            minPos = Pos.init();
        }

        public static Turtle init() {
            return new Turtle();
        }

        public void carryOutAnOrder(char order) {
            if (order == FRONT_MOVE) {
                moveFront();
                return;
            }
            if (order == BACK_MOVE) {
                moveBack();
                return;
            }
            if (order == RIGHT_TURN) {
                turnRight();
                return;
            }
            if (order == LEFT_TURN) {
                turnLeft();
            }
        }

        private void moveFront() {
            pos.updateY(pos.getY() + dy[direction]);
            pos.updateX(pos.getX() + dx[direction]);
            updateMaxAndMinByPos(pos);
        }

        private void moveBack() {
            pos.updateY(pos.getY() - dy[direction]);
            pos.updateX(pos.getX() - dx[direction]);
            updateMaxAndMinByPos(pos);
        }

        private void turnRight() {
            direction = (direction + 1) % 4;
        }

        /**
         * 왼쪽으로 회전을 할 때 `direction`이 0미만이 되면 `3`으로 수정한다.
         */
        private void turnLeft() {
            try {
                if (direction - 1 < 0) {
                    throw new RuntimeException();
                }
                direction = direction - 1;
            } catch (RuntimeException e) {
                direction = 3;
            }
        }

        private void updateMaxAndMinByPos(Pos pos) {
            maxPos.updateY(Math.max(pos.getY(), maxPos.getY()));
            maxPos.updateX(Math.max(pos.getX(), maxPos.getX()));
            minPos.updateY(Math.min(pos.getY(), minPos.getY()));
            minPos.updateX(Math.min(pos.getX(), minPos.getX()));
        }

        public int getMaxArea() {
            return (maxPos.getY() - minPos.getY()) * (maxPos.getX() - minPos.getX());
        }
    }

    private static class Pos {
        private int y;
        private int x;

        private Pos() {
        }

        public static Pos init() {
            return new Pos();
        }

        public int getY() {
            return y;
        }

        public void updateY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void updateX(int x) {
            this.x = x;
        }
    }
}
