package UI.components;

import model.components.Transaction;
import model.components.TransactionTableModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Vector;

public class TablePanel extends JPanel {
    private Vector<Vector<Transaction>> tableData;
    private TransactionTableModel transactionTableModel;
    private TransactionTable transactionTable;
    private TableRowSorter tableSorter;
    private JScrollPane transactionTableScrollable;
    private SearchBarPanel searchBarPanel;

    public TablePanel () {
        tableData = new Vector();
        transactionTableModel = new TransactionTableModel(tableData);
        transactionTable = new TransactionTable(transactionTableModel);
        transactionTableScrollable = new JScrollPane(transactionTable);
        searchBarPanel = new SearchBarPanel();

        //setting table sorter
        tableSorter = new TableRowSorter(transactionTableModel);
        transactionTable.setRowSorter(tableSorter);

        transactionTable.getTableHeader().setEnabled(false);

        this.setAttributes();

        this.add(searchBarPanel);
        this.add(transactionTableScrollable);
    }

    private void setAttributes() {
        this.setLayout(new BoxLayout(this,  BoxLayout.PAGE_AXIS));
        this.setBorder(new LineBorder(Color.gray, 20, false));
    }

    public Vector<Vector<Transaction>> getTableData() {
        return tableData;
    }

    public void setTableData(Vector<Vector<Transaction>> tableData) {
        this.tableData = tableData;
    }

    public TransactionTable getTransactionTable() {
        return transactionTable;
    }

    public void setTransactionTable(TransactionTable transactionTable) {
        this.transactionTable = transactionTable;
    }

    public TransactionTableModel getTransactionTableModel() {
        return transactionTableModel;
    }

    public void setTransactionTableModel(TransactionTableModel transactionTableModel) {
        this.transactionTableModel = transactionTableModel;
    }

    public JScrollPane getTransactionTableScrollable() {
        return transactionTableScrollable;
    }

    public void setTransactionTableScrollable(JScrollPane transactionTableScrollable) {
        this.transactionTableScrollable = transactionTableScrollable;
    }

    public SearchBarPanel getSearchBarPanel() {
        return searchBarPanel;
    }

    public void setSearchBarPanel(SearchBarPanel searchBarPanel) {
        this.searchBarPanel = searchBarPanel;
    }

    public TableRowSorter getTableSorter() {
        return tableSorter;
    }


}
