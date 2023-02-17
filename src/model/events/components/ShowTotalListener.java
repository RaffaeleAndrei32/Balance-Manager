package model.events.components;

import UI.components.TopPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Raffaele Andrei
 * Shows total on click
 */
public class ShowTotalListener implements MouseListener {
    private TopPanel topPanel;

    public ShowTotalListener(TopPanel topPanel) {
        this.topPanel = topPanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JOptionPane.showMessageDialog(null, topPanel.getShowAmount().getText());
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
