package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.ContainmentFeature;

import java.awt.Rectangle;

public class RectangleContainmentFeature implements ContainmentFeature<Rectangle, RectangleContainment> {

    @Override
    public RectangleContainment calculate(Rectangle rectangle1, Rectangle rectangle2) {
        return new RectangleContainment(null, null);
    }
}
