package model.command;

import model.CanvasModel;

public class BringToFrontCommand extends UndoableCommand{
    public BringToFrontCommand(CanvasModel canvasModel){
        super(canvasModel);
    }
    @Override
    public void doExecute() {
        canvasModel.bringSelectedToFront();
    }
}
