package model.events.components;

import UI.components.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Raffaele Andrei
 * Calls transactionTableModel.laod()
 */
public class LoadListener implements ActionListener {
    private TablePanel tablePanel;

    public LoadListener (TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser((new File(".")).getAbsolutePath());
        int id = fileChooser.showDialog(null, "load");

        if (id == 0) {
            File loadFile = fileChooser.getSelectedFile();

            try {
                //this.tablePanel.getTableSorter().setRowFilter(null);
                this.tablePanel.getTransactionTableModel().load(loadFile);
                this.tablePanel.getTableSorter().setRowFilter(null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File type not valid, choose another file!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException e) {
                System.out.println("cln");
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Empty file loaded!");
            }
        }
    }
}
