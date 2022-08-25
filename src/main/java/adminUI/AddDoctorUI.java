package adminUI;

import javax.swing.*;
import java.awt.*;

public class AddDoctorUI {
    public AddDoctorUI(){
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

        JLabel title=new JLabel("ADD DOCTOR");
        JButton viewAllDoctors= new JButton("VIEW ALL DOCTORS");
        JButton backButton = new JButton("Back");
        JButton addDoctorButton=new JButton("ADD DOCTOR");


        JLabel doctorName=new JLabel("Name");
        JTextField doctorNameBox=new JTextField(13);
        JLabel doctorAddress=new JLabel("Address");
        JTextField doctorAddressBox=new JTextField(18);
        JLabel doctorContact=new JLabel("Contact");
        JTextField doctorContactBox=new JTextField(13);
        JLabel doctorDepartment=new JLabel("Department");
        JTextField doctorDepartmentBox=new JTextField(13);
        JLabel doctorExperience=new JLabel("Experience");
        JTextField doctorExperienceBox=new JTextField(13);

        backButton.setForeground(Color.WHITE);
        addDoctorButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);

        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        viewAllDoctors.setFont(new Font("Serif",Font.BOLD,14));


        doctorName.setBounds(400,100,300,30);
        doctorName.setFont(new Font("Serif",Font.BOLD,16));
        doctorNameBox.setBounds(530,100,200,30);

        doctorAddress.setBounds(400,150,300,30);
        doctorAddress.setFont(new Font("Serif",Font.BOLD,16));
        doctorAddressBox.setBounds(530,150,200,30);

        doctorContact.setBounds(400,200,300,30);
        doctorContact.setFont(new Font("Serif",Font.BOLD,16));
        doctorContactBox.setBounds(530,200,200,30);

        doctorDepartment.setBounds(400,250,300,30);
        doctorDepartment.setFont(new Font("Serif",Font.BOLD,16));
        doctorDepartmentBox.setBounds(530,250,200,30);

        doctorExperience.setBounds(400,300,300,30);
        doctorExperience.setFont(new Font("Serif",Font.BOLD,16));
        doctorExperienceBox.setBounds(530,300,200,30);


        title.setBounds(40,60,400,60);

        viewAllDoctors.setBounds(80,300,350,50);
        addDoctorButton.setBounds(530,400,200,40);
        backButton.setBounds(1450,25,100,40);

        JLabel error = new JLabel();

        backButton.addActionListener(btn->{
            frame.dispose();
            new DoctorUI();
        });

        viewAllDoctors.addActionListener(btn->{
            frame.dispose();

            new DoctorUI();
        });

        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(viewAllDoctors);
        bottomPanel.add(doctorName);
        bottomPanel.add(doctorNameBox);
        bottomPanel.add(doctorAddress);
        bottomPanel.add(doctorAddressBox);
        bottomPanel.add(doctorContact);
        bottomPanel.add(doctorContactBox);
        bottomPanel.add(addDoctorButton);
        bottomPanel.add(doctorDepartment);
        bottomPanel.add(doctorDepartmentBox);
        bottomPanel.add(doctorExperience);
        bottomPanel.add(doctorExperienceBox);
        bottomPanel.add(error);



        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
      //  frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

}
