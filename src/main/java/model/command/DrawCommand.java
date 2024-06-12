package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;
import model.shape.factory.ShapeFactory;

import java.awt.*;

public abstract class DrawCommand extends UndoableCommand {
    protected int x1, y1, x2, y2;
    protected Color color;
    protected ShapeFactory shapeFactory;

    protected DrawCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2, Color color){
        super(canvasModel);
        this.x1 = x1;
        this.x2 = x2;
        this.y1= y1;
        this.y2=y2;
        this.color =color;
    }

    @Override
    public void doExecute(){
        ShapeInterface shape = this.shapeFactory.createShape(x1, y1, x2, y2, color);
        this.canvasModel.addShape(shape);
    }
}
