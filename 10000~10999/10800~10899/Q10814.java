import java.io.*;
import java.util.*;

public class Q10814 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<User<String, Integer>> users = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User<>(name, age));
        }
        Collections.sort(users, (a, b) -> a.getAge() - b.getAge());
        for (User<String, Integer> user : users) {
            answer.append(user.age).append(" ").append(user.name).append("\n");
        }
        System.out.println(answer);
    }

    private static class User<N, A> {
        private N name;
        private A age;

        public User(N name, A age) {
            this.name = name;
            this.age = age;
        }

        public N getName() {
            return name;
        }

        public A getAge() {
            return age;
        }
    }
}