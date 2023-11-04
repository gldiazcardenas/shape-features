package io.github.gldiazcardenas.shapefeatures;

import java.awt.Shape;

public interface Adjacency<S extends Shape> {

    enum Type {
        NONE,
        PARTIAL,
        PROPER,
        SUB_ADJACENT
    }

    Type getType();

}
