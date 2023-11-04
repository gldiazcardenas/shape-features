package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Adjacency;
import io.github.gldiazcardenas.shapefeatures.AdjacencyFeature;

public class RectangleAdjacencyFeature implements AdjacencyFeature<Rectangle, RectangleAdjacency> {

    @Override
    public RectangleAdjacency evaluate(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1 == null || rectangle2 == null) {
            return new RectangleAdjacency(Adjacency.Type.NONE);
        }

        Adjacency.Type type;

        type = topAdjacency(rectangle1, rectangle2);
        if (type != Adjacency.Type.NONE) {
            return new RectangleAdjacency(type);
        }

        type = bottomAdjacency(rectangle1, rectangle2);
        if (type != Adjacency.Type.NONE) {
            return new RectangleAdjacency(type);
        }

        type = leftAdjacency(rectangle1, rectangle2);
        if (type != Adjacency.Type.NONE) {
            return new RectangleAdjacency(type);
        }

        return new RectangleAdjacency(rightAdjacency(rectangle1, rectangle2));
    }

    private static Adjacency.Type topAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getMaxY() == r2.getY()) {
            return calculateXAdjacency(r1, r2);
        }
        return Adjacency.Type.NONE;
    }

    private static Adjacency.Type bottomAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getY() == r2.getMaxY()) {
            return calculateXAdjacency(r1, r2);
        }
        return Adjacency.Type.NONE;
    }

    private static Adjacency.Type calculateXAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getX() == r2.getX() && r1.getW() == r2.getW()) {
            return Adjacency.Type.PROPER;
        }

        if (r1.getX() > r2.getMaxX() || r1.getMaxX() < r2.getX()) {
            return Adjacency.Type.NONE;
        }

        if ((r1.getX() >= r2.getX() && r1.getMaxX() <= r2.getMaxX()) ||
            (r2.getX() >= r1.getX() && r2.getMaxX() <= r1.getMaxX())) {
            return Adjacency.Type.SUB_LINE;
        }

        return Adjacency.Type.PARTIAL;
    }

    private static Adjacency.Type leftAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getX() == r2.getMaxX()) {
            return calculateYAdjacency(r1, r2);
        }
        return Adjacency.Type.NONE;
    }

    private static Adjacency.Type rightAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getMaxX() == r2.getX()) {
            return calculateYAdjacency(r1, r2);
        }
        return Adjacency.Type.NONE;
    }

    private static Adjacency.Type calculateYAdjacency(Rectangle r1, Rectangle r2) {
        if (r1.getY() == r2.getY() && r1.getH() == r2.getH()) {
            return Adjacency.Type.PROPER;
        }

        if (r1.getY() > r2.getMaxY() || r1.getMaxY() < r2.getY()) {
            return Adjacency.Type.NONE;
        }

        if ((r1.getY() >= r2.getY() && r1.getMaxY() <= r2.getMaxY()) ||
            (r2.getY() >= r1.getY() && r2.getMaxY() <= r1.getMaxY())) {
            return Adjacency.Type.SUB_LINE;
        }

        return Adjacency.Type.PARTIAL;
    }

}
