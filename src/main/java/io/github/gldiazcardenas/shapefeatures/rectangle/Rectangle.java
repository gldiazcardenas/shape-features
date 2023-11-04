package io.github.gldiazcardenas.shapefeatures.rectangle;

import io.github.gldiazcardenas.shapefeatures.Shape;

import java.util.Objects;

public class Rectangle implements Shape {

    private final int x;
    private final int y;
    private final int w;
    private final int h;

    public Rectangle(int x, int y, int w, int h) {
        if (w < 0 || h < 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getMaxX() {
        return x + w;
    }

    public int getMaxY() {
        return y + h;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return x == rectangle.x && y == rectangle.y && w == rectangle.w && h == rectangle.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, w, h);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "x=" + x +
            ", y=" + y +
            ", w=" + w +
            ", h=" + h +
            '}';
    }

}
