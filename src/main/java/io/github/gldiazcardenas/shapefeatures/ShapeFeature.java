package io.github.gldiazcardenas.shapefeatures;

public interface ShapeFeature<S extends Shape, R> {

    R evaluate(S shape1, S shape2);

}
