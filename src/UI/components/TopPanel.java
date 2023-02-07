package UI.components;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;

public class TopPanel extends JPanel {
    private JLabel showAmount;
    private JDateChooser initalDate;
    private JDateChooser finalDate;
    private JButton filter;
    private JLabel intialtDateLabel = new JLabel("From");
    private JLabel finalDateLabel = new JLabel("To");
    private JButton otherFilters = new JButton("FILTERS");
    private JButton showAll = new JButton("ALL");

    public TopPanel() {
        initalDate = new JDateChooser(new Date());
        finalDate = new JDateChooser(new Date());
        filter = new JButton("FILTER");
        showAmount = new JLabel();

        setAttributes();
        //showAmount.setEditable(false);

        showAmount.setText("99999");
        add(showAmount);
        add(intialtDateLabel);
        add(initalDate);
        add(finalDateLabel);
        add(finalDate);
        add(filter);
        add(otherFilters);
        add(showAll);
    }

    private void setAttributes() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(this.getWidth(), 200));

        initalDate.setPreferredSize(new Dimension(150, 50));
        initalDate.setFont(initalDate.getFont().deriveFont(20f));
        finalDate.setPreferredSize(new Dimension(150, 50));
        finalDate.setFont(finalDate.getFont().deriveFont(20f));;

        showAmount.setPreferredSize(new Dimension(300, 100));
        showAmount.setBorder(new LineBorder(Color.ORANGE, 2));

        showAll.setPreferredSize(new Dimension(100,  50));
        otherFilters.setPreferredSize(new Dimension(100,  50));
        filter.setPreferredSize(new Dimension(100, 50));

    }

    public JDateChooser getInitalDate() {
        return initalDate;
    }

    public JDateChooser getFinalDate() {
        return finalDate;
    }

    public JButton getFilter() {
        return filter;
    }

    public JButton getOtherFilters() {
        return otherFilters;
    }

    public JLabel getShowAmount() {
        return showAmount;
    }

    public JButton getShowAll () {
        return showAll;
    }
}
