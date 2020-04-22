package optional;

import java.time.Year;
import java.util.Optional;

/**
 * Usage of an Optional
 */
public class OptionalAtWork {

    private final String aString;

    /**
     * Constructor
     *
     * @param aString string representing a year
     */
    public OptionalAtWork(String aString) {
        this.aString = aString;
    }

    /**
     * Returns the year in the form of a string; if it's not present than an empty string will be returned
     *
     * @return the year if it's present, an empty string otherwise
     */
    public String getStringOrDefault() {
        return Optional.ofNullable(aString).orElse("");
    }

    /**
     * If the year is present, print it
     */
    public void printLeapYear() {
        Optional.ofNullable(aString)
                .map(String::trim)
                .filter(this::isLeap)
                .ifPresent(System.out::println);
    }

    /**
     * Checks if the year is a leap one
     *
     * @param string year
     * @return true if the year is leap, false otherwise
     */
    private boolean isLeap(String string) {
        return Year.of(Integer.parseInt(string)).isLeap();
    }
}
