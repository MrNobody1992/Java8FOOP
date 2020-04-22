package functional_interface;

import functional_interface.impl.PrintConsumer;

import java.util.function.Consumer;

/**
 * Usage of a Consumer
 */
public class ConsumerAtWork {

    /**
     * Prints the input string with an implementation of a Consumer
     *
     * @param s string to print
     */
    public void printWithConsumer(String s) {
        Consumer<String> print = new PrintConsumer();
        print.accept(s);
    }

    /**
     * Prints the input string with a lambda
     *
     * @param s string to print
     */
    public void printWithLambda(String s) {
        Consumer<String> print = System.out::println;
        print.accept(s);
    }
}
