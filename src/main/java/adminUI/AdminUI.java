package adminUI;

import loginUI.LoginUI;
import javax.swing.*;
import java.awt.*;

public class AdminUI {
    public AdminUI(){
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        JLabel title=new JLabel("ADMIN PORTRAL");

        JButton adminDoctor = new JButton("DOCTOR");
        JButton adminpatient = new JButton("PATIENT");
        JButton adminReport=new JButton("REPORT");
        JButton appointment=new JButton("APPOINTMENT");
         JButton logOut=new JButton("LogOut");

        title.setBounds(620,120,700,120);

        adminDoctor.setBounds(615,300,400,55);
        adminpatient.setBounds(615,400,400,55);
        adminReport.setBounds(615,500,400,55);
        appointment.setBounds(615,600,400,55);
        logOut.setBounds(1300,800,160,35);
        title.setFont(new Font("Serif",Font.BOLD,45));
        adminDoctor.setFont(new Font("Serif",Font.BOLD,20));
        adminpatient.setFont(new Font("Serif",Font.BOLD,20));
        adminReport.setFont(new Font("Serif",Font.BOLD,20));
        appointment.setFont(new Font("Serif",Font.BOLD,20));
        logOut.setFont(new Font("Serif",Font.BOLD,14));
//        adminDoctor.setBackground(Color.GRAY);
//        adminStaff.setBackground(Color.GRAY);
        logOut.setBackground(Color.GRAY);

        adminDoctor.addActionListener(btn->{
            new DoctorUI();
            frame.dispose();
        });

        adminReport.addActionListener(btn->{
            new ReportUI();
            frame.dispose();
        });


        logOut.addActionListener(btn->{

            frame.dispose();
            JOptionPane.showMessageDialog(frame,"log Out Successfully.");
            new LoginUI();
        });
        adminpatient.addActionListener(btn->{
            new AdminPateintUI();
            frame.dispose();
        });


        frame.add(title);
        frame.add(adminDoctor);
        frame.add(adminpatient);
        frame.add(adminReport);
        frame.add(appointment);
        frame.add(logOut);

        frame.setLayout(null);
//        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
