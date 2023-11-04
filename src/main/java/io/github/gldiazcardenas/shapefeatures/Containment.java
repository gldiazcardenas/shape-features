package io.github.gldiazcardenas.shapefeatures;

public interface Containment<S extends Shape> {

    boolean isContainment();

    S getContainer();

    S getContained();

}
