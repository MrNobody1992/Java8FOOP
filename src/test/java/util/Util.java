package util;

import java.util.function.Supplier;

/**
 * Testing utilities
 */
public class Util {

    /**
     * Prints the time of execution of the input method in milliseconds
     *
     * @param method name of the method
     * @param f      method to time
     * @param <T>    type returned by the method
     * @return the result of the method call
     */
    public static <T> T timeIt(String method, Supplier<T> f) {
        long start = System.currentTimeMillis();
        T result = f.get();
        long end = System.currentTimeMillis();

        System.out.println(method + " elapsed time: " + (end - start) + " ms");

        return result;
    }
}
