package UI.components;

import model.components.HasAttributes;

import javax.swing.*;
import java.awt.*;

public class TransactionTypePanel extends JPanel implements HasAttributes {
    private JRadioButton income;
    private JRadioButton outcome;
    private ButtonGroup transactionTypes;

    public TransactionTypePanel (){
        income = new JRadioButton("income");
        outcome = new JRadioButton("outcome");
        transactionTypes = new ButtonGroup();

        setAttributes();

        transactionTypes.add(income);
        transactionTypes.add(outcome);

        add(income);
        add(outcome);
    }

    public void setAttributes () {
        this.setBackground(Color.gray);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        income.setSelected(true);
        income.setFont(income.getFont().deriveFont(18f));
        outcome.setFont(outcome.getFont().deriveFont(18f));
        income.setBackground(Color.gray);
        outcome.setBackground(Color.gray);
    }

    public JRadioButton getIncome() {
        return income;
    }

    public JRadioButton getOutcome() {
        return outcome;
    }

    public ButtonGroup getTransactionTypes() {
        return transactionTypes;
    }
}
