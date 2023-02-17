package model.components.exporters;

import UI.components.TablePanel;
import model.components.TransactionTableModel;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;

/**
 * @author Raffaele Andrei
 * Export to ODS
 */
public class ExcelExporter extends Exporter{
    public ExcelExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws IOException {
        // Save the data to an ODS file and open it.
        TransactionTableModel exportedModel;
        SpreadSheet.createEmpty(tablePanel.getTransactionTableModel()).saveAs(super.destinationFile);
    }
}
