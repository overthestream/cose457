package model.shape.factory;

import model.shape.RectangleShape;

import java.awt.*;

public class RectangleFactory implements ShapeFactory {
    private RectangleFactory(){}
    private static RectangleFactory instance;

    public static RectangleFactory getInstance() {
        if(instance == null) {
            instance = new RectangleFactory();
        }
        return instance;
    }

    @Override
    public RectangleShape createShape(int x1, int y1, int x2, int y2, Color color){
        return new RectangleShape(x1,y1,x2,y2, color);
    }
}

