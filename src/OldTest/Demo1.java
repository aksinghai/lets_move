package OldTest;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo1 {
    private static Map<Integer, Integer> primes = new LinkedHashMap<>();
    static int ctr = 1;
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }


    static void printPrime(int n) {
        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i))
                primes.put(i, ctr++);
        }
    }

    public static void main(String[] args)
    {
        int n = 100000;
        printPrime(n);
        System.out.println(primes);
    }
}
