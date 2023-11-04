package io.github.gldiazcardenas.shapefeatures;

public interface Intersection<S extends Shape> {

    boolean isIntersecting();

    S getIntersection();

}
