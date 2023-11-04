package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Adjacency;

import java.awt.Rectangle;

public class RectangleAdjacency implements Adjacency<Rectangle> {

    private final Type type;

    public RectangleAdjacency(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RectangleAdjacency{" +
            "type=" + type +
            '}';
    }

}
