package model.command;

import model.CanvasModel;

public class SendToBackCommand implements Command{
    CanvasModel canvasModel;
    public SendToBackCommand(CanvasModel canvasModel){
        this.canvasModel= canvasModel;
    }

    @Override
    public void undo() {

    }

    @Override
    public void execute() {
        canvasModel.sendSelectedToBack();
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}

