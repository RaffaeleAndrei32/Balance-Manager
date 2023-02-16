package model.components.exporters;

import UI.components.TablePanel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;

public class ExcelExporter extends Exporter{
    public ExcelExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws IOException {
        // Save the data to an ODS file and open it.
        SpreadSheet.createEmpty(tablePanel.getTransactionTableModel()).saveAs(super.destinationFile);

        OOUtils.open(super.destinationFile);
    }
}
