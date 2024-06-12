package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

import java.util.logging.Logger;

public class MoveCommand implements Command {
    CanvasModel canvasModel;
    ShapeInterface selectedShapes;
    int dx, dy;
    public MoveCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2){
        this.canvasModel = canvasModel;
        this.dx= x2 - x1;
        this.dy = y2 - y1;
    }
    public MoveCommand(CanvasModel canvasModel, int x, int y){
        this.canvasModel = canvasModel;
        this.dx =  x - Integer.parseInt(canvasModel.getShapeSelection().getX());
        this.dy=  y - Integer.parseInt(canvasModel.getShapeSelection().getY()) ;
    }

    @Override
    public void undo() {
        selectedShapes.move(-dx, -dy);
        canvasModel.notifyObservers();
    }

    @Override
    public void execute() {
        selectedShapes = canvasModel.getShapeSelection();
        canvasModel.moveSelectedShapes(dx, dy);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
