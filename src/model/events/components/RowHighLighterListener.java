package model.events.components;

import UI.components.TablePanel;
import model.components.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author Raffaele Andrei
 * Manages the next row highlighting
 */
public class RowHighLighterListener implements ActionListener {
    private TablePanel tablePanel;
    private int lastHighlightedRow;

    public RowHighLighterListener (TablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.lastHighlightedRow = -1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Vector<Transaction> transactions = tablePanel.getTransactionTableModel().getTransactions();
        String searchText = tablePanel.getSearchBarPanel().getSearchBar().getText();

        for(int i = 0; i < transactions.size(); ++i) {
            int row = tablePanel.getTableSorter().convertRowIndexToModel(i);

            if (row != -1 && transactions.get(row).getDescription().contains(searchText) && !searchText.equals("") && this.lastHighlightedRow < row) {
                tablePanel.getTransactionTableModel().setRowToHighlight(row);
                this.lastHighlightedRow = row;
                break;
            }

            if (row == transactions.size() -1) {
                this.lastHighlightedRow = -1;
                tablePanel.getTransactionTableModel().setRowToHighlight(-1);
                System.out.println("-1");

            }
        }

        tablePanel.getTransactionTable().repaint();
    }
}
