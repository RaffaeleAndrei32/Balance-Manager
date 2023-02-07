package model.components;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.Vector;

public class TransactionTableModel extends DefaultTableModel {
    private Vector<Transaction> transactions = new Vector<Transaction>();
    private Vector<Vector<Transaction>> tableData;
    private final static Vector<String> colsNames = new Vector<String>() {
        {
            this.add("Amount");
            this.add("Date");
            this.add("Description");
            this.add("Delete");
        }
    };

    public TransactionTableModel(Vector<Vector<Transaction>> tableData) {
        super(tableData, colsNames);
    }

    public void addTransaction(Transaction newTransaction) {
        Vector<Object> tmp = new Vector<Object>() {
            {
                this.add(newTransaction.getAmount());
                this.add(newTransaction.getDate());
                this.add(newTransaction.getDescription());
                this.add(new Boolean(false));
            }
        };

        transactions.add(newTransaction);
        addRow(tmp);
    }


    public Transaction getRow(int row) {
        return this.transactions.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) return true;
        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                this.getRow((rowIndex)).setAmount(Double.valueOf((String.valueOf(value))));
                super.setValueAt(value + "€", rowIndex, columnIndex);
                break;

            case 1:
                this.getRow(rowIndex).setDate((LocalDate)value);
                super.setValueAt(value, rowIndex, columnIndex);
                break;

            case 2:
               this.getRow(rowIndex).setDescription((String)value);
               super.setValueAt(value, rowIndex, columnIndex);
               break;

            case 3:
                super.setValueAt(value, rowIndex, columnIndex);
                break;
        }
    }

    public void removeRows() {
        boolean rowSelected = false;

        for (int i = 0; i < this.dataVector.size(); ++i) {
            if ((Boolean)((Vector)this.dataVector.get(i)).get(3)) {
                rowSelected = true;
                this.removeRow(i);
                this.transactions.remove(i);
                --i;
            }
        }
    }
}
