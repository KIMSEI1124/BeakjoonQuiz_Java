package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특이한_자석 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int t;

    private static int k;

    private static int result;

    private static List<Cogwheel> cogwheelList;

    private static Queue<Command> queue;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        result = 0;
        k = Integer.parseInt(br.readLine());
        cogwheelList = new ArrayList<>();
        cogwheelList.add(Cogwheel.dummy()); // 0번 인덱스는 더미
        for (int i = 0; i < 4; i++) {
            cogwheelList.add(Cogwheel.from(new StringTokenizer(br.readLine())));
        }

        queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            queue.offer(Command.from(new StringTokenizer(br.readLine())));
        }
    }

    private static void solve() {
        while (!queue.isEmpty()) {
            Command command = queue.poll();
            runCommand(command.getId(), command.getOrder(), new boolean[6]);
        }
        for (int i = 1; i <= 4; i++) {
            result += cogwheelList.get(i).getScore(i);
        }
    }

    private static void runCommand(int id, int order, boolean[] visited) {
        visited[id] = true;

        if (id == 0 || id == 5) {
            return;
        }


        Cogwheel cogwheel = cogwheelList.get(id);

        boolean canTurnLeft = id != 1 && !visited[id - 1] && cogwheelList.get(id - 1).canTurn(id - 1, id, cogwheel);
        boolean canTurnRight = id != 4 && !visited[id + 1] && cogwheelList.get(id + 1).canTurn(id + 1, id, cogwheel);

        cogwheel.turn(order);

        int otherOrder = order * -1;

        if (canTurnLeft) {
            runCommand(id - 1, otherOrder, visited);
        }
        if (canTurnRight) {
            runCommand(id + 1, otherOrder, visited);
        }
    }

    private static class Cogwheel {
        private final int[] array;
        private int head;
        private int right;
        private int left;

        private Cogwheel() { // 더미
            this.array = new int[0];
        }

        private Cogwheel(StringTokenizer st) {
            this.array = new int[9];
            for (int i = 1; i <= 8; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            head = 1;
            right = 3;
            left = 7;
        }

        public static Cogwheel dummy() {
            return new Cogwheel();
        }

        public static Cogwheel from(StringTokenizer st) {
            return new Cogwheel(st);
        }

        public Cogwheel turn(int order) {
            if (order == 1) {
                turnRight();
            } else {
                turnLeft();
            }
            return this;
        }

        private void turnRight() {  // 1
            head = --head == 0 ? 8 : head;
            left = --left == 0 ? 8 : left;
            right = --right == 0 ? 8 : right;
        }

        private void turnLeft() {   // 0
            head = ++head == 9 ? 1 : head;
            left = ++left == 9 ? 1 : left;
            right = ++right == 9 ? 1 : right;
        }

        public boolean canTurn(int id, int otherId, Cogwheel other) {
            if (otherId < id) { // `other id`가 작으면 right(other) <--> left(me) 비교
                return other.getRight() != getLeft();
            } else { // `other id`가 크면 right(me) <--> left(other) 비교
                return getRight() != other.getLeft();
            }
        }

        public int getLeft() {
            return array[left];
        }

        public int getRight() {
            return array[right];
        }

        private int getHead() {
            return array[head];
        }

        public int getScore(int id) {
            if (getHead() == 1) {
                return (int) Math.pow(2, (id - 1));
            }
            return 0;
        }
    }

    private static class Command {
        private final int id;
        private final int order;

        private Command(int id, int order) {
            this.id = id;
            this.order = order;
        }

        public static Command from(StringTokenizer st) {
            int id = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            return new Command(id, order);
        }

        public int getId() {
            return id;
        }

        public int getOrder() {
            return order;
        }
    }
}