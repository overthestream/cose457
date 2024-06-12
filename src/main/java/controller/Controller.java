package controller;

import controller.brush.Brush;
import controller.brush.state.BrushState;
import model.CanvasModel;
import model.command.*;
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


        BringToFrontCommand bringToFrontCommand = new BringToFrontCommand(canvasModel);
        CommandInvoker.getInstance().executeCommand(bringToFrontCommand);
    }

    public void sendSelectedToBack() {

        SendToBackCommand sendToBackCommand = new SendToBackCommand(canvasModel);
        CommandInvoker.getInstance().executeCommand(sendToBackCommand);
    }

    public void move(int x, int y){
        MoveCommand moveCommand = new MoveCommand(canvasModel, x, y);
        CommandInvoker.getInstance().executeCommand(moveCommand);
    }

    public void resize(int width, int height) {
        ResizeCommand resizeCommand = new ResizeCommand(canvasModel, width, height);
        CommandInvoker.getInstance().executeCommand(resizeCommand);
    }

    public void decorateShadow(){
        ShadowDecorateCommand shadowDecorateCommand = new ShadowDecorateCommand(canvasModel);
        CommandInvoker.getInstance().executeCommand(shadowDecorateCommand);
    }

    public void undo(){
        CommandInvoker.getInstance().undo(canvasModel);
    }
    public void redo() {
        CommandInvoker.getInstance().redo(canvasModel);
    }

}
