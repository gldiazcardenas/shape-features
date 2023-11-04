package io.github.gldiazcardenas.shapefeatures;

import java.awt.Shape;

public interface Intersection<S extends Shape> {

    boolean isIntersecting();

    S getIntersecting();

}
