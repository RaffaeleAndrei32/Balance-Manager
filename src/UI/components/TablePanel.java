package UI.components;

import model.components.HasAttributes;
import model.components.Transaction;
import model.components.TransactionTableModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Vector;

/**
 * @author Raffaele Andrei
 * Panel for JTable and SearchBarPanel
 */
public class TablePanel extends JPanel implements HasAttributes {
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

        this.setAttributes();

        this.add(searchBarPanel);
        this.add(transactionTableScrollable);
    }

    public void setAttributes() {
        this.setLayout(new BoxLayout(this,  BoxLayout.PAGE_AXIS));
        this.setBorder(new LineBorder(Color.gray, 20, false));

        transactionTable.getTableHeader().setEnabled(false);
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

    /**
     *
     * @return total of transactions in table view
     */
    public double totalOfTransactions () {
        double total = 0;

        try {
            for (int i = 0; i < this.transactionTableModel.getRowCount(); ++i) {
                int row = tableSorter.convertRowIndexToModel(i);
                total = total + (double) this.transactionTableModel.getRow(row).getAmount();
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        return total;
    }
}
