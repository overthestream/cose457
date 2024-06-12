package controller.brush.state;

import model.CanvasModel;
import model.command.CommandInvoker;
import model.command.RectangleDrawCommand;
import model.shape.RectangleShape;
import model.shape.factory.RectangleFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleDrawingState extends  BrushState{
    public RectangleDrawingState(CanvasModel canvasModel){
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

        RectangleDrawCommand rectangleDrawCommand = new RectangleDrawCommand(canvasModel, x1, y1, x2, y2 ,color);
        CommandInvoker.getInstance().executeCommand(rectangleDrawCommand);
    }
    @Override
    public void handleMouseClick(MouseEvent e, Color color){};

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

    }
}
