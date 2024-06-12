package model.shape;

import java.awt.*;

public class ShadowShapeDecorator extends ShapeDecorator {

    public ShadowShapeDecorator(ShapeInterface shape) {
        super(shape);
    }

    @Override
    protected void doDraw(Graphics2D g2){
        Color originalColor = g2.getColor();
        g2.setColor(Color.GRAY);
        g2.translate(1, 1);
        this.decoratedShape.draw(g2);
        g2.translate(-1, -1);
        g2.setColor(originalColor);
    }

}
