package functional_interface;

import functional_interface.impl.ConstantSupplier;

import java.util.function.Supplier;

/**
 * Usage of a Supplier
 */
public class SupplierAtWork {

    /**
     * Returns the constant zero with an implementation of a Supplier
     *
     * @return zero
     */
    public int constantWithSupplier() {
        Supplier<Integer> constantInt = new ConstantSupplier();
        return constantInt.get();
    }

    /**
     * Returns the constant zero with a lambda
     *
     * @return zero
     */
    public int constantWithLambda() {
        Supplier<Integer> constantInt = () -> 0;
        return constantInt.get();
    }
}
