import java.util.*;

public class SimpleArraySum {
    public static long simpleArraySum(List<Integer> ar) {
        // Write your code here
        return ar.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getSum();
    }
}