package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

        JTable table;

    Room(){




        JPanel panel = new JPanel();
        panel.setBounds(5,5,850,550);
        panel.setBackground(new Color(16,70,75));
        panel.setLayout(null);
        add(panel);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icon/hospital-logo.png"));
        Image image = logo.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2= new ImageIcon(image);
        JLabel label = new JLabel(imageIcon2);
        label.setBounds(550,-20,300,300);
        panel.add(label);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image1 = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(image1);
        JLabel logolable = new JLabel(imageIcon1);
        logolable.setBounds(550,250,300,300);
        panel.add(logolable);




        table = new JTable();

        table.setBackground(new Color(16,70,75));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 500, 400);

        table.setForeground(Color.WHITE);
        panel.add(scrollPane);


        try {

            Conn c = new Conn();
            String q ="select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Room();
    }




}
