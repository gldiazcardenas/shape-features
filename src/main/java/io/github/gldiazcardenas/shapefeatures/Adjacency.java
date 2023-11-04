package io.github.gldiazcardenas.shapefeatures;

public interface Adjacency<S extends Shape> {

    enum Type {
        NONE,
        SUB_LINE,
        PARTIAL,
        PROPER,
    }

    Type getType();

}
