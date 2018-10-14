package microsoft;

import java.util.HashMap;
import java.util.Map;

public class Reverse_Fibonacci {
    /**
     * Given a number n then print n terms of fibonacci series in reverse order.
     *
     * Examples:
     *
     * Input : n = 5
     * Output : 3 2 1 1 0
     *
     * Input : n = 8
     * Output : 13 8 5 3 2 1 1 0
     */

    public static int[] reverseFib(int n) {
        int[] res = new int[n];
        for (int i = n; i >= 1; i--) {
            res[n - i] = fib(i);
        }
        return res;
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static int fib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (map.get(n) != null) return map.get(n);
        int res = fib(n-1) + fib(n-2);
        map.put(n, res);

        return res;
    }

    public static void main(String[] args) {
        int[] res = reverseFib(5);
        for (int num : res) {
            System.out.print(num);
        }
//        System.out.println(fib(1));
    }
}
