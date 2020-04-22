package functional_interface;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UnaryOperatorAtWorkTest {

    @ParameterizedTest()
    @ValueSource(booleans = {true, false})
    void testFunctionsAreTheSame(boolean aBoolean) {
        UnaryOperatorAtWork systemUnderTest = new UnaryOperatorAtWork();

        boolean negateUnaryOperator = systemUnderTest.negateWithUnaryOperator(aBoolean);
        boolean negateLambda = systemUnderTest.negateWithLambda(aBoolean);

        assertThat(negateUnaryOperator).isEqualTo(negateLambda);
    }
}
