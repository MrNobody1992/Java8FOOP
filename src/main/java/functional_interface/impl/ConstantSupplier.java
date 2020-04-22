package functional_interface.impl;

import java.util.function.Supplier;

/**
 * Implementation of a Supplier
 */
public class ConstantSupplier
        implements Supplier<Integer> {

    /**
     * Returns the constant zero
     *
     * @return zero
     */
    @Override
    public Integer get() {
        return 0;
    }
}
