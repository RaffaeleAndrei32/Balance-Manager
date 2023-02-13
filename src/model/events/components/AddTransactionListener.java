package model.events.components;

import UI.components.AddTransactionPanel;
import UI.components.TablePanel;
import UI.components.TopPanel;
import model.components.Transaction;
import model.exeptions.MyExeption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddTransactionListener implements ActionListener {
    private AddTransactionPanel addTransactionPanel;
    private TablePanel tablePanel;
    private TransactionTypeListener transactionTypeListener;
    private String descriptionPlaceHolder;
    private TopPanel topPanel;

    public AddTransactionListener(AddTransactionPanel addTransactionPanel, TablePanel tablePanel, TransactionTypeListener transactionTypeListener, TopPanel topPanel) {
        this.addTransactionPanel = addTransactionPanel;
        this.tablePanel = tablePanel;
        this.transactionTypeListener = transactionTypeListener;
        this.descriptionPlaceHolder = "";
        this.topPanel = topPanel;
    }

    public AddTransactionListener(AddTransactionPanel addTransactionPanel, TablePanel tablePanel, TransactionTypeListener transactionTypeListener, String placeHolder, TopPanel topPanel) {
        this.addTransactionPanel = addTransactionPanel;
        this.tablePanel = tablePanel;
        this.transactionTypeListener = transactionTypeListener;
        this.descriptionPlaceHolder = placeHolder;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        Boolean transactionState = true;
        if (transactionTypeListener.getTransactionType() == null);
        else if (transactionTypeListener.getTransactionType().equals("outcome"))
                transactionState = false;


        String errorMessage = "";
        Boolean error = true;
        int errorCount = 0;
        double transactionAmount = 0;
        try {
            if (addTransactionPanel.getAmountField().getText().equals("") || Double.parseDouble(addTransactionPanel.getAmountField().getText()) < 0.0)
                throw new MyExeption("Enter a valid amount!");
            transactionAmount = Double.parseDouble(addTransactionPanel.getAmountField().getText());
        } catch(MyExeption | NumberFormatException e) {
            errorMessage += e.getMessage() + "\n";
            errorCount++;
        }

        LocalDate trasactionDate = LocalDate.now();
        Date tmpDate = new Date();
        try {
            if (addTransactionPanel.getDateChooser().getDateChooser().getDate() == null)
                throw new MyExeption("Choose a valid date!");
            tmpDate = addTransactionPanel.getDateChooser().getDateChooser().getDate();
            trasactionDate =  LocalDate.ofInstant(tmpDate.toInstant(), ZoneId.systemDefault());
        } catch(MyExeption e) {
            errorMessage += e.getMessage() + "\n";
            errorCount++;
        }

        String transactionDescription = "";
        try {
            if (addTransactionPanel.getDescriptionField().getText().equals("") || addTransactionPanel.getDescriptionField().getText().equals(descriptionPlaceHolder))
                throw new MyExeption("Enter a valid description!");
            transactionDescription = addTransactionPanel.getDescriptionField().getText();
        } catch (MyExeption e) {
            errorMessage += e.getMessage();
            errorCount++;
        }

        if (errorMessage.equals("")) {
            Transaction newTransaction = new Transaction(trasactionDate, transactionAmount, transactionDescription, transactionState);
            tablePanel.getTransactionTableModel().addTransaction(newTransaction);

            //update total
            topPanel.updateTotal();
        }
        else {
            JOptionPane.showConfirmDialog(null,
                    errorMessage, (errorCount + " errors have been detected!"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
}