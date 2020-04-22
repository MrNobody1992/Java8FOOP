package stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TerminalOperationTest {

    private final TerminalOperation systemUnderTest = new TerminalOperation();

    @ParameterizedTest
    @MethodSource(value = "buildLists")
    void testSumSquares(List<Integer> integers) {
        int result = systemUnderTest.sumSquares(integers);

        int expected = 0;

        for (Integer integer : integers)
            expected += Math.pow(integer, 2);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource(value = "buildLists")
    void testHammingWeights(List<Integer> integers) {
        List<Integer> result = systemUnderTest.hammingWeights(integers);

        List<Integer> expected = new ArrayList<>();

        for (Integer integer : integers)
            expected.add(Integer.bitCount(integer));

        assertThat(result).hasSameElementsAs(expected);
    }

    private static Stream<Arguments> buildLists() {
        Random random = new Random();

        return IntStream.rangeClosed(1, 100).boxed()
                .map(x -> Arguments.of(random.ints(10, 1, 100)
                        .boxed().collect(toList())));
    }
}
