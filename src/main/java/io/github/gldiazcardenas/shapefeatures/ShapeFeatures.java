package io.github.gldiazcardenas.shapefeatures;

import java.awt.Shape;

public interface ShapeFeatures<S extends Shape> {

    Containment<S> containment(S shape1, S shape2);

    Intersection<S> intersection(S shape1, S shape2);

    Adjacency<S> adjacency(S shape1, S shape2);

}
