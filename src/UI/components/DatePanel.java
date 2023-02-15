package UI.components;

import com.toedter.calendar.JDateChooser;
import model.components.HasAttributes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;

public class DatePanel extends JPanel implements HasAttributes {
    private JDateChooser dateChooser;

    public DatePanel () {
        dateChooser = new JDateChooser(new Date());
        setAttributes();

        this.add(dateChooser);
    }

    public void setAttributes() {
        dateChooser.getJCalendar().setPreferredSize(new Dimension(200, 200));
        dateChooser.setPreferredSize(new Dimension(175, 50));
        dateChooser.setFont(dateChooser.getFont().deriveFont(20F));
        dateChooser.getJCalendar().setFont(dateChooser.getFont().deriveFont(10f));
        dateChooser.setBorder(new LineBorder(Color.darkGray));
        this.setBackground(Color.gray);
    }

    public JDateChooser getDateChooser() {
        return dateChooser;
    }
}
