package model.events.components;

import model.components.TransactionTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTransactionListener implements ActionListener {
    private TransactionTableModel tableModel;

    public DeleteTransactionListener(TransactionTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tableModel.removeRows();
    }
}
