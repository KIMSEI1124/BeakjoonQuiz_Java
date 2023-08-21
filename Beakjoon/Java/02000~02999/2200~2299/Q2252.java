import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static Student[] students;

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        students = new Student[n + 1];

        for (int i = 1; i <= n; i++) {
            students[i] = Student.init();
        }

        /* 학생 키 입력 */
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int bigHeightStudentId = Integer.parseInt(st.nextToken());
            int smallHeightStudentId = Integer.parseInt(st.nextToken());

            /* 연결 */
            students[bigHeightStudentId].addStudentId(smallHeightStudentId);
            students[smallHeightStudentId].addQuantity();
        }
    }

    private static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();

        /* 진입 차수가 0인 객체들을 큐에 저장 */
        for (int i = 1; i <= n; i++) {
            if (students[i].canAddWithQueue()) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int studentId = queue.poll();
            answer.append(studentId).append(" ");

            for (int nextStudentId : students[studentId].getStudentIds()) {
                /* 다음 객체의 진입 차수를 1감소하고 큐에 넣을 수 있으면 큐에 추가합니다. */
                students[nextStudentId].minusQuantity();
                if (students[nextStudentId].canAddWithQueue()) {
                    queue.add(nextStudentId);
                }
            }
        }
    }

    private static class Student {
        private final List<Integer> studentIds;
        private int quantity;

        private Student() {
            studentIds = new ArrayList<>();
        }

        public static Student init() {
            return new Student();
        }

        public boolean canAddWithQueue() {
            return quantity == 0;
        }

        public void addStudentId(int id) {
            studentIds.add(id);
        }

        public void addQuantity() {
            quantity++;
        }

        public void minusQuantity() {
            quantity--;
        }

        public List<Integer> getStudentIds() {
            return studentIds;
        }
    }
}
