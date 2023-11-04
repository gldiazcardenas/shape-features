package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.ContainmentFeature;

public class RectangleContainmentFeature implements ContainmentFeature<Rectangle, RectangleContainment> {

    @Override
    public RectangleContainment evaluate(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1 == null || rectangle2 == null) {
            return new RectangleContainment(null, null);
        }

        if (contains(rectangle1, rectangle2)) {
            return new RectangleContainment(rectangle1, rectangle2);
        }

        if (contains(rectangle2, rectangle1)) {
            return new RectangleContainment(rectangle2, rectangle1);
        }

        return new RectangleContainment(null, null);
    }

    private static boolean contains(Rectangle rectangle1, Rectangle rectangle2) {
        java.awt.Rectangle r1 = new java.awt.Rectangle(rectangle1.getX(), rectangle1.getY(), rectangle1.getW(), rectangle1.getH());
        java.awt.Rectangle r2 = new java.awt.Rectangle(rectangle2.getX(), rectangle2.getY(), rectangle2.getW(), rectangle2.getH());
        return r1.contains(r2);
    }
}
