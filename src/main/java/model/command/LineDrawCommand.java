package model.command;

import model.CanvasModel;
import model.shape.factory.LineFactory;

import java.awt.*;

public class LineDrawCommand extends DrawCommand {
    public LineDrawCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2, Color color){
        super(canvasModel, x1, y1, x2, y2, color);
        this.shapeFactory = LineFactory.getInstance();
    }
}
