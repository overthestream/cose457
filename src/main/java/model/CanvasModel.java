package model;

import model.shape.ShapeInterface;
import model.shape.ShapeSelectionComposite;
import view.Observer;

import java.awt.*;
import java.util.ArrayList;

public class CanvasModel  implements Subject{
    private ShapeSelectionComposite shapeSelection;
    public  CanvasModel(){
        clearSelection();
    }

    private ArrayList<ShapeInterface> shapeList = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<ShapeInterface> getShapeList() {
        return shapeList;
    }

    public ShapeSelectionComposite getShapeSelection() {
        return shapeSelection;
    }

    // chain of responsibility?
    public ShapeInterface getShapeAtPoint(int x, int y) {
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
            shapeList.add( shape);
        }
        notifyObservers();
    }

    public void selectShape(ShapeInterface shape){
        this.shapeSelection.selectShape(shape);
        notifyObservers();
    }

    public void clearSelection(){
        for(ShapeInterface shape : shapeList) shape.setColor(Color.black);
        this.shapeSelection=new ShapeSelectionComposite();
        notifyObservers();
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
}


