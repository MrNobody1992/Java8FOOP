package functional_interface;

import functional_interface.impl.IsEvenPredicate;

import java.util.function.Predicate;

/**
 * Usage of a Predicate
 */
public class PredicateAtWork {

    /**
     * Checks if the input is even with an implementation of a Predicate
     *
     * @param integer number to check
     * @return true if the number is even, false otherwise
     */
    public boolean isEvenWithPredicate(int integer) {
        Predicate<Integer> isEven = new IsEvenPredicate();
        return isEven.test(integer);
    }

    /**
     * Checks if the input is even with a lambda
     *
     * @param integer number to check
     * @return true if the number is even, false otherwise
     */
    public boolean isEvenWithLambda(int integer) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        return isEven.test(integer);
    }
}
