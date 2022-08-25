package userUI.patientSection;

import service.PatientService;

import javax.swing.*;
import java.awt.*;

public class SearchPatient {
    public SearchPatient(){
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
        JButton viewAllPatients = new JButton("VIEW ALL PATIENTS");
        JButton backButton = new JButton("Back");
        JButton searchPatientButton=new JButton("SEARCH");

        JLabel patientContact=new JLabel("Patient Contact");
        JTextField patientContactBox=new JTextField(10);

        title.setBounds(20,40,400,60);


        viewAllPatients.setBounds(80,100,350,50);
        backButton.setBounds(1450,45,100,40);
        searchPatientButton.setBounds(850,50,150,35);
        patientContact.setBounds(560,50,200,25);
        patientContact.setFont(new Font("Serif", Font.BOLD, 22));
        patientContactBox.setBounds(400,50,150,35);
        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        viewAllPatients.setFont(new Font("Serif",Font.BOLD,14));
        searchPatientButton.setFont(new Font("Serif", Font.BOLD, 14));


        backButton.setForeground(Color.WHITE);
        viewAllPatients.setForeground(Color.DARK_GRAY);



        backButton.setBackground(Color.lightGray);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
        title.setForeground(Color.DARK_GRAY);


        backButton.addActionListener(btn->{
            frame.dispose();
            new PateintUI();
        });
        viewAllPatients.addActionListener(btn->{
                    frame.dispose();
                    new PateintUI();
        });





        topPanel.add(title);
        topPanel.add(backButton);
        topPanel.add(searchPatientButton);
        topPanel.add(patientContact);
        topPanel.add(patientContactBox);
        sidePanel.add(viewAllPatients);



        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        searchPatientButton.addActionListener(btn->{
            String column[]={"Name","Address","Contact","Age","Gender"};
        String data[][] = PatientService.getPatientByContact(patientContactBox.getText());
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,1100,500);
        bottomPanel.add(sp);
        });

//        String column[]={"Name","Address","Contact","Age","Gender"};
//        String data[][] = PatientService.getAllPatients();
//        JTable jt=new JTable(data,column);
//        JScrollPane sp=new JScrollPane(jt);
//        sp.setBounds(0,0,1100,500);
//        bottomPanel.add(sp);
    }
}
