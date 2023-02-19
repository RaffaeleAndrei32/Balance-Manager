package model.components;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Raffaele Andrei
 * Representation of transaction
 */
public class Transaction implements Serializable {
    static private int ID_BASE = 0;
    private int ID;
    private LocalDate date;
    private String description;
    private double amount;
    private boolean positive;
    private static final DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
    public Transaction () {
        this.ID = ID_BASE++;
        this.date = LocalDate.now();
        this.description = "";
        this.amount = 0f;
        this.positive = true;
    }

    public Transaction (LocalDate date, double amount, String description, boolean state) {
        this.ID = ID_BASE++;
        this.date = date;
        this.description = description;
        this.positive = state;
        this.amount = Double.parseDouble(df.format(amount));
        if (!state)
            this.amount = -(this.amount);
    }

    public static int getIdBase() {
        return ID_BASE;
    }

    public static void setIdBase(int idBase) {
        ID_BASE = idBase;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    @Override
    public String toString() {
        return this.description + " " +
                String.valueOf(this.amount) + " " +
                this.date.toString();

    }
}
