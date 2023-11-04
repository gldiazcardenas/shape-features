package io.github.gldiazcardenas.shapefeatures;

import java.awt.Shape;

public interface Containment<S extends Shape> {

    boolean isContained();

    S getContainer();

    S getContained();

}
