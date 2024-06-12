package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

public class ResizeCommand implements Command {
    CanvasModel canvasModel;
    int width, height;
    public ResizeCommand( CanvasModel canvasModel, int width, int height){
        this.canvasModel=canvasModel;
        this.width=width;
        this.height=height;
    }
    @Override
    public void undo() {
        canvasModel.notifyObservers();;
    }

    @Override
    public void execute() {
        canvasModel.getShapeSelection().setWidth(width);
        canvasModel.getShapeSelection().setHeight(height);
        canvasModel.notifyObservers();;
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
