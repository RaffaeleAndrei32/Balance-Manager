package model.events.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionTypeListener implements ActionListener {
    private String transactionType;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        transactionType = actionEvent.getActionCommand();
    }

    public String getTransactionType() {
        return transactionType;
    }
}
