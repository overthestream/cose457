package controller.brush;

import controller.brush.state.BrushState;
import controller.brush.state.RectangleDrawingState;
import model.CanvasModel;
import model.shape.ShapeInterface;

import java.awt.*;
import java.awt.event.MouseEvent;

// Brush의 책임: Mouse Event에 다라 Shape 속성 변경 / 추가
public abstract class Brush extends BrushState {

    private Color color = new Color(0,0,0);
    private BrushState state;
    private CanvasModel canvasModel;
    public Brush(CanvasModel canvasModel){
        state=new RectangleDrawingState(canvasModel);
        this.canvasModel=canvasModel;
    }

    public void setState(BrushState state) {
        this.state = state;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void handleMouseDown(MouseEvent e){
        state.handleMouseDown(e, color);
    }

    public void handleMouseUp(MouseEvent e){
         state.handleMouseUp(e, color);
    }
    public void handleMouseClick(MouseEvent e){
        state.handleMouseClick(e, color);
    }

    public void handleMouseDrag(MouseEvent e){
        state.handleMouseDrag(e, color);
    }

}
