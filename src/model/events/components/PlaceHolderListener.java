package model.events.components;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlaceHolderListener implements MouseListener {
    private JTextField target;
    private String placeHolder;

    public PlaceHolderListener(JTextField target) {
        this.target = target;
        placeHolder = target.getText();
    }

    public PlaceHolderListener(JTextField target, String placeHolder) {
        this.target = target;
        this.placeHolder = placeHolder;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (target.getText().equals(placeHolder))
            target.setText("");
        else
            target.setText(placeHolder);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
