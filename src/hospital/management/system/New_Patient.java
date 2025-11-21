package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Formattable;
import java.util.Stack;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox combobox;

    JTextField textFieldNumber , textName, textFieldDisease, textFieldDeposite;

    JRadioButton r1, r2;

    Choice c1;

    JLabel date;

    JButton b1, b2;


    New_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(16,70,75));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,190,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Times New Roman",Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        combobox = new JComboBox(new String[]{"SELECT","Aadhar Card","Voter ID","Driving License","Pan Card"});
        combobox.setBounds(271,73,150,25);
        combobox.setBackground(new Color(90,156,163));
        combobox.setForeground(Color.WHITE);
        combobox.setFont(new Font("Times New Roman",Font.BOLD,14));
        panel.add(combobox);


        JLabel labelNumber = new JLabel("Customer_ID/Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);


        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);



        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);


        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);


        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,82,15);
        panel.add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);




        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);


        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);


        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT Room_Number FROM Room WHERE Availability = 'Availabil'");
            while (resultSet.next()){
                c1.add(resultSet.getString("Room_Number"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,300,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);


        JLabel labelDate = new JLabel("Date & Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // MySQL DATETIME format
        String formattedDate = sdf.format(date1);
        date = new JLabel(formattedDate);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,17);
        labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);


        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);



        b2 = new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            Conn c = new Conn();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN="MALE";
            }
            else if(r2.isSelected()){
                radioBTN="FEMALE";
            }

        String s1 = (String) combobox.getSelectedItem();
        String s2 = textFieldNumber.getText();
        String s3 = textName.getText();
        String s4 = radioBTN;
        String s5 = textFieldDisease.getText();
        String s6 = c1.getSelectedItem();
        String s7 = date.getText();
        String s8 = textFieldDeposite.getText();

            if(s1.equals("SELECT") || s2.isEmpty() || s3.isEmpty() || s4 == null || s5.isEmpty() || s6 == null || s8.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory. Please fill out the form completely.");
                return;
            }

            int depositedAmount = Integer.parseInt(s8);
            int roomPrice = 0;

            try {
                ResultSet rs = c.statement.executeQuery("SELECT Price FROM Room WHERE Room_Number = '" + s6 + "'");
                if (rs.next()) {
                    roomPrice = Integer.parseInt(rs.getString("Price"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            int pendingAmount = roomPrice - depositedAmount;




            try{
                String q = "insert into patient_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + pendingAmount + "','"+roomPrice+"')";
                String q1 = "update Room set Availability = 'Occupied' where Room_Number = '" + s6 + "'";
                String billingQuery = "INSERT INTO Billing (patient_id, name, total_bill, amount_paid) " +
                        "VALUES ('" + s2 + "', '" + s3 + "', " + roomPrice + ", " + depositedAmount + ")";


                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(billingQuery);
                String historyQuery = "INSERT INTO Patient_History (patient_id, name, gender, disease, room_no, admission_time, total_bill, amount_paid, status, remarks) " +
                        "VALUES ('" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', " + roomPrice + ", " + depositedAmount + ", 'Admitted', 'Patient Admitted')";
                c.statement.executeUpdate(historyQuery);
                if (pendingAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "✅ Thank you for Payment\n🙏 MAY GOD BLESS YOU\n💖 I hope and pray that you stay healthy in the future.");
                } else {
                    JOptionPane.showMessageDialog(null, "Added Successfully.\nPending Amount: ₹" + pendingAmount);
                }

            setVisible(false);
        }
        catch (Exception E){
            E.printStackTrace();
        }

        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
    new New_Patient();
    }


}
