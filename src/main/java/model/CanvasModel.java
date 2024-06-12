package model;

import model.shape.ShadowShapeDecorator;
import model.shape.ShapeInterface;
import model.shape.ShapeSelectionComposite;
import view.Observer;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    public void resize(int width, int height){
        this.shapeSelection.setWidth(width);
        this.shapeSelection.setHeight(height);
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

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.shapeList);
            oos.writeObject(this.shapeSelection);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.shapeList = (ArrayList<ShapeInterface>) ois.readObject();
            this.shapeSelection = (ShapeSelectionComposite) ois.readObject();
            ois.close();
            notifyObservers();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("IOException occurred.");
        }
    }

    public void decorateShadow(){
        this.shapeList.replaceAll(shape -> shapeSelection.getShapes().contains(shape) ? new ShadowShapeDecorator(shape) : shape);
        notifyObservers();
    }
}


