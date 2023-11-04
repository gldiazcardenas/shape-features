package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Adjacency;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RectangleAdjacencyFeatureTest {

    private final RectangleAdjacencyFeature adjacencyFeature = new RectangleAdjacencyFeature();

    @ParameterizedTest
    @ArgumentsSource(AdjacentRectanglesProvider.class)
    // Given
    public void shouldBeAdjacent(Rectangle r1, Rectangle r2, Adjacency.Type expected) {
        // When
        RectangleAdjacency adjacency  = adjacencyFeature.evaluate(r1, r2);

        // Then
        assertNotNull(adjacency);
        assertNotNull(adjacency.getType());
        assertEquals(expected, adjacency.getType());
    }

    @ParameterizedTest
    @ArgumentsSource(NonAdjacentRectanglesProvider.class)
    // Given
    public void shouldBeNotAdjacent(Rectangle r1, Rectangle r2) {
        // When
        RectangleAdjacency adjacency = adjacencyFeature.evaluate(r1, r2);

        // Then
        assertNotNull(adjacency);
        assertEquals(Adjacency.Type.NONE, adjacency.getType());
    }

    private static final class AdjacentRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                // Left adjacency
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(10, 2, 4, 4),
                    Adjacency.Type.SUB_LINE),

                // Right adjacency, same as previous one but switching the order of parameters
                Arguments.of(
                    new Rectangle(10, 2, 4, 4),
                    new Rectangle(0, 0, 10, 10),
                    Adjacency.Type.SUB_LINE),

                // Top adjacency
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(0, 10, 10, 10),
                    Adjacency.Type.PROPER),

                // Bottom adjacency, same as previous one but switching the order of parameters
                Arguments.of(
                    new Rectangle(0, 10, 10, 10),
                    new Rectangle(0, 0, 10, 10),
                    Adjacency.Type.PROPER),

                // Partial adjacency (right upper corner)
                Arguments.of(
                    new Rectangle(0, 0, 10, 10),
                    new Rectangle(10, 5, 10, 10),
                    Adjacency.Type.PARTIAL),

                // Partial adjacency (left bottom corner)
                Arguments.of(
                    new Rectangle(10, 5, 10, 10),
                    new Rectangle(0, 0, 10, 10),
                    Adjacency.Type.PARTIAL)
            );
        }
    }

    private static final class NonAdjacentRectanglesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new Rectangle(0, 0, 10, 10)),
                Arguments.of(new Rectangle(0, 0, 10, 10), null),
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(20, 20, 10, 10)),
                // This one is intersecting, not adjacent
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(5, 5, 10, 10)),
                // This one is containment, not adjacent
                Arguments.of(new Rectangle(0, 0, 10, 10), new Rectangle(2, 2, 4, 4))
            );
        }
    }

}
