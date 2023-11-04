package io.github.gldiazcardenas.shapefeatures;

import io.github.gldiazcardenas.shapefeatures.rectangle.RectangleAdjacency;
import io.github.gldiazcardenas.shapefeatures.rectangle.RectangleContainment;
import io.github.gldiazcardenas.shapefeatures.rectangle.RectangleFeatures;
import io.github.gldiazcardenas.shapefeatures.rectangle.RectangleIntersection;

import java.awt.Rectangle;

public final class ShapeFeaturesApp {

    private ShapeFeaturesApp() {
        super();
    }

    public static void main(String[] arg) {
        RectangleFeatures rectangleFeatures = new RectangleFeatures();

        Rectangle rectangle1 = new Rectangle(0, 0, 10, 10);
        Rectangle rectangle2 = new Rectangle(5, 15, 20, 20);

        RectangleContainment containment = rectangleFeatures.containment(rectangle1, rectangle2);
        RectangleAdjacency adjacency = rectangleFeatures.adjacency(rectangle1, rectangle2);
        RectangleIntersection intersection = rectangleFeatures.intersection(rectangle1, rectangle2);

        System.out.println("Containment: " + containment);
        System.out.println("Adjacency: " + adjacency);
        System.out.println("Intersection: " + intersection);
    }

}
