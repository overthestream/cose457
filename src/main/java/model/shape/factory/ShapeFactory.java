package model.shape.factory;

import model.shape.ShapeInterface;

import java.awt.*;

public interface ShapeFactory {
    ShapeInterface createShape(int x1, int y1, int x2, int y2, Color color);
}
