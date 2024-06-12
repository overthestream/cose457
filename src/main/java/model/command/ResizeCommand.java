package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

public class ResizeCommand extends UndoableCommand {
    int width, height;
    public ResizeCommand( CanvasModel canvasModel, int width, int height){
        super(canvasModel);
        this.width=width;
        this.height=height;
    }
    @Override
    public void doExecute() {
        this.canvasModel.resize(width, height);
    }
}
