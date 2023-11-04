package io.github.gldiazcardenas.shapefeatures;

/**
 * Facade class that provides access to all the features that can be calculated for a pair of shapes of the same type.
 *
 * @param <S> The type of shape.
 */
public interface ShapeFeatures<S extends Shape> {

    /**
     * Evaluates containment for the given pair of shapes.  The order in which the shapes are provided is not relevant.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return The result of evaluating containment.
     */
    Containment<S> containment(S shape1, S shape2);

    /**
     * Evaluates intersection for the given pair of shapes.  The order in which the shapes are provided is not relevant.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return The result of evaluating intersection.
     */
    Intersection<S> intersection(S shape1, S shape2);

    /**
     * Evaluates adjacency for the given pair of shapes.  The order in which the shapes are provided is not relevant.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return The result of evaluating adjacency.
     */
    Adjacency<S> adjacency(S shape1, S shape2);

}
