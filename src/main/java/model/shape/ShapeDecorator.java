package model.shape;

import java.awt.*;

public abstract class ShapeDecorator implements ShapeInterface{
    protected ShapeInterface decoratedShape;
    protected ShapeDecorator(ShapeInterface shape) {
        this. decoratedShape = shape;
    }

    protected abstract void doDraw(Graphics2D g2);
    @Override
    public void draw(Graphics2D g2) {
        decoratedShape.draw(g2);
        doDraw(g2);
    }

    @Override
    public void move(int dx, int dy) {
        decoratedShape.move(dx, dy);
    }

    @Override
    public void setColor(Color color) {
        decoratedShape.setColor(color);
    }

    @Override
    public boolean contains(int x, int y) {
        return decoratedShape.contains(x, y);
    }

    @Override
    public String getWidth() {
        return decoratedShape.getWidth();
    }

    @Override
    public String getHeight() {
        return decoratedShape.getHeight();
    }

    @Override
    public void setWidth(int width) {
        decoratedShape.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        decoratedShape.setHeight(height);
    }

    @Override
    public String getX() {
        return decoratedShape.getX();
    }

    @Override
    public String getY() {
        return decoratedShape.getY();
    }

    @Override
    public void setX(int x) {
        decoratedShape.setX(x);
    }

    @Override
    public void setY(int y) {
        decoratedShape.setY(y);
    }
}
