package model.components.exporters;

import UI.components.TablePanel;

import java.io.File;
import java.io.FileNotFoundException;

public class TXTExporter extends Exporter {
    public TXTExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws FileNotFoundException {

    }
}
