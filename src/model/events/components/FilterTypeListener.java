package model.events.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterTypeListener implements ActionListener {
    private String type;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.type = actionEvent.getActionCommand();
    }

    public String getType () {
        return this.type;
    }
}
