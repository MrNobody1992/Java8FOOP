package functional_interface;

import functional_interface.impl.XorBinaryOperator;

import java.util.function.BinaryOperator;

/**
 * Usage of a BinaryOperator
 */
public class BinaryOperatorAtWork {

    /**
     * Logical xor with an implementation of a BinaryOperator
     *
     * @param firstBoolean  left-hand operand of the xor
     * @param secondBoolean right-hand operand of the xor
     * @return true if one of the two inputs is true, false otherwise
     */
    public boolean xorWithBinaryOperator(boolean firstBoolean, boolean secondBoolean) {
        BinaryOperator<Boolean> xor = new XorBinaryOperator();
        return xor.apply(firstBoolean, secondBoolean);
    }

    /**
     * Logical xor with a lambda (by method reference)
     *
     * @param firstBoolean  left-hand operand of the xor
     * @param secondBoolean right-hand operand of the xor
     * @return true if one of the two inputs is true, false otherwise
     */
    public boolean xorWithLambda(boolean firstBoolean, boolean secondBoolean) {
        BinaryOperator<Boolean> xor = Boolean::logicalXor;
        return xor.apply(firstBoolean, secondBoolean);
    }
}
