package functional_interface;

import functional_interface.impl.NegateUnaryOperator;

import java.util.function.UnaryOperator;

/**
 * Usage of a UnaryOperator
 */
public class UnaryOperatorAtWork {

    /**
     * Negates the input with an implementation of a UnaryOperator
     *
     * @param aBoolean boolean to negate
     * @return true if the input false, false otherwise
     */
    public boolean negateWithUnaryOperator(boolean aBoolean) {
        UnaryOperator<Boolean> negate = new NegateUnaryOperator();
        return negate.apply(aBoolean);
    }

    /**
     * Negates the input with a lambda
     *
     * @param aBoolean boolean to negate
     * @return true if the input false, false otherwise
     */
    public boolean negateWithLambda(boolean aBoolean) {
        UnaryOperator<Boolean> negate = b -> !b;
        return negate.apply(aBoolean);
    }
}
