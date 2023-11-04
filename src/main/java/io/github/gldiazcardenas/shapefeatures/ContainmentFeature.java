package io.github.gldiazcardenas.shapefeatures;

/**
 * Specific containment feature that can be calculated for a pair of shapes of the same type.
 * @param <S> The type of shape.
 * @param <C> The containment result type.
 */
public interface ContainmentFeature<S extends Shape, C extends Containment<S>> extends ShapeFeature<S, C> {

}
