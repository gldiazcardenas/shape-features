package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Adjacency;
import io.github.gldiazcardenas.shapefeatures.AdjacencyFeature;

import java.awt.Rectangle;

public class RectangleAdjacencyFeature implements AdjacencyFeature<Rectangle, RectangleAdjacency> {

    @Override
    public RectangleAdjacency calculate(Rectangle shape1, Rectangle shape2) {
        return new RectangleAdjacency(Adjacency.Type.NONE);
    }

}
