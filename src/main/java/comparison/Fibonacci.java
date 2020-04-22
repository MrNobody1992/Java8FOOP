package comparison;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Different approaches to calculate Fibonacci sequence
 */
public class Fibonacci {

    /**
     * Map for memoization
     */
    private static final HashMap<Long, Long> memoizationMap = new HashMap<>();

    static {
        memoizationMap.put(0L, 0L);
        memoizationMap.put(1L, 1L);
    }

    /**
     * Calculates the nth Fibonacci number using a for loop
     *
     * @param number number of the Fibonacci sequence element to return
     * @return nth Fibonacci number
     */
    public long fibonacciLoop(long number) {
        long result = number;

        if (number > 1) {
            long curr = 1;
            long prev = 1;

            for (int i = 2; i < number; i++) {
                long temp = curr;
                curr += prev;
                prev = temp;
            }

            result = curr;
        }

        return result;
    }

    /**
     * Calculates the nth Fibonacci number using streams
     *
     * @param n number of the Fibonacci sequence element to return
     * @return nth Fibonacci number
     */
    public long fibonacciStream(long n) {
        long result = n;

        if (n > 1) {
            Pair<Long, Long> base = Pair.of(0L, 1L);
            UnaryOperator<Pair<Long, Long>> step =
                    pair -> Pair.of(pair.getRight(), pair.getLeft() + pair.getRight());

            result = Stream
                    .iterate(base, step)
                    .limit(n)
                    .map(Pair::getRight)
                    .skip(n - 1)
                    .findFirst()
                    .orElse(0L);
        }

        return result;
    }

    /**
     * Calculates the nth Fibonacci number using recursion
     *
     * @param n number of the Fibonacci sequence element to return
     * @return nth Fibonacci number
     */
    public long fibonacciRecursion(long n) {
        return n <= 1 ? n : fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    /**
     * Calculates the nth Fibonacci number using recursion and memoization
     *
     * @param number number of the Fibonacci sequence element to return
     * @return nth Fibonacci number
     */
    public long fibonacciMemo(long number) {
        return memoizationMap.computeIfAbsent(
                number,
                n -> n <= 1 ? n : fibonacciMemo(n - 1) + fibonacciMemo(n - 2)
        );
    }

    /**
     * Calculates the nth Fibonacci number using tail recursion
     *
     * @param n number of the Fibonacci sequence element to return
     * @return nth Fibonacci number
     */
    public long fibonacciTail(long n) {
        return fibonacciTailRecHelper(n, 0, 1);
    }

    /**
     * Method used to make a tail recursive call
     *
     * @param n      number of the Fibonacci sequence element to return
     * @param first  first of the last two calculated elements
     * @param second second of the last two calculated elements
     * @return nth Fibonacci number
     */
    private long fibonacciTailRecHelper(long n, long first, long second) {
        if (n == 0)
            return first;
        else
            return fibonacciTailRecHelper(n - 1, second, first + second);
    }
}
