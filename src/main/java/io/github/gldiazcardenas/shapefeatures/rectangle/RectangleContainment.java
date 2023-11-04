package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Containment;

public class RectangleContainment implements Containment<Rectangle> {

    private final Rectangle container;
    private final Rectangle contained;

    public RectangleContainment(Rectangle container, Rectangle contained) {
        this.container = container;
        this.contained = contained;
    }

    @Override
    public boolean isContainment() {
        return contained != null && container != null;
    }

    @Override
    public Rectangle getContainer() {
        return container;
    }

    @Override
    public Rectangle getContained() {
        return contained;
    }

    @Override
    public String toString() {
        return "RectangleContainment{" +
            (isContainment() ?
                ("container=" + container + ", contained=" + contained) :
                "NONE")
             + '}';
    }
}
