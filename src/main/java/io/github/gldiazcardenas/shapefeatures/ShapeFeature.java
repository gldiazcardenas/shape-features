package io.github.gldiazcardenas.shapefeatures;

import java.awt.Shape;

public interface ShapeFeature<S extends Shape, R> {

    R calculate(S shape1, S shape2);

}
