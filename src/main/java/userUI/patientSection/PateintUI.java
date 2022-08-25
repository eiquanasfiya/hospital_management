package userUI.patientSection;

import service.PatientService;

import javax.swing.*;
import java.awt.*;

public class PateintUI {
    public PateintUI(){
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

        JLabel title=new JLabel("PATIENT");

        JButton addPatientButton= new JButton("ADD PATIENT");
        JButton searchPatientButton= new JButton("SEARCH PATIENT");
        JButton backButton = new JButton("Back");



        title.setBounds(20,40,400,60);


        addPatientButton.setBounds(80,100,350,50);
        searchPatientButton.setBounds(80,200,350,50);
        backButton.setBounds(1450,45,100,40);

        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        addPatientButton.setFont(new Font("Serif",Font.BOLD,14));
        searchPatientButton.setFont(new Font("Serif",Font.BOLD,14));

        backButton.setForeground(Color.WHITE);
        addPatientButton.setForeground(Color.DARK_GRAY);
        searchPatientButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
        title.setForeground(Color.DARK_GRAY);


        backButton.addActionListener(btn->{
            frame.dispose();
            new Reception();
        });
//        addPatientButton.addActionListener(btn->{
//            frame.dispose();
//            new AddPatient();
//        });
        searchPatientButton.addActionListener(btn->{
            frame.dispose();
            new SearchPatient();
        });




        topPanel.add(title);
        topPanel.add(backButton);
//        sidePanel.add(addPatientButton);
        sidePanel.add(searchPatientButton);


        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        String column[]={"Name","Address","Contact","Age","Gender"};
        String data[][] = PatientService.getAllPatients();
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,1100,500);
        bottomPanel.add(sp);
    }
}
