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

public class RectangleIntersectionFeatureTest {

    private final RectangleIntersectionFeature intersectionFeature = new RectangleIntersectionFeature();

    @ParameterizedTest
    @ArgumentsSource(IntersectingRectanglesProvider.class)
    public void shouldBeIntersecting(Rectangle r1, Rectangle r2, Rectangle expected) {
        // When
        RectangleIntersection intersection = intersectionFeature.evaluate(r1, r2);

        // Then
        assertNotNull(intersection);
        assertTrue(intersection.isIntersecting());
        assertNotNull(intersection.getIntersection());
        assertEquals(expected, intersection.getIntersection());
    }

    @ParameterizedTest
    @ArgumentsSource(NonIntersectingRectanglesProvider.class)
    public void shouldBeNotIntersecting(Rectangle r1, Rectangle r2) {
        // When
        RectangleIntersection intersection = intersectionFeature.evaluate(r1, r2);

        // Then
        assertNotNull(intersection);
        assertFalse(intersection.isIntersecting());
        assertNull(intersection.getIntersection());
    }

    private static final class IntersectingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(5, 5, 10, 10),
                    new Rectangle(5, 5, 5, 5)),

                // Exactly like previous one, but switching the order of parameters, should produce same result
                Arguments.of(
                    new Rectangle(5, 5, 10, 10),
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(5, 5, 5, 5)),

                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(-5, 5, 10, 10),
                    new Rectangle(0, 5, 5, 5)),

                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(0, -5, 10, 10),
                    new Rectangle(0, 0, 10, 5)),

                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(-5, -7, 10, 10),
                    new Rectangle(0, 0, 5, 3)),

                // This one is contained, and at the same time intersecting
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(2, 2, 4, 4),
                    new Rectangle(2, 2, 4, 4))
            );
        }
    }

    private static final class NonIntersectingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new Rectangle(0, 0, 10, 10)),
                Arguments.of(new Rectangle(0, 0, 10, 10), null),
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(20, 20, 10, 10)),
                // This one is adjacent, not intersecting
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(5, 10, 10, 10))
            );
        }
    }

}
