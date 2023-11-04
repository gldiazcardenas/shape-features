package io.github.gldiazcardenas.shapefeatures.rectangle;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleContainmentFeatureTests {

    private final RectangleContainmentFeature containmentFeature = new RectangleContainmentFeature();

    @ParameterizedTest
    @ArgumentsSource(ContainingRectanglesProvider.class)
    // Given
    public void shouldBeContainment(Rectangle r1, Rectangle r2, boolean r1Container) {
        // When
        RectangleContainment containment  = containmentFeature.evaluate(r1, r2);

        // Then
        assertNotNull(containment);
        assertTrue(containment.isContainment());
        assertNotNull(containment.getContainer());
        assertNotNull(containment.getContained());

        if (r1Container) {
            assertEquals(containment.getContainer(), r1);
            assertEquals(containment.getContained(), r2);
        } else {
            assertEquals(containment.getContainer(), r2);
            assertEquals(containment.getContained(), r1);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(NonContainingRectanglesProvider.class)
    // Given
    public void shouldBeNotContainment(Rectangle r1, Rectangle r2) {
        // When
        RectangleContainment containment = containmentFeature.evaluate(r1, r2);

        // Then
        assertNotNull(containment);
        assertFalse(containment.isContainment());
        assertNull(containment.getContainer());
        assertNull(containment.getContained());
    }

    private static final class ContainingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(2, 2, 4, 4),
                    true),

                // Exactly the previous one, but switched params
                Arguments.of(
                    new Rectangle(2, 2, 4, 4),
                    new Rectangle(0, 0, 10, 10),
                    false),

                // The same rectangle is contained by itself
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(0, 0, 10, 10),
                    true)
            );
        }
    }

    private static final class NonContainingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new Rectangle(0, 0, 10, 10)),
                Arguments.of(new Rectangle(0, 0, 10, 10), null),
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(20, 20, 10, 10)),
                // This one is adjacent, not containing
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(5, 10, 10, 10)),
                // This one is intersecting, not containing
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(5, 5, 10, 10))
            );
        }
    }

}
