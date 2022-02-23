import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Q2108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println("---------");
        System.out.println(avg(arr));
        System.out.println(median(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));
    }

    public static String avg(int[] arr) {
        double avg = 0.0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        avg /= arr.length;
        String avgStr = String.format("%.0f", avg);
        if (avgStr.equals("-0"))
            avgStr = "0";
        return avgStr;
    }

    public static int median(int[] arr) {
        int median = arr[arr.length / 2];
        return median;
    }

    public static int mode(int[] arr) { // 최빈값 구하기
        int mode = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.replace(arr[i], map.get(arr[1])+1);
            }
        }


        
        return mode;
    }

    public static int range(int[] arr) {
        int range = arr[arr.length - 1] - arr[0];
        return range;
    }
}