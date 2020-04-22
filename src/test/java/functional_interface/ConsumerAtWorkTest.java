package functional_interface;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerAtWorkTest {

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

    @ParameterizedTest()
    @MethodSource(value = "buildStrings")
    void testFunctionsAreTheSame(String string) {
        ConsumerAtWork systemUnderTest = new ConsumerAtWork();

        systemUnderTest.printWithConsumer(string);
        systemUnderTest.printWithLambda(string);

        String[] results = NEW_OUTPUT.toString().split("\n");
        String printConsumer = results[0];
        String printLambda = results[1];

        assertThat(printConsumer).isEqualTo(printLambda);
    }

    private static Stream<Arguments> buildStrings() {
        return IntStream.rangeClosed(1, 100).boxed().map(x -> Arguments.of(RandomStringUtils.random(10)));
    }
}
