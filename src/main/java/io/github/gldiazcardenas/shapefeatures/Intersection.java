package io.github.gldiazcardenas.shapefeatures;

/**
 * The result of evaluating intersection between two shapes.
 * @param <S> The type of intersection which should be another shape.
 */
public interface Intersection<S extends Shape> {

    /**
     * @return Whether the shapes intersect or not.
     */
    boolean isIntersecting();

    /**
     * @return The intersection between the shapes. If the shapes do not intersect, the result is {@code null}.
     */
    S getIntersection();

}
