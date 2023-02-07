package UI.components;

import javax.swing.*;
import java.awt.*;

public class AddDeletePanel extends JPanel {
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
