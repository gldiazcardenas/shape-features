package io.github.gldiazcardenas.shapefeatures;

import io.github.gldiazcardenas.shapefeatures.rectangle.Rectangle;
import io.github.gldiazcardenas.shapefeatures.rectangle.RectangleFeatures;

import java.util.HashMap;
import java.util.Map;

public final class ShapeFeaturesFactory {

    private static final ShapeFeaturesFactory INSTANCE = new ShapeFeaturesFactory();

    public static ShapeFeaturesFactory getInstance() {
        return INSTANCE;
    }

    private ShapeFeaturesFactory() {
        register(Rectangle.class, new RectangleFeatures());
    }

    private final Map<Class<? extends Shape>, ShapeFeatures<? extends Shape>> shapeFeaturesMap = new HashMap<>();

    private <S extends Shape> void register(Class<S> rectangleClass, ShapeFeatures<S> rectangleFeatures) {
        shapeFeaturesMap.put(rectangleClass, rectangleFeatures);
    }

    @SuppressWarnings("unchecked")
    public <S extends Shape> ShapeFeatures<S> get(Class<S> shapeClass) {
        ShapeFeatures<? extends Shape> features = shapeFeaturesMap.get(shapeClass);
        if (features == null) {
            throw new UnsupportedOperationException("ShapeFeatures not implemented for " + shapeClass.getName());
        }

        return (ShapeFeatures<S>) features;
    }

}
