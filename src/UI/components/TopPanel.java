package UI.components;

import com.toedter.calendar.JDateChooser;
import model.components.HasAttributes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;

/**
 * @author Raffaele Andrei
 * Panel for TablePanel, showAmount and filters
 */
public class TopPanel extends JPanel implements HasAttributes {
    private TablePanel tablePanel;
    private JTextField showAmount;
    private JDateChooser initalDate;
    private JDateChooser finalDate;
    private JButton filter;
    private JLabel intialtDateLabel = new JLabel("From");
    private JLabel finalDateLabel = new JLabel("To");
    private JButton otherFilters = new JButton("FILTERS");
    private JButton showAll = new JButton("ALL");

    public TopPanel(TablePanel tablePanel) {
        this.tablePanel = tablePanel;
        initalDate = new JDateChooser(new Date());
        finalDate = new JDateChooser(new Date());
        filter = new JButton("FILTER");
        showAmount = new JTextField(tablePanel.totalOfTransactions() + "€");

        setAttributes();

        //showAmount.setEditable(false);
        add(showAmount);
        add(intialtDateLabel);
        add(initalDate);
        add(finalDateLabel);
        add(finalDate);
        add(filter);
        add(otherFilters);
        add(showAll);
    }

    public void setAttributes() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(this.getWidth(), 200));

        initalDate.setPreferredSize(new Dimension(150, 50));
        initalDate.setFont(initalDate.getFont().deriveFont(20f));
        finalDate.setPreferredSize(new Dimension(150, 50));
        finalDate.setFont(finalDate.getFont().deriveFont(20f));;

        showAmount.setPreferredSize(new Dimension(500, 100));
        showAmount.setBorder(new LineBorder(Color.black, 1));
        showAmount.setEditable(false);
        showAmount.setFont(showAmount.getFont().deriveFont(50f));

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

    public JTextField getShowAmount() {
        return showAmount;
    }

    public JButton getShowAll () {
        return showAll;
    }

    public void updateTotal () {
        this.showAmount.setText(tablePanel.totalOfTransactions() + "€");
        //this.showAmount.setForeground(tablePanel.totalOfTransactions() >= 0.0 ? Color.green : Color.red);
    }
}
