package model.shape;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics2D g2);
    void move(int dx, int dy);
    void setColor(Color color);

    boolean contains(int x, int y);

    String getWidth();
    String getHeight();

    void setWidth(int width);
    void setHeight(int height);

    String getX();
    String getY();

    void setX(int x);
    void setY(int y);

}
