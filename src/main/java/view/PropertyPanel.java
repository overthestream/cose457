package view;

import controller.Controller;
import model.CanvasModel;
import model.shape.ShapeInterface;

import javax.swing.*;
import java.awt.*;


public class PropertyPanel extends JPanel implements Observer {
    private JTextField xField;
    private JTextField yField;
    private JTextField widthField;
    private JTextField heightField;
    private CanvasModel canvasModel;
    public PropertyPanel(Controller controller, CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
        canvasModel.addObserver(this);

        JLabel xLabel = new JLabel("X:");
        xField = new JTextField(10);

        JLabel yLabel = new JLabel("Y:");
        yField = new JTextField(10);

        JButton moveApplyButton = new JButton("Apply move");
        moveApplyButton.addActionListener(e -> {
            controller.move(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()));
        });

        JLabel widthLabel = new JLabel("Width:");
        widthField = new JTextField(10);

        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);

        JButton resizeApplyButton = new JButton("Apply resize");
        resizeApplyButton.addActionListener(e -> {
            controller.resize(Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));
        });

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> {
            controller.undo();
        });

        JButton redoButton = new JButton("Redo");
        redoButton.addActionListener(e -> {
            controller.redo();
        });

        JButton shadowButton = new JButton("Shadow");
        shadowButton.addActionListener(e -> {
            controller.decorateShadow();
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(xLabel)
                                .addComponent(yLabel)
                                .addComponent(widthLabel)
                                .addComponent(heightLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(xField)
                                .addComponent(yField)
                                .addComponent(widthField)
                                .addComponent(heightField)
                                .addComponent(moveApplyButton)
                                .addComponent(resizeApplyButton)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(undoButton)
                                        .addComponent(redoButton))
                                .addComponent(shadowButton))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(xLabel)
                                .addComponent(xField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(yLabel)
                                .addComponent(yField))
                        .addComponent(moveApplyButton)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(widthLabel)
                                .addComponent(widthField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(heightLabel)
                                .addComponent(heightField))
                        .addComponent(resizeApplyButton)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(undoButton)
                                .addComponent(redoButton))
                        .addComponent(shadowButton)
        );
    }
    @Override
    public void update() {
        ShapeInterface shape = canvasModel.getShapeSelection();

        xField.setText(String.valueOf(shape.getX()));
        yField.setText(String.valueOf(shape.getY()));
        widthField.setText(String.valueOf(shape.getWidth()));
        heightField.setText(String.valueOf(shape.getHeight()));
    }
}