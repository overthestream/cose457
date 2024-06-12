package model;

import model.shape.ShapeInterface;
import model.shape.ShapeSelectionComposite;
import view.Observer;

import java.awt.*;
import java.util.ArrayList;

public class CanvasModel  implements Subject{
    private ShapeSelectionComposite shapeSelection = new ShapeSelectionComposite();
    public  CanvasModel(){
    }

    private ArrayList<ShapeInterface> shapeList = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<ShapeInterface> getShapeList() {
        return shapeList;
    }

    public ShapeSelectionComposite getShapeSelection() {
        return shapeSelection;
    }

    public void moveSelectedShapes(int dx, int dy){
        this.shapeSelection.move(dx, dy);
        notifyObservers();
    }

    private ShapeInterface getShapeAtPoint(int x, int y) {
        for(ShapeInterface shape : shapeList){
            if(shape.contains(x, y)) return shape;
        }
        return null;
    }

    public void bringSelectedToFront() {
        for(ShapeInterface shape : shapeSelection){
            shapeList.remove(shape);
            shapeList.add(0, shape);
        }
        notifyObservers();
    }

    public void sendSelectedToBack() {
        for(ShapeInterface shape : shapeSelection){
            shapeList.remove(shape);
            shapeList.add(shape);
        }
        notifyObservers();
    }

    public void selectShape(int x, int y){
        ShapeInterface shape = getShapeAtPoint(x, y);
        if(shape == null) {
            clearSelection();
        }
        else {
            shape.setColor(Color.blue);
            this.shapeSelection.selectShape(shape);
        }
        notifyObservers();
    }



    private void clearSelection(){
        shapeSelection.setColor(Color.black);
        this.shapeSelection.removeAll();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void addShape(ShapeInterface shapeInterface){
        shapeList.add(shapeInterface);
        notifyObservers();
    }

    public void removeShape(ShapeInterface shapeInterface) {
        shapeList.remove(shapeInterface);
        notifyObservers();
    }
}


