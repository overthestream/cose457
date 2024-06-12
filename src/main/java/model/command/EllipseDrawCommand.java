package model.command;

import model.CanvasModel;
import model.shape.EllipseShape;
import model.shape.factory.EllipseFactory;

import java.awt.*;

public class EllipseDrawCommand extends DrawCommand {

    public EllipseDrawCommand(CanvasModel canvasModel, int x1, int y1, int x2, int y2, Color color){
        super(canvasModel, x1, y1, x2, y2, color);
        this.shapeFactory = EllipseFactory.getInstance();
    }
}
