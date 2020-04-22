package functional_interface.impl;

import java.util.function.Consumer;

/**
 * Implementation of a Consumer
 */
public class PrintConsumer
        implements Consumer<String> {

    /**
     * Prints the input string
     *
     * @param s string to print
     */
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
