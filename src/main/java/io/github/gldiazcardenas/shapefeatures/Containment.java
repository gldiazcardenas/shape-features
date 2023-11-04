package io.github.gldiazcardenas.shapefeatures;

/**
 * Represents a containment relationship between two shapes.
 * @param <S> The type of shape.
 */
public interface Containment<S extends Shape> {

    /**
     * @return Whether a containment relationship exists between the shapes or not.
     */
    boolean isContainment();

    /**
     * @return The container shape.
     */
    S getContainer();

    /**
     * @return The contained shape.
     */
    S getContained();

}
