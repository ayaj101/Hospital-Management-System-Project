package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Pending_Amount extends JFrame {
    JTable table;
    JTextField nameField;
    JComboBox<String> statusBox;

    Pending_Amount() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(16, 70, 75));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setBackground(new Color(16, 70, 75));
        table.setForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 870, 400);
        panel.add(scrollPane);



        // Name search field
        JLabel nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(10, 10, 100, 25);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 25);
        panel.add(nameField);

        // Status filter
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(290, 10, 80, 25);
        statusLabel.setForeground(Color.WHITE);
        panel.add(statusLabel);

        statusBox = new JComboBox<>(new String[]{"All", "Pending", "Paid"});
        statusBox.setBounds(360, 10, 150, 25);
        panel.add(statusBox);

        // Search button
        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(530, 10, 120, 25);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        panel.add(searchButton);

        // Back button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(450, 510, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        backButton.addActionListener(e -> setVisible(false));
        searchButton.addActionListener(e -> searchPendingAmounts());

        // Load default data
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
            String q = "SELECT patient_id AS 'Patient ID', name AS 'Name', total_bill AS 'Total Bill', amount_paid AS 'Paid', (total_bill - amount_paid) AS 'Pending' FROM Billing";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchPendingAmounts() {
        String name = nameField.getText().trim();
        String status = statusBox.getSelectedItem().toString();

        try {
            Conn c = new Conn();
            String q = "SELECT patient_id AS 'Patient ID', name AS 'Name', total_bill AS 'Total Bill', amount_paid AS 'Paid', (total_bill - amount_paid) AS 'Pending' FROM Billing WHERE 1=1";

            if (!name.isEmpty()) {
                q += " AND name LIKE '%" + name + "%'";
            }

            if (!status.equals("All")) {
                if (status.equals("Pending")) {
                    q += " AND (total_bill - amount_paid) > 0";
                } else if (status.equals("Paid")) {
                    q += " AND (total_bill - amount_paid) = 0";
                }
            }

            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pending_Amount();
    }
}
