package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Intersection;

import java.awt.Rectangle;

public class RectangleIntersection implements Intersection<Rectangle> {

    private final Rectangle intersection;

    public RectangleIntersection(Rectangle intersection) {
        this.intersection = intersection;
    }

    @Override
    public boolean isIntersecting() {
        return intersection != null;
    }

    @Override
    public Rectangle getIntersecting() {
        return intersection;
    }

    @Override
    public String toString() {
        return "RectangleIntersection{" +
            "intersection=" + (intersection == null ? "NONE" : intersection) +
            '}';
    }
}
