package model.events.manager;

import UI.components.AddTransactionPanel;
import UI.components.TablePanel;
import UI.components.TopPanel;
import model.events.components.*;

public class EventManager {
    private TopPanel topPanel;
    private TablePanel tablePanel;
    private AddTransactionPanel addTransactionPanel;

    public EventManager(TopPanel top, TablePanel tablep, AddTransactionPanel addp) {
        this.topPanel = top;
        this.tablePanel = tablep;
        this.addTransactionPanel = addp;


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


        //ADDING AND DELETING TRANSACTIONS
        //radio buttons transaction type
        TransactionTypeListener transactionTypeListener = new TransactionTypeListener();
        addTransactionPanel.getTransactionType().getIncome().addActionListener(transactionTypeListener);
        addTransactionPanel.getTransactionType().getOutcome().addActionListener(transactionTypeListener);
        //add transaction button
        AddTransactionListener addTransactionListener = new AddTransactionListener(addTransactionPanel, tablePanel, transactionTypeListener, descriptionPlaceholder, topPanel);
        addTransactionPanel.getAddDeletePanel().getAddButton().addActionListener(addTransactionListener);
        //delete transaction button
        DeleteTransactionListener deleteTransactionListener = new DeleteTransactionListener(tablePanel.getTransactionTableModel(), tablePanel, topPanel);
        addTransactionPanel.getAddDeletePanel().getDeleteButton().addActionListener(deleteTransactionListener);


        //FILTERS
        //radio buttons date filter
        OtherFiltersListener radioFilterListener = new OtherFiltersListener(tablePanel, topPanel);
        topPanel.getOtherFilters().addActionListener(new OtherFiltersListener(tablePanel, topPanel));
        //show all transaction date filter
        topPanel.getShowAll().addActionListener(new ShowAllFilterListener(tablePanel, topPanel));
        //interval date filter
        topPanel.getFilter().addActionListener(new IntervalFilterListener(topPanel.getInitalDate(), topPanel.getFinalDate(), tablePanel, topPanel));


        top.getShowAmount().addMouseListener(new ShowTotalListener(topPanel));
    }
}
