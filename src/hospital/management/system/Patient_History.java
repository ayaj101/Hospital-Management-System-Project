package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Patient_History extends JFrame {
    JTable table;
    JTextField searchField;
    JRadioButton idRadio, nameRadio;

    Patient_History() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(16, 70, 75));
        panel.setBounds(5, 5, 980, 580);
        add(panel);

        JLabel heading = new JLabel("Patient History");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(400, 10, 300, 30);
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(30, 50, 60, 25);
        searchLabel.setForeground(Color.WHITE);
        panel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(90, 50, 150, 25);
        panel.add(searchField);

        idRadio = new JRadioButton("By ID");
        idRadio.setBounds(260, 50, 70, 25);
        idRadio.setBackground(new Color(16, 70, 75));
        idRadio.setForeground(Color.WHITE);
        panel.add(idRadio);

        nameRadio = new JRadioButton("By Name");
        nameRadio.setBounds(330, 50, 100, 25);
        nameRadio.setBackground(new Color(16, 70, 75));
        nameRadio.setForeground(Color.WHITE);
        panel.add(nameRadio);

        ButtonGroup bg = new ButtonGroup();
        bg.add(idRadio);
        bg.add(nameRadio);
        idRadio.setSelected(true); // default

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(440, 50, 100, 25);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        panel.add(searchButton);

        table = new JTable();
        table.setBackground(new Color(16, 70, 75));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 90, 940, 420);
        panel.add(scrollPane);

        // Load all history initially
        loadPatientHistory("");

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim();
            if (!searchText.isEmpty()) {
                if (idRadio.isSelected()) {
                    loadPatientHistory("WHERE patient_id LIKE '%" + searchText + "%'");
                } else if (nameRadio.isSelected()) {
                    loadPatientHistory("WHERE name LIKE '%" + searchText + "%'");
                }
            } else {
                loadPatientHistory("");
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(420, 530, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));

        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);
    }

    private void loadPatientHistory(String filterClause) {
        try {
            Conn c = new Conn();
            String q = "SELECT patient_id AS 'Patient ID', name AS 'Name', gender AS 'Gender', disease AS 'Disease', " +
                    "room_no AS 'Room', admission_time AS 'Admission', discharge_time AS 'Discharge', " +
                    "total_bill AS 'Total Bill', amount_paid AS 'Paid', status AS 'Status', remarks AS 'Remarks' " +
                    "FROM Patient_History " + filterClause;
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Patient_History();
    }
}
