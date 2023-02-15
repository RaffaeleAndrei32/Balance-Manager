package UI.components;

import model.components.Transaction;
import model.components.TransactionTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Vector;

public class TransactionTable extends JTable {

    public TransactionTable(TransactionTableModel transactionTableModel) {
        Vector<Vector<Transaction>> tableData = new Vector();
        this.setModel(transactionTableModel);

        this.setRowHeight(40);
        this.getTableHeader().setReorderingAllowed(false);
        JTableHeader th = this.getTableHeader();
        th.setPreferredSize(new Dimension(100, 50));
    }

    @Override
    public TableModel getModel() {
        return super.getModel();
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
