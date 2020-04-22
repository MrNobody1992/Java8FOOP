package functional_interface;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateAtWorkTest {

    @ParameterizedTest()
    @MethodSource(value = "buildNumbers")
    void testFunctionsAreTheSame(Integer number) {
        PredicateAtWork systemUnderTest = new PredicateAtWork();

        boolean isEvenPredicate = systemUnderTest.isEvenWithPredicate(number);
        boolean isEvenLambda = systemUnderTest.isEvenWithLambda(number);

        assertThat(isEvenPredicate).isEqualTo(isEvenLambda);
    }

    private static Stream<Arguments> buildNumbers() {
        return new Random().ints(100).boxed().map(Arguments::of);
    }
}
