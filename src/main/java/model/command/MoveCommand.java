package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

import java.util.logging.Logger;

public class MoveCommand extends UndoableCommand {
    int dx, dy;
    public MoveCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2){
        super(canvasModel);
        this.dx= x2 - x1;
        this.dy = y2 - y1;
    }
    public MoveCommand(CanvasModel canvasModel, int x, int y){
        super(canvasModel);
        this.dx =  x - Integer.parseInt(canvasModel.getShapeSelection().getX());
        this.dy=  y - Integer.parseInt(canvasModel.getShapeSelection().getY()) ;
    }

    @Override
    public void doExecute() {
        canvasModel.moveSelectedShapes(dx, dy);
    }

}
