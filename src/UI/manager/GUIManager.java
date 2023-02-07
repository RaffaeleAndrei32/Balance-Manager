package UI.manager;

import UI.components.AddTransactionPanel;
import UI.components.TablePanel;
import UI.components.TopPanel;
import model.events.manager.EventManager;

import javax.swing.*;
import java.awt.*;

/**
 * Main class that manages UI components and events
 */
public class GUIManager extends JFrame {

    public GUIManager() {
        super("Balance Manager");
        setFrameAttributes();
        addContent();
        this.setVisible(true);
    }

    public void setFrameAttributes() {
        this.setLayout(new BorderLayout());
        this.setSize(1400, 750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addContent() {
        TopPanel topPanel = new TopPanel();
        this.add(topPanel, BorderLayout.PAGE_START);

        TablePanel tablePanel = new TablePanel();
        this.add(tablePanel, BorderLayout.CENTER);

        AddTransactionPanel addTransactionPanel = new AddTransactionPanel();
        this.add(addTransactionPanel, BorderLayout.PAGE_END);

        EventManager eventManager = new EventManager(topPanel, tablePanel, addTransactionPanel);
    }
}
