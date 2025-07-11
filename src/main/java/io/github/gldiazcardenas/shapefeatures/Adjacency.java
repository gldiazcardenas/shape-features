package io.github.gldiazcardenas.shapefeatures;

/**
 * Represents the adjacency between two shapes.
 *
 * @param <S> The type of shape.
 */
public interface Adjacency<S extends Shape> {

    /**
     * Type of adjacency.
     */
    enum Type {
        /**
         * Shapes are not adjacent.
         */
        NONE,

        /**
         * Shapes are adjacent, one side is contained by the other.
         */
        SUB_LINE,

        /**
         * Shapes are adjacent, sides overlap but do not contain each other.
         */
        PARTIAL,

        /**
         * Shapes are adjacent, fully match one side.
         */
        PROPER,
    }

    /**
     * @return Whether the shapes are adjacent or not.
     */
    Type getType();

    // hola

}
