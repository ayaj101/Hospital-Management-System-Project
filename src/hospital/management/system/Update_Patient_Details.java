package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Patient_Details extends JFrame {

    Update_Patient_Details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(16,70,75));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);



        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try {
        Conn c = new Conn();
        ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
        while (resultSet.next()) {
            choice.add(resultSet.getString("Name"));
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25,174,150,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,174,140,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25,261,150,18);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info WHERE Name='" + name + "'";
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_No"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                        int totalAmount = resultSet.getInt("Total_Amount");
                        int deposit = resultSet.getInt("Deposite");
                        int pending = totalAmount - deposit;
                        textFieldPending.setText(String.valueOf(pending));
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    Conn c = new Conn();
                    String name = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    int deposit = Integer.parseInt(textFieldAmount.getText());

                    // Get total amount from DB
                    String query = "SELECT Total_Amount FROM patient_info WHERE Name='" + name + "'";
                    ResultSet rs = c.statement.executeQuery(query);
                    int totalAmount = 0;
                    if (rs.next()) {
                        totalAmount = rs.getInt("Total_Amount");
                    }

                    int pending = totalAmount - deposit;
                    textFieldPending.setText(String.valueOf(pending)); // Update UI

                    // Update DB
                    String updateQuery = "UPDATE patient_info SET Room_No='" + room + "', Time='" + time +
                            "', Deposite='" + deposit + "', Pending_Amount='" + pending + "' WHERE Name='" + name + "'";
                    c.statement.executeUpdate(updateQuery);

                    String billingUpdate = "UPDATE Billing SET amount_paid = " + deposit + ", total_bill = " + totalAmount +
                            " WHERE patient_id = (SELECT Number FROM patient_info WHERE Name='" + name + "')";
                    c.statement.executeUpdate(billingUpdate);

                    // Update Patient_History table too
                    String historyUpdate = "UPDATE Patient_History SET total_bill = " + totalAmount +
                            ", amount_paid = " + deposit +
                            ", remarks = 'Patient Billing Updated' " +
                            "WHERE patient_id = (SELECT Number FROM patient_info WHERE Name='" + name + "') AND status = 'Admitted'";
                    c.statement.executeUpdate(historyUpdate);


                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });



        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(950,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
