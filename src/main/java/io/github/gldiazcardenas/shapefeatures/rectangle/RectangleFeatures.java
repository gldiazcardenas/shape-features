package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.ShapeFeatures;

/**
 * Implementation that delegates the responsibility of evaluating the features to the corresponding implementation.
 * This acts as a facade for the rectangle features.
 */
public class RectangleFeatures implements ShapeFeatures<Rectangle> {

    private final RectangleAdjacencyFeature adjacencyFeature = new RectangleAdjacencyFeature();
    private final RectangleContainmentFeature containmentFeature = new RectangleContainmentFeature();
    private final RectangleIntersectionFeature intersectionFeature = new RectangleIntersectionFeature();

    @Override
    public RectangleContainment containment(Rectangle rectangle1, Rectangle rectangle2) {
        return containmentFeature.evaluate(rectangle1, rectangle2);
    }

    @Override
    public RectangleIntersection intersection(Rectangle rectangle1, Rectangle rectangle2) {
        return intersectionFeature.evaluate(rectangle1, rectangle2);
    }

    @Override
    public RectangleAdjacency adjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return adjacencyFeature.evaluate(rectangle1, rectangle2);
    }

}
