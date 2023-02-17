package model.components;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.util.Vector;

public class TransactionTableModel extends DefaultTableModel implements Runnable{
    private Vector<Transaction> transactions = new Vector<Transaction>();
    private File targetFile = new File("save.tmp");
    private final static Vector<String> colsNames = new Vector<String>();
    private int rowToHighlight;

    public TransactionTableModel(Vector<Vector<Transaction>> tableData) {
        super(tableData, colsNames);

        colsNames.add("Amount");
        colsNames.add("Date");
        colsNames.add("Description");
        colsNames.add("Delete");

        this.rowToHighlight = -1;

        initThread();
    }

    private void initThread() {
        try {
            this.load(this.targetFile);
        } catch (IOException ioe) {
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        Thread t = new Thread(this);
        t.start();
    }

    public void addTransaction(Transaction newTransaction) {
        Vector<Object> tmp = new Vector<Object>() {
            {
                this.add(newTransaction.getAmount() + "€");
                this.add(newTransaction.getDate());
                this.add(newTransaction.getDescription());
                this.add(false);
            }
        };

        transactions.add(newTransaction);
        addRow(tmp);
    }

    public Vector<Transaction> getTransactions () {
        return this.transactions;
    }

    public File getTargetFile() {
        return targetFile;
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
                this.getRow((rowIndex)).setAmount(Double.parseDouble(String.valueOf(value)));
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
        for (int i = 0; i < this.dataVector.size(); ++i) {
            if ((Boolean)(this.dataVector.get(i)).get(3)) {
                this.removeRow(i);
                this.transactions.remove(i);

                if (i == this.rowToHighlight)
                    this.rowToHighlight = -1;
                --i;
            }
        }
    }

    public void setRowToHighlight (int row) {
        this.rowToHighlight = row;
    }

    public int getRowToHighlight () {
        return this.rowToHighlight;
    }

    public void save(File saveFile) throws IOException {
        ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(saveFile.getPath()));

        for(int i = 0; i < this.getTransactions().size(); ++i) {
            objectOut.writeObject(this.getTransactions().get(i));
        }

        objectOut.close();
    }

    public void load(File loadFile) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(loadFile.getPath());
        ObjectInputStream inputStream = new ObjectInputStream(fin);

        this.setRowCount(0);
        transactions.removeAllElements();

        Transaction transaction;
        try {
            while((transaction = (Transaction) inputStream.readObject()) != null) {
                this.addTransaction(transaction);
            }
        } catch (EOFException e) {
        }

        inputStream.close();
        this.fireTableDataChanged();
    }

    @Override
    public void run() {
        File f = new File("save.tmp");

        while(true) {
            while(true) {
                try {
                    this.save(f);
                    Thread.sleep(1000L);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
