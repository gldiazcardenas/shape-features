package io.github.gldiazcardenas.shapefeatures;

/**
 * Specific intersection feature that can be calculated for a pair of shapes of the same type.
 * @param <S> The type of shape.
 * @param <I> The intersection result type.
 */
public interface IntersectionFeature<S extends Shape, I extends Intersection<S>> extends ShapeFeature<S, I> {

}
