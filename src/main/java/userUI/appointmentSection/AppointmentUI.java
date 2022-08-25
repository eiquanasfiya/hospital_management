package userUI.appointmentSection;

import service.AppointmentService;
import userUI.patientSection.Reception;

import javax.swing.*;
import java.awt.*;

public class AppointmentUI {
    public AppointmentUI(){
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        Container container=frame.getContentPane();

        JPanel topPanel=new JPanel();
        JPanel bottomPanel=new JPanel();
        JPanel sidePanel=new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);
        sidePanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0,0,1600,150);
        bottomPanel.setBounds(0,150,1100,800);
        bottomPanel.setBackground(Color.lightGray);
        sidePanel.setBounds(1100,150,500,800);
        sidePanel.setBackground(Color.DARK_GRAY);

        JLabel title=new JLabel("APPOINTMENT");

        JButton addAppointmentButton= new JButton("ADD APPOINTMENT");
        JButton searchAppointmentButton= new JButton("SEARCH APPOINTMENT");
        JButton backButton = new JButton("Back");



        title.setBounds(20,40,400,60);


        addAppointmentButton.setBounds(80,100,350,50);
        searchAppointmentButton.setBounds(80,200,350,50);
        backButton.setBounds(1450,45,100,40);

        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        addAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));
        searchAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));

        backButton.setForeground(Color.WHITE);
        addAppointmentButton.setForeground(Color.DARK_GRAY);
        searchAppointmentButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
        title.setForeground(Color.DARK_GRAY);


        backButton.addActionListener(btn->{
            frame.dispose();
            new Reception();
        });
        addAppointmentButton.addActionListener(btn->{
            frame.dispose();
            new AddAppointment();
        });

        searchAppointmentButton.addActionListener(btn->{
            frame.dispose();
            new SearchAppointment();
        });




        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(addAppointmentButton);
        sidePanel.add(searchAppointmentButton);


        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        String column[]={"Appointment Number","Date","Time","Service Charges","Doctor Name","Specialization","Fee","Patient Name","Contact"};
        String data[][] = AppointmentService.getAllAppointments();
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,1100,500);
        bottomPanel.add(sp);
    }
}
