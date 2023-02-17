package UI.components;

import model.components.HasAttributes;

import javax.swing.*;
import java.awt.*;

/**
 * @author Raffaele Andrei
 * Panel form ADD and DELETE button
 */
public class AddDeletePanel extends JPanel implements HasAttributes {
    private JButton addButton;
    private JButton deleteButton;

    public AddDeletePanel () {
        addButton = new JButton("ADD");
        deleteButton = new JButton("DELETE");

        setAttributes();

        add(addButton);
        add(deleteButton);
    }

    public void setAttributes() {
        this.setLayout(new GridLayout(2, 1, 0, 2));
        this.setBackground(Color.gray);

        addButton.setPreferredSize(new Dimension(100, 40));
        deleteButton.setPreferredSize(new Dimension(100, 40));
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
