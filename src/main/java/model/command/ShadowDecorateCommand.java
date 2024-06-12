package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;

public class ShadowDecorateCommand extends UndoableCommand{
    public ShadowDecorateCommand(CanvasModel canvasModel){
        super(canvasModel);
    }
    @Override
    public void doExecute() {
        this.canvasModel.decorateShadow();
    }
}
