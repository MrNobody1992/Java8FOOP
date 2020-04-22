package functional_interface.impl;

import java.util.function.UnaryOperator;

/**
 * Implementation of a UnaryOperator
 */
public class NegateUnaryOperator
        implements UnaryOperator<Boolean> {

    /**
     * Negates the input
     *
     * @param aBoolean boolean to negate
     * @return true if the input false, false otherwise
     */
    @Override
    public Boolean apply(Boolean aBoolean) {
        return !aBoolean;
    }
}
