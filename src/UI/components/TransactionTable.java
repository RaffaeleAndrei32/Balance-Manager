package UI.components;

import model.components.Transaction;
import model.components.TransactionTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
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

    public TableModel getModel() {
        return super.getModel();
    }

    public Object getValueAt(int row, int column) {
        return getModel().getValueAt(convertRowIndexToModel(row),
                convertColumnIndexToModel(column));
    }
}
