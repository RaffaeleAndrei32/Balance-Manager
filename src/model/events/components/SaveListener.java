package model.events.components;

import UI.components.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SaveListener implements ActionListener {
    private TablePanel tablePanel;

    public SaveListener(TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean error= true;

        JFileChooser fileChooser = new JFileChooser((new File(".")).getAbsolutePath());
        int id = fileChooser.showSaveDialog(null);

        if (id == 0) {
            File saveFile = fileChooser.getSelectedFile();

            if (saveFile.exists()) {
                id = JOptionPane.showConfirmDialog(null, "Overwrite file?");
                System.out.println(id);

                if (id == 0) {
                    try {
                        this.tablePanel.getTransactionTableModel().save(saveFile);
                    } catch (IOException e) {
                    }
                }
            }
            else {
                try {
                    this.tablePanel.getTransactionTableModel().save(saveFile);
                } catch (IOException e) {
                }
            }
        }
    }
}
