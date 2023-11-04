package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.IntersectionFeature;

/**
 * Rectangle specific implementation of intersection feature.
 */
public class RectangleIntersectionFeature implements IntersectionFeature<Rectangle, RectangleIntersection> {

    @Override
    public RectangleIntersection evaluate(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1 == null || rectangle2 == null) {
            return new RectangleIntersection(null);
        }

        java.awt.Rectangle r1 = new java.awt.Rectangle(rectangle1.getX(), rectangle1.getY(), rectangle1.getW(), rectangle1.getH());
        java.awt.Rectangle r2 = new java.awt.Rectangle(rectangle2.getX(), rectangle2.getY(), rectangle2.getW(), rectangle2.getH());
        java.awt.Rectangle r3 = r1.intersection(r2);

        return new RectangleIntersection(r3.isEmpty() ? null : new Rectangle(r3.x, r3.y, r3.width, r3.height));
    }

}
