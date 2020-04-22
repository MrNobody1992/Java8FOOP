package functional_interface;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionAtWorkTest {

    @ParameterizedTest()
    @MethodSource(value = "buildLists")
    void testFunctionsAreTheSame(List<Integer> integers) {
        FunctionAtWork systemUnderTest = new FunctionAtWork();

        int sumFunction = systemUnderTest.sumWithFunction(integers);
        int sumLambda = systemUnderTest.sumWithLambda(integers);

        assertThat(sumFunction).isEqualTo(sumLambda);
    }

    private static Stream<Arguments> buildLists() {
        Random random = new Random();

        return IntStream.rangeClosed(1, 100).boxed()
                .map(x -> Arguments.of(random.ints(10, 1, 100)
                        .boxed().collect(toList())));
    }
}
