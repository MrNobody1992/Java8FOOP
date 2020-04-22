package functional_interface.impl;

import java.util.List;
import java.util.function.Function;

/**
 * Implementation of a Function
 */
public class SumFunction
        implements Function<List<Integer>, Integer> {

    /**
     * Sums up the numbers into the input numbers
     *
     * @param integers numbers to sum
     * @return sum of the inputs
     */
    @Override
    public Integer apply(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }
}
