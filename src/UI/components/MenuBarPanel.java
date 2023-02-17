package UI.components;

import javax.swing.*;

/**
 * @author Raffaele Andrei
 * Panel for the Menu
 */
public class MenuBarPanel extends JPanel {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem load;
    private JMenu exportAs;
    private JMenuItem csv;
    private JMenuItem text;
    private JMenuItem excel;
    private JMenuItem print;

    public MenuBarPanel () {
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        save = new JMenuItem("Save to");
        load = new JMenuItem("Load from");
        print = new JMenuItem("Print");

        exportAs = new JMenu("Export as");
        csv = new JMenuItem("csv");
        text = new JMenuItem("txt");
        excel = new JMenuItem("excel");

        menu.add(save);
        menu.add(load);
        menu.add(exportAs);
        menu.add(print);

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
