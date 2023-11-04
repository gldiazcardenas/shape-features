package io.github.gldiazcardenas.shapefeatures;

/**
 * Specific adjacency feature that can be calculated for a pair of shapes of the same type.
 * @param <S> The type of shape.
 * @param <A> The adjacency result type.
 */
public interface AdjacencyFeature<S extends Shape, A extends Adjacency<S>> extends ShapeFeature<S, A> {

}
