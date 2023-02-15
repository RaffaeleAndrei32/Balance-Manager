package model.components.exporters;

import UI.components.TablePanel;
import model.components.Transaction;

import java.io.*;

public class CSVExporter extends Exporter {

    public CSVExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws IOException {
        FileInputStream sourceFile = new FileInputStream(super.sourceFile.getPath());
        ObjectInputStream inputStream = new ObjectInputStream(sourceFile);

        FileOutputStream fout = new FileOutputStream(destinationFile);
        DataOutputStream outputStream = new DataOutputStream(fout);

        Transaction transaction;
        int comma = 44;
        int endLine = 10;

        try {
            while((transaction = (Transaction) inputStream.readObject()) != null) {
                outputStream.writeBytes(String.valueOf(transaction.getAmount()));
                outputStream.write(comma);
                outputStream.writeBytes(transaction.getDate().toString());
                outputStream.write(comma);
                outputStream.writeBytes(transaction.getDescription());
                outputStream.write(endLine);
            }
        } catch (EOFException e) {
        } catch (ClassNotFoundException e) {
        }

        inputStream.close();
        outputStream.close();

    }
}
