package view;

import model.CanvasModel;
import model.shape.ShapeInterface;

import javax.swing.*;
import java.awt.*;

public class CanvasView extends JPanel implements Observer {
    private CanvasModel canvasModel;
    public CanvasView(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
        canvasModel.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for(ShapeInterface shape: this.canvasModel.getShapeList()) {
            shape.draw(graphics2D);
        }

    }

}
