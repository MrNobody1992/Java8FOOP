package stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Usage of intermediate operations of the Stream API
 */
public class IntermediateOperation {

    /**
     * Square all the numbers and filter even ones
     *
     * @param integers numbers
     * @return the even squares of the input
     */
    public Stream<Integer> evenSquares(List<Integer> integers) {
        return integers.stream()
                .map(x -> (int) Math.pow(x, 2))
                .filter(x -> x % 2 == 0);
    }

    /**
     * Get all the prime divisors of each input number, ignoring the duplicates
     *
     * @param integerStream input
     * @return the prime divisors of the input numbers
     */
    public Stream<Integer> getPrimeDistinctDivisors(Stream<Integer> integerStream) {
        return integerStream
                .flatMap(this::getDivisors)
                .distinct()
                .filter(this::isPrime);
    }

    /**
     * Get all the divisors of the input number
     *
     * @param number number from which to obtain the divisors
     * @return the divisors of the input
     */
    private Stream<Integer> getDivisors(int number) {
        return IntStream
                .rangeClosed(1, number)
                .filter(x -> number % x == 0)
                .boxed();
    }

    /**
     * Check if the input is a prime number
     *
     * @param number number to check
     * @return true if the input is prime, false otherwise
     */
    private boolean isPrime(int number) {
        boolean hasDivisors = IntStream.range(2, number).noneMatch(i -> number % i == 0);
        return number > 1 && hasDivisors;
    }
}
