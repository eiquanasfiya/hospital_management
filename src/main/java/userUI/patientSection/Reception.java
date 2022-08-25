package userUI.patientSection;

import loginUI.LoginUI;
import userUI.appointmentSection.AppointmentUI;

import javax.swing.*;
import java.awt.*;

public class Reception {
    public Reception(){
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        JLabel title=new JLabel("RECEPTION");

        JButton patient = new JButton("PATIENT");
        JButton appoinment = new JButton("APPOINTMENT");
        JButton logOut=new JButton("LogOut");

        title.setBounds(690,120,700,120);

        patient.setBounds(615,300,400,55);
        appoinment.setBounds(615,400,400,55);
        logOut.setBounds(1300,700,160,35);
        title.setFont(new Font("Serif",Font.BOLD,45));
        patient.setFont(new Font("Serif",Font.BOLD,20));
        appoinment.setFont(new Font("Serif",Font.BOLD,20));
        logOut.setFont(new Font("Serif",Font.BOLD,14));
        patient.setBackground(Color.GRAY);
        appoinment.setBackground(Color.GRAY);
        logOut.setBackground(Color.GRAY);

        patient.addActionListener(btn->{
            new PateintUI();
        });
        appoinment.addActionListener(btn->{
            new AppointmentUI();
        });


        logOut.addActionListener(btn->{

            frame.dispose();
            JOptionPane.showMessageDialog(frame,"log Out Successfully.");
            new LoginUI();
        });



        frame.add(title);
        frame.add(patient);
        frame.add(appoinment);
        frame.add(logOut);

        frame.setLayout(null);
//        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
