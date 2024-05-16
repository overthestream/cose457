package view;

import controller.Controller;
import controller.brush.state.EllipseDrawingState;
import controller.brush.state.LineDrawingState;
import controller.brush.state.RectangleDrawingState;
import controller.brush.state.SelectState;
import model.CanvasModel;
import model.shape.ShapeInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WindowView extends JFrame implements Observer {
    private CanvasView canvasView;
    private CanvasModel canvasModel;
    private PropertyPanel propertyPanel;
    public WindowView(CanvasModel canvasModel){

        canvasView = new CanvasView(canvasModel);
        this.canvasModel = canvasModel;
        canvasModel.addObserver(this);
    }


    public void initialize(Controller controller){
        setLayout(new BorderLayout());
        setTitle("Graphic Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        propertyPanel = new PropertyPanel(canvasView);
        add(propertyPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        JButton rectangleButton  =new JButton("Rectangle");
        rectangleButton.addActionListener(e->controller.setBrushState(new RectangleDrawingState(canvasModel)));

        JButton ellipseButton  =new JButton("Ellipse");
        ellipseButton.addActionListener(e->controller.setBrushState(new EllipseDrawingState(canvasModel)));

        JButton lineButton  =new JButton("Line");
        lineButton.addActionListener(e->controller.setBrushState(new LineDrawingState(canvasModel)));

        JButton selectButton  =new JButton("Select");
        selectButton.addActionListener(e->controller.setBrushState(new SelectState(canvasModel)));

        JButton bringToFrontButton = new JButton("Bring to Front");
        bringToFrontButton.addActionListener(e -> {
            controller.bringSelectedToFront();
        });

        JButton sendToBackButton = new JButton("Send to Back");
        sendToBackButton.addActionListener(e -> {
            controller.sendSelectedToBack();
        });
        buttonPanel.add(bringToFrontButton);
        buttonPanel.add(sendToBackButton);

        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(selectButton);
        add(buttonPanel, BorderLayout.NORTH);

        canvasView.setBackground(Color.WHITE);
        canvasView.addMouseListener(controller);
        canvasView.addMouseMotionListener(controller);
        this.add(canvasView, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void update() {
        propertyPanel.setSelectedShape(canvasModel.getShapeSelection());
    }
}
