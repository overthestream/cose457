package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

import java.awt.*;

public class SelectCommand implements Command {
    CanvasModel canvasModel;
    int x ,y;

    public SelectCommand(CanvasModel canvasModel, int x , int y){
        this.canvasModel = canvasModel;
        this.x= x;
        this.y =y;
    }

    @Override
    public void undo() {
    }

    @Override
    public void execute() {
        canvasModel.selectShape(x, y);
    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
