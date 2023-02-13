package model.events.components;

import UI.components.TablePanel;
import UI.components.TopPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowAllFilterListener implements ActionListener {
    private TablePanel tablePanel;
    private TopPanel topPanel;

    public ShowAllFilterListener(TablePanel tablePanel, TopPanel topPanel) {
        this.tablePanel = tablePanel;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            tablePanel.getTableSorter().setRowFilter(null);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        topPanel.updateTotal();
    }
}
