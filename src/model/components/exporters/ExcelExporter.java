package model.components.exporters;

import UI.components.TablePanel;

import java.io.File;
import java.io.IOException;

public class ExcelExporter extends Exporter{
    public ExcelExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws IOException {

    }
}
