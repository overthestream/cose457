package controller;

import controller.brush.Brush;
import controller.brush.state.BrushState;
import model.CanvasModel;
import view.WindowView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter {
    private CanvasModel canvasModel;
    private Brush brush;
    public Controller(CanvasModel canvasModel){
        this.canvasModel= canvasModel;
        this.brush = new Brush(canvasModel);
    }

    public void setColor(Color color){
        brush.setColor(color);
    }

    public void setBrushState(BrushState brushState){
        brush.setState(brushState);
    }

    @Override
    public void mousePressed(MouseEvent e){
        brush.handleMouseDown(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        brush.handleMouseUp(e);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        brush.handleMouseClick(e);
    }

    @Override
    public void mouseDragged(MouseEvent e){
        brush.handleMouseDrag(e);
    }

    public void bringSelectedToFront() {
        canvasModel.bringSelectedToFront();
    }

    public void sendSelectedToBack() {
        canvasModel.sendSelectedToBack();
    }
}
