package functional_interface.impl;

import java.util.function.BinaryOperator;

/**
 * Implementation of a BinaryOperator
 */
public class XorBinaryOperator
        implements BinaryOperator<Boolean> {

    /**
     * Applies the logical xor
     *
     * @param firstBoolean  left-hand operand of the xor
     * @param secondBoolean right-hand operand of the xor
     * @return true if one of the two inputs is true, false otherwise
     */
    @Override
    public Boolean apply(Boolean firstBoolean, Boolean secondBoolean) {
        return Boolean.logicalXor(firstBoolean, secondBoolean);
    }
}
