package controller.brush.state;

import model.CanvasModel;
import model.shape.ShapeInterface;

import java.awt.*;
import java.awt.event.MouseEvent;


public abstract class BrushState {
     protected CanvasModel canvasModel;
     public BrushState(CanvasModel canvasModel){
          this.canvasModel= canvasModel;
     }

     public abstract void handleMouseDown(MouseEvent e, Color color);
     public abstract void handleMouseClick(MouseEvent e, Color color);

     public abstract void handleMouseUp(MouseEvent e, Color color);

     public abstract void handleMouseDrag(MouseEvent e, Color color);
}
