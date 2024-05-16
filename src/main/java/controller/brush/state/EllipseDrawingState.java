package controller.brush.state;

import model.CanvasModel;
import model.shape.EllipseShape;
import model.shape.factory.EllipseFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class EllipseDrawingState extends BrushState{

    public EllipseDrawingState(CanvasModel canvasModel){
        super(canvasModel);
    }
    private int x1;
    private int y1;

    @Override
    public void handleMouseDown(MouseEvent e, Color color) {
        x1=e.getX();
        y1=e.getY();
    }

    @Override
    public void handleMouseUp(MouseEvent e, Color color) {
        int x2 = e.getX();
        int y2 = e.getY();

        EllipseShape ellipseShape = EllipseFactory
                .getInstance()
                .createShape(x1, y1, x2, y2,color);
        canvasModel.addShape(ellipseShape);
    }
    @Override
    public void handleMouseClick(MouseEvent e, Color color){};

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

    }
}
