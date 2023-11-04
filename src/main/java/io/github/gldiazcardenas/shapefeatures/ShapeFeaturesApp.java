package io.github.gldiazcardenas.shapefeatures;

import io.github.gldiazcardenas.shapefeatures.rectangle.Rectangle;

public final class ShapeFeaturesApp {

    private ShapeFeaturesApp() {
        super();
    }

    public static void main(String[] arg) {
        ShapeFeatures<Rectangle> rectangleFeatures = ShapeFeaturesFactory.getInstance().get(Rectangle.class);

        Rectangle rectangle1;
        Rectangle rectangle2;

        rectangle1 = new Rectangle(0, 0, 10, 10);
        rectangle2 = new Rectangle(5, 5, 20, 20);
        Intersection<Rectangle> intersection = rectangleFeatures.intersection(rectangle1, rectangle2);

        rectangle1 = new Rectangle(0, 0, 10, 10);
        rectangle2 = new Rectangle(2, 2, 4, 4);
        Containment<Rectangle> containment = rectangleFeatures.containment(rectangle1, rectangle2);

        rectangle1 = new Rectangle(0, 0, 10, 10);
        rectangle2 = new Rectangle(0, 10, 4, 4);
        Adjacency<Rectangle> adjacency = rectangleFeatures.adjacency(rectangle1, rectangle2);

        System.out.println("Intersection: " + intersection);
        System.out.println("Containment: " + containment);
        System.out.println("Adjacency: " + adjacency);
    }

}
