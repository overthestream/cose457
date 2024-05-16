package view.gui;

import controller.Controller;
import controller.brush.state.BrushState;

import javax.swing.*;

public abstract class BrushSelectButton extends JButton {
    public BrushSelectButton(BrushState brushState, Controller controller){

        this.addActionListener(e->controller.setBrushState(brushState));
    }
}
