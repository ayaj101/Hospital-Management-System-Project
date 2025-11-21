package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField textField;

    JPasswordField jPasswordField;

    JButton b1,b2 ;

    Login(){
        // Welcome Label
        JLabel welcomeLabel = new JLabel("WELCOME TO LIFE LINE HEALTH CARE HOSPITAL", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE); // or a light teal
        welcomeLabel.setBounds(100, 20, 600, 30); // Adjust position and size
        add(welcomeLabel);



    // Username
    JLabel namelabel = new JLabel("Username");
    namelabel.setBounds(40,70,100,30);
    namelabel.setFont(new Font("Tahoma", Font.BOLD,16 ));
    namelabel.setForeground(Color.WHITE);
    add(namelabel);

    // Password
    JLabel password = new JLabel("Password");
    password.setBounds(40,120,100,30);
    password.setFont(new Font("Tahoma", Font.BOLD,16 ));
    password.setForeground(Color.WHITE);
    add(password);

    // Text Field
    textField=new JTextField();
    textField.setBounds(150,70,150,30);
    textField.setFont(new Font("Tahoma",Font.PLAIN,15));
    textField.setBackground(new Color(102,204,195));
    add(textField);

    // Password Field
    jPasswordField = new JPasswordField();
    jPasswordField.setBounds(150,120,150,30);
    jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
    jPasswordField.setBackground(new Color(102,204,195));
    add(jPasswordField);

    //Image
    ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
    Image i1 = imageIcon.getImage().getScaledInstance(300,175,Image.SCALE_DEFAULT);
    ImageIcon imageIcon1 = new ImageIcon(i1);
    JLabel label = new JLabel(imageIcon1);
    label.setBounds(320,-28,400,300);
    add(label);

    // Login Button
    b1 = new JButton("Login");
    b1.setBounds(40,180,120,30);
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.setBackground(new Color(224,247,250));
    b1.setForeground(Color.black);
    b1.addActionListener(this);
    add(b1);


    // Cancel Button
    b2 = new JButton("Cancel");
    b2.setBounds(180,180,120,30);
    b2.setFont(new Font("serif",Font.BOLD,15));
    b2.setBackground(new Color(224,247,250));
    b2.setForeground(Color.black);
    b2.addActionListener(this);
    add(b2);

        JLabel forgotLabel = new JLabel("<HTML><U>Forgot Password?</U></HTML>");
        forgotLabel.setBounds(150, 220, 200, 20);
        forgotLabel.setForeground(Color.YELLOW);
        forgotLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(forgotLabel);

        forgotLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ForgotPasswordWindow(); // create this class
                setVisible(false);
            }
        });



        getContentPane().setBackground(new Color(16,70,75));
    setSize(750,300);
    setLocation(400,270);
    setLayout(null);
    setVisible(true);
    }






    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            try{
                Conn c = new Conn();
                String user = textField.getText();
                String password = jPasswordField.getText();

                String q = "select * from login where ID = '"+user+"' and  PW = '"+password+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            System.exit(10);
        }
    }
    public static void main(String[] args) {
        new Login();

    }


}
