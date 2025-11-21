package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    JTable table;
    JTextField locationField;
    JComboBox<String> availabilityBox;

    Ambulance() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(16, 70, 75));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setBounds(10, 100, 870, 400);
        table.setBackground(new Color(16, 70, 75));
        table.setForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        JLabel label1 = new JLabel("Name");
        label1.setBounds(10, 75, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(195, 75, 100, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel label3 = new JLabel("Car name");
        label3.setBounds(370, 75, 100, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(550, 75, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(730, 75, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        // Location field
        JLabel locLabel = new JLabel("Location:");
        locLabel.setBounds(10, 10, 80, 25);
        locLabel.setForeground(Color.WHITE);
        panel.add(locLabel);

        locationField = new JTextField();
        locationField.setBounds(90, 10, 150, 25);
        panel.add(locationField);

        // Availability dropdown
        JLabel availLabel = new JLabel("Available:");
        availLabel.setBounds(260, 10, 80, 25);
        availLabel.setForeground(Color.WHITE);
        panel.add(availLabel);

        availabilityBox = new JComboBox<>(new String[]{"All", "Available", "Not Available"});
        availabilityBox.setBounds(340, 10, 150, 25);
        panel.add(availabilityBox);

        // Search Button
        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(510, 10, 120, 25);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        panel.add(searchButton);

        // Back Button
        JButton button = new JButton("BACK");
        button.setBounds(450, 510, 120, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);

        button.addActionListener(e -> setVisible(false));

        searchButton.addActionListener(e -> searchAmbulance());

        // Load initial data
        loadTable();

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    public void loadTable() {
        try {
            Conn c = new Conn();
            String q = "SELECT * FROM Ambulence";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchAmbulance() {
        String location = locationField.getText().trim();
        String availability = availabilityBox.getSelectedItem().toString();

        try {
            Conn c = new Conn();
            String q = "SELECT * FROM Ambulence WHERE 1=1";

            if (!location.isEmpty()) {
                q += " AND Location LIKE '%" + location + "%'";
            }

            if (!availability.equals("All")) {
                q += " AND Available = '" + availability + "'";
            }

            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
