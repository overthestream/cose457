package model.shape;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineShape extends AbstractShape {

    public LineShape(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
    @Override
    public String getWidth() {
        return String.valueOf(x2 - x1);
    }

    @Override
    public String getHeight() {
        return String.valueOf(y2- y1);
    }

    @Override
    public void setWidth(int width) {
        x2=  x1 +width;
    }

    @Override
    public void setHeight(int height) {
        y2 =y1+height;
    }

    @Override
    public String getX() {
        return String.valueOf(x1);
    }

    @Override
    public String getY() {
        return String.valueOf(y1);
    }

    @Override
    public void setX(int x) {
        this.x1 = x;
    }

    @Override
    public void setY(int y) {
        this.y1= y;
    }
    @Override
    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.drawLine(x1, y1, x2, y2);
    }
}
