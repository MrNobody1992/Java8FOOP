package stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IntermediateOperationTest {

    private final IntermediateOperation systemUnderTest = new IntermediateOperation();

    @ParameterizedTest
    @MethodSource(value = "buildLists")
    void testLaziness(List<Integer> integers) {
        List<Integer> integersCopy = new ArrayList<>(integers);
        Collections.copy(integersCopy, integers);

        Stream<Integer> evenSquareStream = systemUnderTest.evenSquares(integers);
        Stream<Integer> primeDivisorStream = systemUnderTest.getPrimeDistinctDivisors(evenSquareStream);

        // Integers have not been modified
        assertThat(integers).hasSameElementsAs(integersCopy);

        // The first stream has already been consumed, so an IllegalStateException should be thrown
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> evenSquareStream.forEach(System.out::println));

        // Result is not empty
        assertThat(primeDivisorStream.collect(toList())).isNotEmpty();
    }

    private static Stream<Arguments> buildLists() {
        Random random = new Random();

        return IntStream.rangeClosed(1, 100).boxed()
                .map(x -> Arguments.of(random.ints(10, 1, 100)
                        .boxed().collect(toList())));
    }
}
