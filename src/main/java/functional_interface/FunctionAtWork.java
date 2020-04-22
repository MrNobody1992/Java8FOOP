package functional_interface;

import functional_interface.impl.SumFunction;

import java.util.List;
import java.util.function.Function;

/**
 * Usage of a Function
 */
public class FunctionAtWork {

    /**
     * Sums up the numbers into the input numbers with an implementation of a Function
     *
     * @param integers numbers to sum
     * @return sum of the inputs
     */
    public int sumWithFunction(List<Integer> integers) {
        Function<List<Integer>, Integer> sum = new SumFunction();
        return sum.apply(integers);
    }

    /**
     * Sums up the numbers into the input numbers with a lambda
     *
     * @param integers numbers to sum
     * @return sum of the inputs
     */
    public int sumWithLambda(List<Integer> integers) {
        Function<List<Integer>, Integer> sum =
                ints -> ints.stream().mapToInt(Integer::intValue).sum();

        return sum.apply(integers);
    }
}
