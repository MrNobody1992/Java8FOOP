package stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Usage of terminal operations of the Stream API
 */
public class TerminalOperation {

    /**
     * Sum the squares of the input numbers
     *
     * @param integers numbers to sum
     * @return the sum of the input numbers
     */
    public int sumSquares(List<Integer> integers) {
        return integers.stream()
                .map(x -> (int) Math.pow(x, 2))
                .reduce(Integer::sum)
                .orElse(0);
    }

    /**
     * Maps to every integer the number of 1 bits in its two's complement binary representation
     *
     * @param integers numbers to map
     * @return the population counting of the bit representation of the input numbers
     */
    public List<Integer> hammingWeights(List<Integer> integers) {
        return integers.stream()
                .map(Integer::bitCount)
                .collect(Collectors.toList());
    }
}
