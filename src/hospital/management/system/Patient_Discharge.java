package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class Patient_Discharge extends JFrame {


    HashMap<String, String> nameToId = new HashMap<>();
    HashMap<String, String> idToName = new HashMap<>();
    JButton pay; // Global declaration



    Patient_Discharge(){


        JPanel panel =new JPanel();
        panel.setBounds(5,5,680,450);
        panel.setBackground(new Color(16,70,75));
        panel.setLayout(null);
        add(panel);


        JLabel label = new JLabel("CHECK-OUT PATIENT...!");
        label.setBounds(100,20,280,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);


        JLabel label6 = new JLabel("CUSTOMER NAME :");
        label6.setBounds(30,80,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        Choice choice1 = new Choice();
        choice1.setBounds(200,80,150,25);
        panel.add(choice1);



        JLabel label2 = new JLabel("CUSTOMER ID :");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,130,150,25);
        panel.add(choice);


        // Fill choices and map data
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String number = resultSet.getString("Number");

                nameToId.put(name, number);
                idToName.put(number, name);

                choice1.add(name);
                choice.add(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Synchronize ID when Name is selected
        choice1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedName = choice1.getSelectedItem();
                String correspondingId = nameToId.get(selectedName);
                choice.select(correspondingId);
            }
        });

        // Synchronize Name when ID is selected
        choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedId = choice.getSelectedItem();
                String correspondingName = idToName.get(selectedId);
                choice1.select(correspondingName);
            }
        });



        JLabel label3 = new JLabel("ROOM NUMBER :");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,180,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label4 = new JLabel("CHECK IN TIME :");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,230,230,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label5 = new JLabel("CHECK OUT TIME :");
        label5.setBounds(30,280,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(200,280,230,20);
        OutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OutTime.setForeground(Color.WHITE);
        panel.add(OutTime);

        JLabel label7 = new JLabel("PAINDING_AMOUNT :");
        label7.setBounds(30,320,200,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel Panding_AMT = new JLabel();
        Panding_AMT.setBounds(200,320,230,20);
        Panding_AMT.setFont(new Font("Tahoma",Font.BOLD,14));
        Panding_AMT.setForeground(Color.WHITE);
        panel.add(Panding_AMT);

        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(30,360,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pendingAmtStr = Panding_AMT.getText().trim();
                    if (pendingAmtStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please click CHECK button first to fetch patient data.");
                        return;
                    }

                    double pendingAmt = Double.parseDouble(pendingAmtStr);
                    if (pendingAmt > 0) {
                        JOptionPane.showMessageDialog(null, "Pay pending amount for discharge!\nPending Amount: ₹" + pendingAmt);
                        return;
                    }

                    Conn c = new Conn();
                    String patientID = choice.getSelectedItem();

                    // First fetch updated billing values
                    ResultSet rs = c.statement.executeQuery("SELECT total_bill, amount_paid FROM Billing WHERE patient_id = '" + patientID + "'");
                    int totalBill = 0;
                    int amountPaid = 0;
                    if (rs.next()) {
                        totalBill = rs.getInt("total_bill");
                        amountPaid = rs.getInt("amount_paid");
                    }

                    // Update Patient_History before deleting
                    String updateHistory = "UPDATE Patient_History SET discharge_time = NOW(), total_bill = " + totalBill +
                            ", amount_paid = " + amountPaid + ", status = 'Discharged', remarks = 'Discharged Successfully' " +
                            "WHERE patient_id = '" + patientID + "' AND status = 'Admitted'";
                    c.statement.executeUpdate(updateHistory);

                    // Free the room
                    c.statement.executeUpdate("UPDATE Room SET Availability = 'Availabil' WHERE Room_Number = '" + RNo.getText() + "'");

                    // Delete patient record
                    c.statement.executeUpdate("DELETE FROM patient_info WHERE number = '" + patientID + "'");
                    c.statement.executeUpdate("DELETE FROM Billing WHERE patient_id = '" + patientID + "'");

                    JOptionPane.showMessageDialog(null, "DISCHARGE SUCCESSFULLY...\nMAY GOD BLESS YOU. STAY HEALTHY!");
                    setVisible(false);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Invalid pending amount value.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });




        JButton check = new JButton("CHECK");
        check.setBounds(170,360,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number ='"+choice.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        RNo.setText(resultSet.getString("Room_No"));
                        INTime.setText(resultSet.getString("Time"));
                        Panding_AMT.setText(resultSet.getString("Pending_Amount"));


                    }

                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(300,360,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add( back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        pay = new JButton("PAYMENT");
        pay.setBounds(430, 360, 120, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setVisible(false); // Initially hidden
        panel.add(pay);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pendingStr = Panding_AMT.getText().trim();
                    if (pendingStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Click CHECK to view pending amount first.");
                        return;
                    }

                    double pending = Double.parseDouble(pendingStr);
                    if (pending <= 0) {
                        JOptionPane.showMessageDialog(null, "No payment due.");
                        pay.setVisible(false);
                        return;
                    }

                    Conn c = new Conn();
                    String patientID = choice.getSelectedItem();

                    // Update Billing
                    c.statement.executeUpdate("UPDATE Billing SET amount_paid = total_bill WHERE patient_id = '" + patientID + "'");

                    // Fetch updated billing values
                    ResultSet rs = c.statement.executeQuery("SELECT total_bill, amount_paid FROM Billing WHERE patient_id = '" + patientID + "'");
                    int totalBill = 0;
                    int amountPaid = 0;
                    if (rs.next()) {
                        totalBill = rs.getInt("total_bill");
                        amountPaid = rs.getInt("amount_paid");
                    }

                    // Update Patient_History
                    Date now = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dischargeTime = sdf.format(now);

                    String historyUpdate = "UPDATE Patient_History SET discharge_time = '" + dischargeTime +
                            "', total_bill = " + totalBill +
                            ", amount_paid = " + amountPaid +
                            ", status = 'Discharged', remarks = 'Patient Discharged (Payment)' " +
                            "WHERE patient_id = '" + patientID + "' AND status = 'Admitted'";
                    c.statement.executeUpdate(historyUpdate);

                    // Clear pending in patient_info
                    c.statement.executeUpdate("UPDATE patient_info SET Pending_Amount = 0 WHERE Number = '" + patientID + "'");

                    JOptionPane.showMessageDialog(null, "Payment Successful! Pending amount Paid Successfully.");
                    Panding_AMT.setText("0.0");
                    pay.setVisible(false); // Hide after payment
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number ='" + choice.getSelectedItem() + "'");
                    if (resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_No"));
                        INTime.setText(resultSet.getString("Time"));
                        String amtStr = resultSet.getString("Pending_Amount");
                        Panding_AMT.setText(amtStr);

                        double amt = Double.parseDouble(amtStr);
                        pay.setVisible(amt > 0); // Show pay button only if amount > 0
                    } else {
                        pay.setVisible(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setSize(690,460);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
     new Patient_Discharge();
    }
}
