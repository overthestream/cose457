package model.shape;

import java.awt.*;

public abstract class AbstractShape implements ShapeInterface {
    protected int x1, y1, x2, y2;
    protected Color color;
    protected AbstractShape(int x1, int y1, int x2, int y2, Color color){
        this.color=color;
        this.x1= x1;
        this.x2= x2;
        this.y1 = y1;
        this.y2= y2;
    }

    @Override
    public boolean contains(int x, int y) {
        int xStart = Math.min(x1, x2);
        int yStart = Math.min(y1, y2);
        int xEnd = Math.max(x1, x2);
        int yEnd = Math.max(y1, y2);
        return xStart< x && x < xEnd && yStart < y && y< yEnd;
    }

    @Override
    public void move(int dx, int dy) {
        x1+=dx;
        x2+=dx;
        y1+=dy;
        y2+=dy;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }


}
