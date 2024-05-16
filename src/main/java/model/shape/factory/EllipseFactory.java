package model.shape.factory;

import model.shape.EllipseShape;

import java.awt.*;

public class EllipseFactory implements ShapeFactory{
    private EllipseFactory(){}
    private static EllipseFactory instance;

    public static EllipseFactory getInstance() {
        if(instance == null) {
            instance = new EllipseFactory();
        }
        return instance;
    }

    @Override
    public EllipseShape createShape(int x1, int y1, int x2, int y2, Color color){
        return new EllipseShape(x1, y1, x2, y2, color);
    }
}
