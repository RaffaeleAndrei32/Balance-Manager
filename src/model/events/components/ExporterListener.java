package model.events.components;

import UI.components.TablePanel;
import model.components.exporters.CSVExporter;
import model.components.exporters.ExcelExporter;
import model.components.exporters.TXTExporter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ExporterListener implements ActionListener {
    private TablePanel tablePanel;

    public ExporterListener (TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser((new File(".")).getAbsolutePath());
        int id = fileChooser.showSaveDialog(null);

        File saveFile;
        if (id == 0)
            saveFile = fileChooser.getSelectedFile();
        else
            return;

        switch (actionEvent.getActionCommand()) {
            case "csv" :
                if (!saveFile.getName().endsWith(".csv")) {
                    JOptionPane.showMessageDialog(null, "The selected file is not a CSV file, please choose another one.", "File type error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CSVExporter csvExporter = new CSVExporter(tablePanel, tablePanel.getTransactionTableModel().getTargetFile(), saveFile);
                try {
                    csvExporter.export();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "text" :
                if (!saveFile.getName().endsWith(".txt")) {
                    JOptionPane.showMessageDialog(null, "The selected file is not a TXT file, please choose another one.", "File type error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TXTExporter txtExporter = new TXTExporter(tablePanel, tablePanel.getTransactionTableModel().getTargetFile(), saveFile);
                try {
                    txtExporter.export();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "excel" :
                if (!saveFile.getName().endsWith(".xlsx")) {
                    JOptionPane.showMessageDialog(null, "The selected file is not a XLSX file, please choose another one.", "File type error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ExcelExporter excelExporter = new ExcelExporter(tablePanel, tablePanel.getTransactionTableModel().getTargetFile(), saveFile);
                try {
                    excelExporter.export();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

        JOptionPane.showMessageDialog(null, "All the transactions have been exported in " + saveFile.getPath() + " successfully!", "Successful operation", JOptionPane.PLAIN_MESSAGE);
    }
}
