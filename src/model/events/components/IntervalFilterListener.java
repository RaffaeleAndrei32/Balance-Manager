package model.events.components;

import UI.components.TablePanel;
import UI.components.TopPanel;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class IntervalFilterListener implements ActionListener {
    private JDateChooser initialDate;
    private JDateChooser finalDate;
    private TablePanel tablePanel;
    private TopPanel topPanel;

    public IntervalFilterListener(JDateChooser from, JDateChooser to, TablePanel tablePanel, TopPanel topPanel) {
        this.initialDate = from;
        this.finalDate = to;
        this.tablePanel = tablePanel;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String errorMessage = "";
        boolean error = false;

        if (initialDate.getDate() == null) {
            errorMessage = "Type a valid initial date!";
            error = true;
        }

        if (finalDate.getDate() == null) {
            if (error) errorMessage += "\n";
            errorMessage += "Type a valid final date!";
            error = true;
        }

        if (error) {
            JOptionPane.showMessageDialog(null,  errorMessage, "Choose a date", JOptionPane.ERROR_MESSAGE);
            return;
        }


        Date fromDate = initialDate.getDate();
        Date toDate = finalDate.getDate();

        LocalDate localFrom =  LocalDate.ofInstant(fromDate.toInstant(), ZoneId.systemDefault());
        LocalDate localTo = LocalDate.ofInstant(toDate.toInstant(), ZoneId.systemDefault());

            try {
                tablePanel.getTableSorter().setRowFilter(null);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No matching transactions found.");
                return;
            }

        RowFilter<TableModel, Integer> monthFilter = new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                TableModel tableModel = entry.getModel();
                LocalDate date = (LocalDate) tableModel.getValueAt(
                        entry.getIdentifier(), 1);

                return (date.isAfter(localFrom) | date.isEqual(localFrom)) && (date.isBefore(localTo) | date.isEqual(localTo));
            }
        };
        tablePanel.getTableSorter().setRowFilter(monthFilter);
        topPanel.updateTotal();
    }
}
