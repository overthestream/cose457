package controller.brush.state;

import model.CanvasModel;
import model.command.CommandInvoker;
import model.command.LineDrawCommand;
import model.shape.LineShape;
import model.shape.factory.LineFactory;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineDrawingState extends BrushState{
    public LineDrawingState(CanvasModel canvasModel){
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
        LineDrawCommand lineDrawCommand =new LineDrawCommand(canvasModel, x1, y1, x2, y2, color);
        CommandInvoker.getInstance().executeCommand(lineDrawCommand);
    }
    @Override
    public void handleMouseClick(MouseEvent e, Color color){};
    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

    }
}
