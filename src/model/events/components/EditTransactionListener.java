package model.events.components;

import UI.components.TablePanel;
import UI.components.TopPanel;
import com.toedter.calendar.JDateChooser;
import model.components.JTextFieldLimit;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EditTransactionListener implements MouseListener {
    private TablePanel tablePanel;
    private TopPanel topPanel;

    public EditTransactionListener (TablePanel tablePanel, TopPanel topPanel) {
        this.tablePanel = tablePanel;
        this.topPanel = topPanel;
    }

    private boolean isAmountCorrect(JTextField editAmount) {
        try {
            Double.parseDouble(editAmount.getText());
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JTable table = (JTable)mouseEvent.getSource();
        int row = tablePanel.getTableSorter().convertRowIndexToModel(table.getSelectedRow());
        int col = tablePanel.getTransactionTable().columnAtPoint(mouseEvent.getPoint());

        int id = 0;
        Object[] data = new Object[]{};
        JDateChooser editDate = new JDateChooser(new Date());
        JTextField editDescription = new JTextField();

        editDescription.setDocument(new JTextFieldLimit(40));

        switch (col) {
            case 0:
                JTextField editAmount = new JTextField();
                editAmount.setDocument(new JTextFieldLimit(12));
                data = new Object[]{"Amount: ", editAmount};

                id = JOptionPane.showConfirmDialog(null, data, "Edit amount", -1);
                if (id == -1) return;

                while (editAmount.getText() == null || !isAmountCorrect(editAmount)) {
                    id = JOptionPane.showConfirmDialog(null, data, "Edit amount", -1);
                    if (id == -1) return;
                }

                tablePanel.getTransactionTableModel().setValueAt(editAmount.getText(), row, col);

                break;

            case 1:
                data = new Object[]{"Date: ", editDate};

                id = JOptionPane.showConfirmDialog(null, data, "Edit date", -1);
                if (id == -1) return;

                while (editDate.getDate() == null) {
                    id = JOptionPane.showConfirmDialog(null, data, "Edit date", -1);
                    if (id == -1) return;
                }

                Date tmpDate = editDate.getDate();
                LocalDate newDate =  LocalDate.ofInstant(tmpDate.toInstant(), ZoneId.systemDefault());

                tablePanel.getTransactionTableModel().setValueAt(newDate, row, col);
                break;

            case 2:
                data = new Object[]{"Description: ", editDescription};

                id = JOptionPane.showConfirmDialog(null, data, "Edit description", -1);
                if (id == -1) return;

                while (editDescription.getText().equals("")) {
                    id = JOptionPane.showConfirmDialog(null, data, "Edit description", -1);
                    if (id == -1) return;
                }

                tablePanel.getTransactionTableModel().setValueAt(editDescription.getText(), row, col);
                break;

            default:
                return;
        }
        topPanel.updateTotal();
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
