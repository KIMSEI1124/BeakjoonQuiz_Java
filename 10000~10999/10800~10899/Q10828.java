import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({ "rawtypes", "unchecked" })

public class Q10828 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        while (N > 0) {
            String str = sc.next();
            if(str.equals("push")){
                push(list);
            } else if(str.equals("pop")){
                pop(list);
            } else if(str.equals("size")){
                size(list);
            } else if(str.equals("empty")){
                empty(list);
            } else {
                top(list);
            }
            N--;
        }
        System.out.println(sb);
    }

    public static void push(ArrayList list) {
        int num = sc.nextInt();
        list.add(num);
    }

    public static void pop(ArrayList list) {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.get(list.size() - 1) + "\n");
            list.remove(list.size() - 1);
        }
    }

    public static void size(ArrayList list) {
        sb.append(list.size() + "\n");
    }

    public static void empty(ArrayList list) {
        if (list.isEmpty()) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    public static void top(ArrayList list) {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.get(list.size() - 1) + "\n");
        }
    }
}