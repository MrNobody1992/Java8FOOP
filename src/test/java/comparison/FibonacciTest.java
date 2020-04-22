package comparison;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static util.Util.timeIt;

public class FibonacciTest {

    private final Fibonacci systemUnderTest = new Fibonacci();

    @ParameterizedTest
    @MethodSource(value = "buildResults")
    void testFibonacciResults(long input, long output) {
        long loopResult = systemUnderTest.fibonacciLoop(input);
        long recursiveResult = systemUnderTest.fibonacciRecursion(input);
        long tailRecursiveResult = systemUnderTest.fibonacciTail(input);
        long streamResult = systemUnderTest.fibonacciStream(input);
        long memoResult = systemUnderTest.fibonacciMemo(input);

        assertThat(output)
                .isEqualTo(loopResult)
                .isEqualTo(recursiveResult)
                .isEqualTo(tailRecursiveResult)
                .isEqualTo(streamResult)
                .isEqualTo(memoResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {30, 35, 40, 45})
    void testUntilRecursionTakesTooLong(int n) {
        long loopResult = timeIt("Fibonacci loop", () -> systemUnderTest.fibonacciLoop(n));
        long recursiveResult = timeIt("Fibonacci recursion", () -> systemUnderTest.fibonacciRecursion(n));
        long tailRecursiveResult = timeIt("Fibonacci tail recursion", () -> systemUnderTest.fibonacciTail(n));
        long streamResult = timeIt("Fibonacci with stream", () -> systemUnderTest.fibonacciStream(n));
        long memoResult = timeIt("Fibonacci with memoization", () -> systemUnderTest.fibonacciMemo(n));

        assertThat(loopResult)
                .isEqualTo(recursiveResult)
                .isEqualTo(tailRecursiveResult)
                .isEqualTo(streamResult)
                .isEqualTo(memoResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 1000, 1500, 2000})
    void testUntilMemoizationAndTailRecursionGiveStackOverflowError(int n) {
        long loopResult = timeIt("Fibonacci loop", () -> systemUnderTest.fibonacciLoop(n));
        long tailRecursiveResult = timeIt("Fibonacci tail recursion", () -> systemUnderTest.fibonacciTail(n));
        long streamResult = timeIt("Fibonacci with stream", () -> systemUnderTest.fibonacciStream(n));
        long memoResult = timeIt("Fibonacci with memoization", () -> systemUnderTest.fibonacciMemo(n));

        assertThat(loopResult)
                .isEqualTo(tailRecursiveResult)
                .isEqualTo(streamResult)
                .isEqualTo(memoResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 1000000, 10000000, 100000000, 1000000000})
    void testSpeed(int n) {
        long loopResult = timeIt("Fibonacci loop", () -> systemUnderTest.fibonacciLoop(n));
        long streamResult = timeIt("Fibonacci with stream", () -> systemUnderTest.fibonacciStream(n));

        assertThat(loopResult).isEqualTo(streamResult);
    }

    private static Stream<Arguments> buildResults() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(10, 55),
                Arguments.of(20, 6765),
                Arguments.of(30, 832040),
                Arguments.of(40, 102334155)
        );
    }
}
