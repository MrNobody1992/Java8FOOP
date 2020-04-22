package functional_interface;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperatorAtWorkTest {

    @ParameterizedTest()
    @MethodSource(value = "buildBooleanPairs")
    void testFunctionsAreTheSame(boolean firstBoolean, boolean secondBoolean) {
        BinaryOperatorAtWork systemUnderTest = new BinaryOperatorAtWork();

        boolean xorBinaryOperator = systemUnderTest.xorWithBinaryOperator(firstBoolean, secondBoolean);
        boolean xorLambda = systemUnderTest.xorWithLambda(firstBoolean, secondBoolean);

        assertThat(xorBinaryOperator).isEqualTo(xorLambda);
    }

    private static Stream<Arguments> buildBooleanPairs() {
        return Stream.of(
                Arguments.of(true, true),
                Arguments.of(true, false),
                Arguments.of(false, true),
                Arguments.of(false, false));
    }
}
