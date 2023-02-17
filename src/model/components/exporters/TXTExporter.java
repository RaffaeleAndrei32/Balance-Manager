package model.components.exporters;

import UI.components.TablePanel;
import model.components.Transaction;

import java.io.*;

/**
 * @author Raffaele Andrei
 * Export to TXT
 */
public class TXTExporter extends Exporter {
    public TXTExporter(TablePanel tablePanel, File sourceFile, File destinationFile) {
        super(tablePanel, sourceFile, destinationFile);
    }

    @Override
    public void export() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(super.sourceFile.getPath());
        ObjectInputStream inputStream = new ObjectInputStream(fin);

        PrintWriter printWriter = new PrintWriter(new FileWriter(super.destinationFile));

        Transaction transaction;


        try {
            while((transaction = (Transaction) inputStream.readObject()) != null) {
                printWriter.print(transaction.getAmount());
                printWriter.print(" ");
                printWriter.print(transaction.getDate());
                printWriter.print(" ");
                printWriter.println(transaction.getDescription());
            }
        } catch (ClassNotFoundException | EOFException e) {
        }

        inputStream.close();
        printWriter.close();
    }
}
