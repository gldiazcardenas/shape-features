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

public class RectangleIntersectionFeaturesTest {

    private final RectangleIntersectionFeature intersection = new RectangleIntersectionFeature();

    @ParameterizedTest
    @ArgumentsSource(IntersectingRectanglesProvider.class)
    public void shouldBeIntersecting(Rectangle r1, Rectangle r2, Rectangle result) {
        // When
        RectangleIntersection intersection = this.intersection.evaluate(r1, r2);

        // Then
        assertNotNull(intersection);
        assertTrue(intersection.isIntersecting());
        assertNotNull(intersection.getIntersection());
        assertEquals(intersection.getIntersection(), result);
    }

    @ParameterizedTest
    @ArgumentsSource(NonIntersectingRectanglesProvider.class)
    public void shouldNotBeIntersecting(Rectangle r1, Rectangle r2) {
        // When
        RectangleIntersection intersection = this.intersection.evaluate(r1, r2);

        // Then
        assertNotNull(intersection);
        assertFalse(intersection.isIntersecting());
        assertNull(intersection.getIntersection());
    }

    private static final class IntersectingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(5, 5, 10, 10),
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
                    new Rectangle(0, 0, 5, 3))
            );
        }
    }

    private static final class NonIntersectingRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new Rectangle(0, 0, 10, 10)),
                Arguments.of(new Rectangle(0, 0, 10, 10), null),
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(20, 20, 10, 10)),
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(5, 10, 10, 10))
            );
        }
    }


}
