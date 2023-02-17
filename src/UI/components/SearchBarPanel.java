package UI.components;

import model.components.HasAttributes;

import javax.swing.*;
import java.awt.*;

/**
 * @author Raffaele Andrei
 * Panel for search bar
 */
public class SearchBarPanel extends JPanel implements HasAttributes {
    private JTextField searchBar;
    private JButton searchButton;

    public SearchBarPanel() {
        searchBar = new JTextField("type a description");
        searchButton = new JButton("Search");
        setAttributes();

        this.add(searchButton, BorderLayout.WEST);
        this.add(searchBar, BorderLayout.CENTER);
    }

    public void setAttributes() {
        this.setLayout(new BorderLayout());

        searchBar.setPreferredSize(new Dimension(searchBar.getWidth(), 40));
        searchBar.setFont(searchBar.getFont().deriveFont(17f));

        searchButton.setPreferredSize(new Dimension(100, 25));
        searchButton.setFont(searchBar.getFont().deriveFont(17f));

        this.setPreferredSize(new Dimension(this.getWidth(),40));
    }

    public JTextField getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(JTextField searchBar) {
        this.searchBar = searchBar;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }
}
