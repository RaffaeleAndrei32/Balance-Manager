package UI.components;

import javax.swing.*;

public class MenuBarPanel extends JPanel {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem load;
    private JMenu exportAs;
    private JMenuItem csv;
    private JMenuItem text;
    private JMenuItem excel;

    public MenuBarPanel () {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        save = new JMenuItem("Save to");
        load = new JMenuItem("Load from");

        exportAs = new JMenu("Export as");
        csv = new JMenuItem("csv");
        text = new JMenuItem("txt");
        excel = new JMenuItem("excel");

        menu.add(save);
        menu.add(load);
        menu.add(exportAs);

        exportAs.add(csv);
        exportAs.add(excel);
        exportAs.add(text);

        menuBar.add(menu);

        this.add(menuBar);
    }

    public JMenuBar getMenuBar() {
        return this.menuBar;
    }
}
