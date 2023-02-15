package model.components.exporters;

import UI.components.TablePanel;

import java.io.File;
import java.io.IOException;

public abstract class Exporter {
    protected TablePanel tablePanel;
    protected File destinationFile;
    protected File sourceFile;

    public Exporter (TablePanel tablePanel, File sourceFile, File destinationFile) {
        this.tablePanel = tablePanel;
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
    }

    protected abstract void export() throws IOException;
}
