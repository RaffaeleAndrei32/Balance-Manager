package UI.components;

import model.components.TransactionTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TransactionTable extends JTable {
    private TransactionTableModel transactionTableModel;

    public TransactionTable(TransactionTableModel transactionTableModel) {
        this.transactionTableModel = transactionTableModel;
        this.setModel(transactionTableModel);

        this.setRowHeight(40);
        this.getTableHeader().setReorderingAllowed(false);
        JTableHeader th = this.getTableHeader();
        th.setPreferredSize(new Dimension(100, 50));
    }

    @Override
    public TransactionTableModel getModel() {
        return this.transactionTableModel;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return getModel().getValueAt(convertRowIndexToModel(row),
                convertColumnIndexToModel(column));
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);
        row = this.convertRowIndexToModel(row);

        if (row == this.getModel().getRowToHighlight())
            component.setBackground(Color.yellow);
        else
            component.setBackground(Color.white);

        Color color;
        if (column == 0) {
            TransactionTableModel tableModel = (TransactionTableModel) this.getModel();
            if (tableModel.getTransactions().get(row).getAmount() >= 0)
                color = Color.green;
            else
                color = Color.red;

            component.setForeground(color);
        } else
            component.setForeground(Color.black);

        return component;
    }
}
