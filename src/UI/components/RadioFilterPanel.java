package UI.components;

import javax.swing.*;
import java.awt.*;

public class RadioFilterPanel extends JPanel {
    private JComboBox dateFilter;
    private ButtonGroup radioFilter = new ButtonGroup();
    private JRadioButton all = new JRadioButton("all");
    private JRadioButton day = new JRadioButton("select day");
    private JRadioButton week = new JRadioButton("select week");
    private JRadioButton month = new JRadioButton("select month");
    private JRadioButton year = new JRadioButton("select year");

    public RadioFilterPanel () {
        dateFilter = new JComboBox();

        setAttributes();

        dateFilter.addItem("all");
        dateFilter.addItem("this day");
        dateFilter.addItem("this week");
        dateFilter.addItem("this month");
        dateFilter.addItem("this year");

        add(dateFilter);
    }

    private void setAttributes () {
        this.setBackground(Color.gray);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        dateFilter.setFont(dateFilter.getFont().deriveFont(16f));
        dateFilter.setEditable(false);
    }

    public JComboBox getDateFilter () {
        return this.dateFilter;
    }
}
