package model.events.manager;

import UI.components.AddTransactionPanel;
import UI.components.MenuBarPanel;
import UI.components.TablePanel;
import UI.components.TopPanel;
import model.events.components.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventManager {
    private TopPanel topPanel;
    private TablePanel tablePanel;
    private AddTransactionPanel addTransactionPanel;
    private MenuBarPanel menuBarPanel;

    public EventManager(TopPanel top, TablePanel tablep, AddTransactionPanel addp, MenuBarPanel menuBarPanel) {
        this.topPanel = top;
        this.tablePanel = tablep;
        this.addTransactionPanel = addp;
        this.menuBarPanel = menuBarPanel;

        //PLACEHOLDERS
        //add placeholder to searchbar
        String placeHolder = "What do I need to search?";
        tablePanel.getSearchBarPanel().getSearchBar().setText(placeHolder);
        tablePanel.getSearchBarPanel().getSearchBar().addMouseListener(new PlaceHolderListener(tablePanel.getSearchBarPanel().getSearchBar(), placeHolder));
        //add placeholder to amount input
        addTransactionPanel.getAmountField().setText("type amount");
        addTransactionPanel.getAmountField().addMouseListener(new PlaceHolderListener(addTransactionPanel.getAmountField()));
        //add placeholder to description input
        String descriptionPlaceholder = "type description";
        addTransactionPanel.getDescriptionField().setText(descriptionPlaceholder);
        addTransactionPanel.getDescriptionField().addMouseListener(new PlaceHolderListener(addTransactionPanel.getDescriptionField()));

        //ADD TRANSACTION
        //radio buttons transaction type
        TransactionTypeListener transactionTypeListener = new TransactionTypeListener();
        addTransactionPanel.getTransactionType().getIncome().addActionListener(transactionTypeListener);
        addTransactionPanel.getTransactionType().getOutcome().addActionListener(transactionTypeListener);
        //add transaction button
        AddTransactionListener addTransactionListener = new AddTransactionListener(addTransactionPanel, tablePanel, transactionTypeListener, descriptionPlaceholder, topPanel);
        addTransactionPanel.getAddDeletePanel().getAddButton().addActionListener(addTransactionListener);

        //DELETE TRANSACTION
        DeleteTransactionListener deleteTransactionListener = new DeleteTransactionListener(tablePanel.getTransactionTableModel(), topPanel);
        addTransactionPanel.getAddDeletePanel().getDeleteButton().addActionListener(deleteTransactionListener);

        //FILTERS
        //radio buttons date filter
        OtherFiltersListener radioFilterListener = new OtherFiltersListener(tablePanel, topPanel);
        topPanel.getOtherFilters().addActionListener(new OtherFiltersListener(tablePanel, topPanel));
        //show all transaction date filter
        topPanel.getShowAll().addActionListener(new ShowAllFilterListener(tablePanel, topPanel));
        //interval date filter
        topPanel.getFilter().addActionListener(new IntervalFilterListener(topPanel.getInitalDate(), topPanel.getFinalDate(), tablePanel, topPanel));

        //SHOW TRANSACTION TOTAL
        topPanel.getShowAmount().addMouseListener(new ShowTotalListener(topPanel));

        //EDIT TRANSACTION
        tablePanel.getTransactionTable().addMouseListener(new EditTransactionListener(tablePanel, topPanel));

        //MENUBAR
        //save option
        menuBarPanel.getMenuBar().getMenu(0).getItem(0).addActionListener(new SaveListener(tablePanel));
        //load option
        menuBarPanel.getMenuBar().getMenu(0).getItem(1).addActionListener(new LoadListener(tablePanel));
        //export as
        JMenu exportMenu = (JMenu)menuBarPanel.getMenuBar().getMenu(0).getItem(2);
        exportMenu.getItem(0).addActionListener(new ExporterListener(tablePanel));
        exportMenu.getItem(1).addActionListener(new ExporterListener(tablePanel));
        exportMenu.getItem(2).addActionListener(new ExporterListener(tablePanel));
        //print
        menuBarPanel.getMenuBar().getMenu(0).getItem(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (! tablePanel.getTransactionTable().print()) {
                        System.err.println("User cancelled printing");
                    }
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("Cannot print %s%n", e.getMessage());
                }

            }
        });

        //SEARCHBAR
        tablePanel.getSearchBarPanel().getSearchButton().addActionListener(new RowHighLighterListener(tablePanel));
    }
}
