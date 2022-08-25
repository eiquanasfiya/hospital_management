package adminUI;

import loginUI.LoginUI;
import javax.swing.*;
import java.awt.*;

public class AdminUI {
    public AdminUI(){
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        JLabel title=new JLabel("ADMIN PORTRAL");

        JButton adminDoctor = new JButton("DOCTOR");
        JButton adminStaff = new JButton("STAFF");
        JButton logOut=new JButton("LogOut");

        title.setBounds(620,120,700,120);

        adminDoctor.setBounds(615,300,400,55);
        adminStaff.setBounds(615,400,400,55);
        logOut.setBounds(1300,700,160,35);
        title.setFont(new Font("Serif",Font.BOLD,45));
        adminDoctor.setFont(new Font("Serif",Font.BOLD,20));
        adminStaff.setFont(new Font("Serif",Font.BOLD,20));
        logOut.setFont(new Font("Serif",Font.BOLD,14));
        adminDoctor.setBackground(Color.GRAY);
        adminStaff.setBackground(Color.GRAY);
        logOut.setBackground(Color.GRAY);

        adminDoctor.addActionListener(btn->{
             new DoctorUI();
        });
        adminStaff.addActionListener(btn->{
            new StaffUI();
        });


        logOut.addActionListener(btn->{

            frame.dispose();
            JOptionPane.showMessageDialog(frame,"log Out Successfully.");
            new LoginUI();
        });



        frame.add(title);
        frame.add(adminDoctor);
        frame.add(adminStaff);
        frame.add(logOut);

        frame.setLayout(null);
//        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
