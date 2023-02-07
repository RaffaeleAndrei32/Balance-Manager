package model.events.components;

import UI.components.TablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showAllFilterListener implements ActionListener {
    private TablePanel tablePanel;

    public showAllFilterListener (TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tablePanel.getTableSorter().setRowFilter(null);
    }
}
