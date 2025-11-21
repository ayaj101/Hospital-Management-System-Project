package hospital.management.system;



import javax.swing.*;
import java.awt.event.*;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForgotPasswordWindow extends JFrame {

    JTextField emailField, otpField, newPasswordField;

    public ForgotPasswordWindow() {
        setLayout(null);

        JLabel emailLabel = new JLabel("Enter Email:");
        emailLabel.setBounds(30, 30, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 30, 200, 30);
        add(emailField);

        JButton sendOtp = new JButton("Send OTP");
        sendOtp.setBounds(150, 70, 100, 30);
        add(sendOtp);

        sendOtp.addActionListener(e -> {
            try {
                sendPost("http://localhost:8080/api/send-otp", "email=" + emailField.getText());
                JOptionPane.showMessageDialog(null, "OTP sent to email");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JLabel otpLabel = new JLabel("Enter OTP:");
        otpLabel.setBounds(30, 120, 100, 30);
        add(otpLabel);

        otpField = new JTextField();
        otpField.setBounds(150, 120, 200, 30);
        add(otpField);

        JLabel newPassLabel = new JLabel("New Password:");
        newPassLabel.setBounds(30, 160, 100, 30);
        add(newPassLabel);

        newPasswordField = new JTextField();
        newPasswordField.setBounds(150, 160, 200, 30);
        add(newPasswordField);

        JButton verifyReset = new JButton("Verify & Reset");
        verifyReset.setBounds(150, 200, 140, 30);
        add(verifyReset);

        verifyReset.addActionListener(e -> {
            try {
                String email = emailField.getText();
                String otp = otpField.getText();
                String newPass = newPasswordField.getText();

                String verifyResp = sendPost("http://localhost:8080/api/verify-otp", "email=" + email + "&otp=" + otp);
                if (!verifyResp.equals("Verified")) {
                    JOptionPane.showMessageDialog(null, "Invalid OTP");
                    return;
                }

                sendPost("http://localhost:8080/api/reset-password", "email=" + email + "&newPassword=" + newPass);
                JOptionPane.showMessageDialog(null, "Password Reset Successful");
                dispose();
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setTitle("Reset Password");
        setSize(420, 300);
        setLocation(500, 300);
        setVisible(true);
    }

    private String sendPost(String urlStr, String urlParams) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
        out.write(urlParams);
        out.flush();
        out.close();

        int responseCode = con.getResponseCode();
        return responseCode == 200 ? new java.util.Scanner(con.getInputStream()).useDelimiter("\\A").next() : "Failed";
    }
}
