package UI.components;

import model.components.HasAttributes;
import model.components.JTextFieldLimit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Raffaele Andrei
 * Panel for the transaction data inputs
 */
public class AddTransactionPanel extends JPanel implements HasAttributes {
    private DatePanel dateChooser;
    private TransactionTypePanel transactionType;
    private JTextField descriptionField;
    private JTextField amountField;
    private AddDeletePanel addDeletePanel;

    public AddTransactionPanel() {
        dateChooser = new DatePanel();
        transactionType = new TransactionTypePanel();
        this.descriptionField = new JTextField("");
        this.amountField = new JTextField("");

        addDeletePanel = new AddDeletePanel();

        setAttributes();

        add(transactionType);
        add(amountField);
        add(descriptionField);
        add(dateChooser);
        add(addDeletePanel);
    }

     public void setAttributes() {
        this.setBackground(Color.gray);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

        descriptionField.setDocument(new JTextFieldLimit(40));
        descriptionField.setPreferredSize(new Dimension(600, 50));
        descriptionField.setFont(descriptionField.getFont().deriveFont(20f));
        descriptionField.setBorder(new LineBorder(Color.darkGray));

        amountField.setDocument(new JTextFieldLimit(12));
        amountField.setPreferredSize(new Dimension(200, 50));
        amountField.setFont(amountField.getFont().deriveFont(20f));
        amountField.setBorder(new LineBorder(Color.darkGray));
    }

    public DatePanel getDateChooser() {
        return dateChooser;
    }

    public TransactionTypePanel getTransactionType() {
        return transactionType;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public AddDeletePanel getAddDeletePanel() {
        return addDeletePanel;
    }
}
