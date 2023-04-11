import java.io.*;
import java.util.*;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toUpperCase().toCharArray();
        ArrayList<Alphabet<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char check = arr[i];
            int pos = AlphabetContains(list, check);
            if (list.size() == 0 || pos == -1) {
                list.add(new Alphabet<Character, Integer>());
                list.get(list.size() - 1).setAlphabet(check, 1);
            } else if (pos != -1) {
                list.get(pos).setCount(list.get(pos).getCount() + 1);
            }
        }
        Comparator<Alphabet<Character, Integer>> comparator = new Comparator<Alphabet<Character, Integer>>() {
            @Override
            public int compare(Alphabet<Character, Integer> a, Alphabet<Character, Integer> b) {
                return b.getCount() - a.getCount();
            }
        };
        Collections.sort(list, comparator);
        if (list.size() > 1) {
            if (!list.get(0).getCount().equals(list.get(1).getCount())) {
                System.out.println(list.get(0).getAlphabet());
            } else {
                System.out.println("?");
            }
        } else if (list.size() == 1) {
            System.out.println(list.get(0).getAlphabet());
        }
    }

    public static int AlphabetContains(ArrayList<Alphabet<Character, Integer>> list, char check) {
        for (int i = 0; i < list.size(); i++) {
            if (check == list.get(i).getAlphabet()) {
                return i;
            }
        }
        return -1;
    }
}

class Alphabet<A, C> {
    private A Alphabet;
    private C count;

    public void setAlphabet(A Alphabet, C count) {
        this.Alphabet = Alphabet;
        this.count = count;
    }

    public void setCount(C count) {
        this.count = count;
    }

    public A getAlphabet() {
        return this.Alphabet;
    }

    public C getCount() {
        return this.count;
    }

    public void print() {
        System.out.println("Alphabet : " + Alphabet + ", Count : " + count);
    }
}