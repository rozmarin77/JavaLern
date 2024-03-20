package algorithms;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;


public class Fibonacci {
    /*
    0] 0
    1] 1
    2] 1
    3] 2
    4] 3
    5] 5
    6] 8
    7] 13
 */

    public static void main(String[] args) {

        //Version with cache
        //
        StopWatch sw = new StopWatch();
        sw.start();
        long result = calculateWithCache(45);  //execution time is 6.284 sec
        sw.stop();

        System.out.println(sw.getTime(TimeUnit.MILLISECONDS));
        System.out.println(result);
        System.out.println("Function calls: " + i);


        //Non-recursive version, very fast and without cache
        long nonRecursiveResult = calculateNonRecursive(5);


    }

    static int i = 0;
    static long[] cache = new long[1000];

    public static long calculateWithCache(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }
        i++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        long result = calculateWithCache(n - 1) + calculateWithCache(n - 2);
        cache[n] = result;
        return result;
    }


    public static long calculateNonRecursive(int n) {
        long a = 1;
        long b = 0;

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        long result = 0;

        for (int i = 1; i < n; i++) {
            result = a + b;

            long temp = a;
            a = result;
            b = temp;
        }

        return result;
    }

}