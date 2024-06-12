package controller.brush.state;

import model.CanvasModel;
import model.command.CommandInvoker;
import model.command.MoveCommand;
import model.command.SelectCommand;
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

        SelectCommand selectCommand = new SelectCommand(canvasModel, x, y);
        CommandInvoker.getInstance().executeCommand(selectCommand);
    };
    @Override
    public void handleMouseUp(MouseEvent e, Color color) {
    }

    @Override
    public void handleMouseDrag(MouseEvent e, Color color) {

        MoveCommand moveCommand = new MoveCommand(canvasModel, mouseStartX, mouseStartY, e.getX(), e.getY());
        CommandInvoker.getInstance().executeCommand(moveCommand);
        mouseStartX = e.getX();
        mouseStartY=e.getY();
    }


}
