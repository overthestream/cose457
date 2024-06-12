package model.command;

import model.CanvasModel;
import model.shape.ShapeInterface;
import model.shape.factory.ShapeFactory;

import java.awt.*;

public abstract class DrawCommand implements Command {
    protected ShapeInterface shape;
    protected CanvasModel canvasModel;
    protected int x1, y1, x2, y2;
    protected Color color;

    protected ShapeFactory shapeFactory;

    protected DrawCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2, Color color){
        this.x1 = x1;
        this.x2 = x2;
        this.y1= y1;
        this.y2=y2;
        this.canvasModel = canvasModel;
        this.color =color;
    }

    @Override
    public void undo(){
        this.canvasModel.removeShape(shape);
    }

    @Override
    public void execute(){
        this.shape = this.shapeFactory.createShape(x1, y1, x2, y2, color);
        this.canvasModel.addShape(shape);
    }

    @Override
    public boolean isUndoable() {
        return true;
    }
}
