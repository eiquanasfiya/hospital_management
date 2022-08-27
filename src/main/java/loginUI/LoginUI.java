package loginUI;

import adminUI.AdminUI;
import service.AuthanticationService;
import userUI.patientSection.Reception;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public LoginUI() {
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        JLabel title=new JLabel("HOSPITAL MANAGEMENT SYSTEM");

        JLabel user = new JLabel("User");
        JTextField userBox = new JTextField(10);
        JLabel pass = new JLabel("Password");
        JPasswordField passBox = new JPasswordField(10);

        JLabel error = new JLabel();

        JButton login = new JButton("Login");

        title.setBounds(350,100,800,120);
        user.setBounds(640,290,40,40);
        userBox.setBounds(720,300,160,28);
        pass.setBounds(640,330,60,40);
        passBox.setBounds(720,330,160,28);
        login.setBounds(640,430,240,40);
        login.setBackground(Color.GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));

        login.addActionListener(btn->{
            String username= userBox.getText();
            String userPassword=new String(passBox.getPassword());
            String type= AuthanticationService.loginType(username,userPassword);
            if(type.equals("user")){
                frame.dispose();
               new Reception();
            }
            else if(type.equals("admin")){
                frame.dispose();
                new AdminUI();
            }
            else if(username.replaceAll("\\s","").equals("")||userPassword.equals("")){
                error.setText("Must be fill all column");
                error.setForeground(Color.red);
                error.setBounds(720,360,160,28);
            }
            else{
                error.setText("Invalid user name or password");
                error.setForeground(Color.red);
                error.setBounds(720,360,160,28);
            }

//
//            if(AuthenticService.AuthenticAdmin(username,userPassword)){
//                JOptionPane.showMessageDialog(frame,"log-In As A Admin Successfully.");
//                frame.dispose();
//                new AdminUI();
//
//            }
//            else if(AuthenticService.AuthenticUser(username,userPassword)){
//                JOptionPane.showMessageDialog(frame,"log-In As A User Successfully.");
//                frame.dispose();
//                new UserUI();
//
//            }
//            else{
//                error.setBounds(330,400,300,10);
//                error.setText("INVALID USER AND PASSWORD");
//                error.setForeground(Color.red);
//            }
           // frame.dispose();



        });

        frame.add(user);
        frame.add(userBox);
        frame.add(pass);
        frame.add(passBox);
        frame.add(error);
        frame.add(login);
        frame.add(title);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);

        frame.setLayout(null);
//        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }


//    public static void main(String[] args) {
//        LoginUI login=new LoginUI();
//
//    }
}
