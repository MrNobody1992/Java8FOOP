package functional_interface;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierAtWorkTest {

    @Test
    public void testFunctionsAreTheSame() {
        SupplierAtWork systemUnderTest = new SupplierAtWork();

        int constantSupplier = systemUnderTest.constantWithSupplier();
        int constantLambda = systemUnderTest.constantWithLambda();

        assertThat(constantSupplier).isEqualTo(constantLambda);
    }
}
