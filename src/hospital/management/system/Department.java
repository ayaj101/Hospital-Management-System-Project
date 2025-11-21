package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(16,70,75));
        add(panel);

        JTable table = new JTable();
        table.setBackground(new Color(16,70,75));
        table.setFont(new Font("Arial",Font.PLAIN,16));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 650, 250);

        table.setForeground(Color.WHITE);
        panel.add(scrollPane);

        try {
            Conn c = new Conn();
            String q ="Select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }
        catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icon/welcome_line.png"));
        Image image = logo.getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2= new ImageIcon(image);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(150,300,300,150);
        panel.add(label);

        JButton b1 = new JButton("BACK");
        b1.setBounds(520,440,130,30);
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
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }
    public static void main(String[] args) {
    new Department();
    }
}
