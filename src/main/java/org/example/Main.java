package org.example;

import controller.Controller;
import model.CanvasModel;
import view.WindowView;

public class Main{
    public static void main(String[] args) {
        CanvasModel canvasModel = new CanvasModel();

        WindowView windowView =new WindowView(canvasModel);
        Controller controller = new Controller(canvasModel);
        windowView.initialize(controller);
    }
}