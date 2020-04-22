package functional_interface.impl;

import java.util.function.Predicate;

/**
 * Implementation of a Predicate
 */
public class IsEvenPredicate
        implements Predicate<Integer> {

    /**
     * Checks if the input is even
     *
     * @param integer number to check
     * @return true if the number is even, false otherwise
     */
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}
