package model.events.components;

import UI.components.TopPanel;
import model.components.TransactionTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTransactionListener implements ActionListener {
    private TransactionTableModel tableModel;
    private TopPanel topPanel;

    public DeleteTransactionListener(TransactionTableModel tableModel, TopPanel topPanel) {
        this.tableModel = tableModel;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tableModel.removeRows();
        topPanel.updateTotal();
    }
}
