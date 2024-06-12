package model.command;

import model.CanvasModel;

public class SendToBackCommand extends UndoableCommand {
    public SendToBackCommand(CanvasModel canvasModel){
        super(canvasModel);
    }
    @Override
    public void doExecute() {
        canvasModel.sendSelectedToBack();
    }

}

