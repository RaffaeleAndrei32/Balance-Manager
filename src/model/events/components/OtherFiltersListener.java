package model.events.components;

import UI.components.TablePanel;
import UI.components.TopPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class OtherFiltersListener implements ActionListener {
    private TablePanel tablePanel;
    private TopPanel topPanel;

    public OtherFiltersListener(TablePanel panel, TopPanel topPanel) {
        this.tablePanel = panel;
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JDateChooser dateChooser = new JDateChooser(new Date());
        JRadioButton day = new JRadioButton("day");
        JRadioButton week = new JRadioButton("week");
        JRadioButton month = new JRadioButton("month");
        JRadioButton year = new JRadioButton("year");

        ButtonGroup filterGroup = new ButtonGroup();
        filterGroup.add(day);
        filterGroup.add(week);
        filterGroup.add(month);
        filterGroup.add(year);

        FilterTypeListener filterTypeListener = new FilterTypeListener();
        day.addActionListener(filterTypeListener);
        week.addActionListener(filterTypeListener);
        month.addActionListener(filterTypeListener);
        year.addActionListener(filterTypeListener);

        Object[] data = new Object[]{"Date: ", dateChooser, "\nFilter for: ", day, week, month, year};

        int id = 0;
        id = JOptionPane.showConfirmDialog(null, data, "Choose date", -1);

        if (id == -1) return;

        while (dateChooser.getDate() == null || filterTypeListener.getType() == null) {
            id = JOptionPane.showConfirmDialog(null, data, "Choose date", -1);
            if (id == -1) return;
        }

        Date tmpDate;
        LocalDate inputDate;

        tmpDate = dateChooser.getDate();
        inputDate =  LocalDate.ofInstant(tmpDate.toInstant(), ZoneId.systemDefault());



        switch (filterTypeListener.getType()) {

            case "day" :
                tablePanel.getTableSorter().setRowFilter(null);
                RowFilter<TableModel, Integer> dayFilter = new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                        TableModel tableModel = entry.getModel();
                        LocalDate date = (LocalDate) tableModel.getValueAt(
                                entry.getIdentifier(), 1);

                        return inputDate.getDayOfYear() == date.getDayOfYear();
                    }
                };

                tablePanel.getTableSorter().setRowFilter(dayFilter);
                topPanel.getShowAmount().setText(tablePanel.totalOfTransactions() + "€");
                break;

            case "week" :
                tablePanel.getTableSorter().setRowFilter(null);
                RowFilter<TableModel, Integer> weekFilter = new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                        TableModel tableModel = entry.getModel();
                        LocalDate date = (LocalDate) tableModel.getValueAt(
                                entry.getIdentifier(), 1);
                        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();

                        return inputDate.get(woy) == date.get(woy);
                    }
                };

                tablePanel.getTableSorter().setRowFilter(weekFilter);
                topPanel.getShowAmount().setText(tablePanel.totalOfTransactions() + "€");
                break;

            case "month" :
                tablePanel.getTableSorter().setRowFilter(null);
                RowFilter<TableModel, Integer> monthFilter = new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                        TableModel tableModel = entry.getModel();
                        LocalDate date = (LocalDate) tableModel.getValueAt(
                                entry.getIdentifier(), 1);

                        return inputDate.getMonth() == date.getMonth();
                    }
                };

                tablePanel.getTableSorter().setRowFilter(monthFilter);
                topPanel.getShowAmount().setText(tablePanel.totalOfTransactions() + "€");
                break;

            case "year" :
                tablePanel.getTableSorter().setRowFilter(null);
                RowFilter<TableModel, Integer> yaerFilter = new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                        TableModel tableModel = entry.getModel();
                        LocalDate date = (LocalDate) tableModel.getValueAt(
                                entry.getIdentifier(), 1);

                        return inputDate.getYear() == date.getYear();
                    }
                };

                tablePanel.getTableSorter().setRowFilter(yaerFilter);
                topPanel.getShowAmount().setText(tablePanel.totalOfTransactions() + "€");
                break;
        }
    }
}

