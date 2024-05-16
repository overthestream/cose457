package view;

import model.shape.ShapeInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyPanel extends JPanel {
    private JTextField xField;
    private JTextField yField;
    private JTextField widthField;
    private JTextField heightField;

    private ShapeInterface selectedShape;

    public PropertyPanel(CanvasView canvasView) {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("X:"));
        xField = new JTextField();
        add(xField);

        add(new JLabel("Y:"));
        yField = new JTextField();
        add(yField);

        add(new JLabel("Width:"));
        widthField = new JTextField();
        add(widthField);

        add(new JLabel("Height:"));
        heightField = new JTextField();
        add(heightField);

        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(e -> {applyChanges(); canvasView.update();});
        add(applyButton);
    }

    public void setSelectedShape(ShapeInterface shape) {
        this.selectedShape = shape;
        if (shape != null) {
            xField.setText(String.valueOf(shape.getX()));
            yField.setText(String.valueOf(shape.getY()));
            widthField.setText(String.valueOf(shape.getWidth()));
            heightField.setText(String.valueOf(shape.getHeight()));
        }
    }

    private void applyChanges() {
        if (selectedShape != null) {
            selectedShape.setX(Integer.parseInt(xField.getText()));
            selectedShape.setY(Integer.parseInt(yField.getText()));
            selectedShape.setWidth(Integer.parseInt(widthField.getText()));
            selectedShape.setHeight(Integer.parseInt(heightField.getText()));
        }
    }
}