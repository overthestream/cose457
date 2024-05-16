package model.shape.factory;

import model.shape.LineShape;

import java.awt.*;

public class LineFactory implements ShapeFactory{
    private LineFactory(){}
    private static LineFactory instance;

    public static LineFactory getInstance() {
        if(instance == null) {
            instance = new LineFactory();
        }
        return instance;
    }

    @Override
    public LineShape createShape(int x1, int y1, int x2, int y2, Color color){
        return new LineShape(x1, y1, x2, y2, color);
    }
}

