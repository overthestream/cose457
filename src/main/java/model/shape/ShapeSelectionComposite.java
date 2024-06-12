package model.shape;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeSelectionComposite implements ShapeInterface, Iterable<ShapeInterface>, Serializable {

    private List<ShapeInterface> shapes = new ArrayList<>();

    public List<ShapeInterface> getShapes(){
        return shapes;
    }

    public void removeAll(){
        shapes.clear();
    }

    public void selectShape(ShapeInterface shape){
        if(shapes.contains(shape)) {
            shape.setColor(Color.black);
            shapes.remove(shape);
        }
        else {
            shapes.add(shape);
            shape.setColor(Color.blue);
        }
    }
    @Override
    public Iterator<ShapeInterface> iterator() {
        return shapes.iterator();
    }

    @Override
    public boolean contains(int x, int y ){
        for(ShapeInterface shape: shapes){
            if(shape.contains(x, y)) return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics2D g2) {
        for(ShapeInterface shape: shapes){
            shape.draw(g2);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for(ShapeInterface shape: shapes){
            shape.move(dx, dy);
        }
    }

    @Override
    public void setColor(Color color) {
        for(ShapeInterface shape: shapes){
            shape.setColor(color);
        }
    }

    @Override
    public String getWidth() {
        if(shapes.size() == 1) return shapes.get(0).getWidth();
        return "";
    }

    @Override
    public String getHeight() {
        if(shapes.size() == 1) return shapes.get(0).getHeight();
        return "";
    }

    @Override
    public void setWidth(int width) {
        if(shapes.size() == 1) shapes.get(0).setWidth(width);

    }

    @Override
    public void setHeight(int height) {
        if(shapes.size() == 1) shapes.get(0).setHeight(height);

    }

    @Override
    public String getX() {
        if(shapes.size() == 1) return shapes.get(0).getX();

        return "";
    }

    @Override
    public String getY() {

        if(shapes.size() == 1) return shapes.get(0).getY();
        return "";
    }

    @Override
    public void setX(int x) {
    }

    @Override
    public void setY(int y) {
    }
}
