package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {

    All_Patient_Info(){

        JPanel panel =new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(16,70,75));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBackground(new Color(16,70,75));
        table.setFont(new Font("Arial",Font.PLAIN,12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 34, 950, 300);

        table.setForeground(Color.WHITE);
        panel.add(scrollPane);

        try{
            Conn c = new Conn();
            String q ="Select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icon/welcome_line.png"));
        Image image = logo.getImage().getScaledInstance(500,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2= new ImageIcon(image);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(150,300,500,250);
        panel.add(label);

        JButton b1 = new JButton("BACK");
        b1.setBounds(750,490,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
      new All_Patient_Info();
    }
}
