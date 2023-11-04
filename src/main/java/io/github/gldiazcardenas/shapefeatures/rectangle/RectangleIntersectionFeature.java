package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.IntersectionFeature;

import java.awt.Rectangle;

public class RectangleIntersectionFeature implements IntersectionFeature<Rectangle, RectangleIntersection> {

    @Override
    public RectangleIntersection calculate(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1 == null || rectangle2 == null || !rectangle1.intersects(rectangle2)) {
            return new RectangleIntersection(null);
        }
        return new RectangleIntersection(rectangle1.intersection(rectangle2));
    }

}
