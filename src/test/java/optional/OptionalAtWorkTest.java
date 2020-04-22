package optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OptionalAtWorkTest {

    private final static ByteArrayOutputStream NEW_OUTPUT = new ByteArrayOutputStream();
    private final static PrintStream OLD_OUTPUT = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(NEW_OUTPUT));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(OLD_OUTPUT);
    }

    @ParameterizedTest
    @NullSource
    void testDefaultString(String aString) {
        OptionalAtWork systemUnderTest = new OptionalAtWork(aString);
        String result = systemUnderTest.getStringOrDefault();

        assertThat(result).isEmpty();
    }

    @ParameterizedTest
    @MethodSource(value = "buildStrings")
    void testGetString(String aString) {
        OptionalAtWork systemUnderTest = new OptionalAtWork(aString);
        String result = systemUnderTest.getStringOrDefault();

        assertThat(result).isEqualTo(aString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2017", "2018", "2019", "2020"})
    void testPrintLeapYear(String aString) {
        OptionalAtWork systemUnderTest = new OptionalAtWork(aString);
        systemUnderTest.printLeapYear();

        String result = NEW_OUTPUT.toString().trim();

        if (aString.equals("2020"))
            assertThat(result).isEqualTo(aString);
        else
            assertThat(result).isEmpty();
    }

    private static Stream<Arguments> buildStrings() {
        return IntStream.rangeClosed(1, 100).boxed().map(x -> Arguments.of(RandomStringUtils.random(10)));
    }
}
