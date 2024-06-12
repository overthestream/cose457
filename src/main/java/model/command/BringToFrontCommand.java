package model.command;

import model.CanvasModel;

public class BringToFrontCommand implements Command{
    CanvasModel canvasModel;
    public BringToFrontCommand(CanvasModel canvasModel){
        this.canvasModel= canvasModel;
    }

    @Override
    public void undo() {

    }

    @Override
    public void execute() {
        canvasModel.bringSelectedToFront();
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
