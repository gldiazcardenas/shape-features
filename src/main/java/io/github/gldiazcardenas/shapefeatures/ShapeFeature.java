package io.github.gldiazcardenas.shapefeatures;

/**
 * Some feature that can be calculated for a pair of shapes of the same type.
 *
 * @param <S> The type of shape.
 * @param <R> The type of result after evaluating the feature.
 */
public interface ShapeFeature<S extends Shape, R> {

    /**
     * Evaluates the feature for the given pair of shapes, applying conditions based on the
     * characteristics of the shapes and the feature.
     *
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return The result of evaluating the feature.
     */
    R evaluate(S shape1, S shape2);

}
