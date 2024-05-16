package controller.brush.state;

import model.CanvasModel;
import model.shape.ShapeInterface;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends BrushState {
    public SelectState(CanvasModel canvasModel){
        super(canvasModel);
    }
    int mouseStartX, mouseStartY;
    @Override
    public void handleMouseDown(MouseEvent e, Color color) {
        mouseStartX =  e.getX();
        mouseStartY = e.getY();
    }
    @Override
    public void handleMouseClick(MouseEvent e, Color color){
        int x = e.getX();
        int y = e.getY();

        ShapeInterface shape = canvasModel.getShapeAtPoint(x, y);
        if(shape == null) {
            canvasModel.clearSelection();
            return;
        }
        shape.setColor(Color.blue);
        canvasModel.selectShape(shape);

    };
    @Override
    public void handleMouseUp(MouseEvent e, Color color) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

        int dx= e.getX() - mouseStartX;
        int dy = e.getY()-mouseStartY;

        canvasModel.getShapeSelection().move(dx, dy);
        mouseStartX = e.getX();
        mouseStartY=e.getY();
    }


}
