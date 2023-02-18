package UI.manager;

import UI.components.AddTransactionPanel;
import UI.components.MenuBarPanel;
import UI.components.TablePanel;
import UI.components.TopPanel;
import model.components.HasAttributes;
import model.events.manager.EventManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Raffaele Andrei
 * Builds the view and UI components
 */
public class GUIManager extends JFrame implements HasAttributes {

    public GUIManager() {
        super("Balance Manager");
        setAttributes();
        addContent();
        this.setVisible(true);
    }

    public void setAttributes() {
        this.setLayout(new BorderLayout());
        this.setSize(1400, 750);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addContent() {
        MenuBarPanel menuBarPanel = new MenuBarPanel();
        this.setJMenuBar(menuBarPanel.getMenuBar());

        TablePanel tablePanel = new TablePanel();
        TopPanel topPanel = new TopPanel(tablePanel);
        this.add(topPanel, BorderLayout.PAGE_START);

        this.add(tablePanel, BorderLayout.CENTER);

        AddTransactionPanel addTransactionPanel = new AddTransactionPanel();
        this.add(addTransactionPanel, BorderLayout.PAGE_END);

        EventManager eventManager = new EventManager(topPanel, tablePanel, addTransactionPanel, menuBarPanel);
    }
}
