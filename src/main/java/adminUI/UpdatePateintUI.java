package adminUI;

import domain.Patient;
import service.PatientService;

import javax.swing.*;
import java.awt.*;

public class UpdatePateintUI {
    public UpdatePateintUI(Patient patient){
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

        JLabel title=new JLabel("UPDATE PATEINT");
        JButton viewAllPateint= new JButton("VIEW ALL PATEINT");
        JButton backButton = new JButton("Back");
        JButton updateButton=new JButton("UPDATE PATEINT");


        JLabel PateintName=new JLabel("Name");
        JTextField PateintNameBox=new JTextField(13);
        PateintNameBox.setText(patient.getPatientName());
        JLabel PateintAge=new JLabel("Age");
        JTextField PateintAgeBox=new JTextField(18);
        PateintAgeBox.setText(patient.getPatientAge());
        JLabel PateintAddress=new JLabel("Address");
        JTextField PateintAddressBox=new JTextField(13);
        PateintAddressBox.setText(patient.getPatientAddress());
        JLabel PateintContact=new JLabel("Contact");
        JTextField PateintContactBox=new JTextField(13);
        PateintContactBox.setText(patient.getPatientContact());
        JLabel PateintGender=new JLabel("Gender");
        JTextField  PateintGenderBox=new JTextField(13);
        PateintGenderBox.setText(patient.getPatientGender());
        JLabel PreviousPateintContact=new JLabel("Previous Contact");
        JTextField PreviousPateintContactBox=new JTextField(13);
        PreviousPateintContactBox.setText(patient.getPatientContact());

        backButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);

        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        viewAllPateint.setFont(new Font("Serif",Font.BOLD,14));


        PateintName.setBounds(400,100,300,30);
        PateintName.setFont(new Font("Serif",Font.BOLD,16));
        PateintNameBox.setBounds(530,100,200,30);

        PateintAge.setBounds(400,150,300,30);
        PateintAge.setFont(new Font("Serif",Font.BOLD,16));
        PateintAgeBox.setBounds(530,150,200,30);

        PateintAddress.setBounds(400,200,300,30);
        PateintAddress.setFont(new Font("Serif",Font.BOLD,16));
        PateintAddressBox.setBounds(530,200,200,30);

        PateintContact.setBounds(400,250,300,30);
        PateintContact.setFont(new Font("Serif",Font.BOLD,16));
        PateintContactBox.setBounds(530,250,200,30);

        PateintGender.setBounds(400,300,300,30);
        PateintGender.setFont(new Font("Serif",Font.BOLD,16));
        PateintGenderBox.setBounds(530,300,200,30);

        PreviousPateintContact.setBounds(400,350,300,30);
        PreviousPateintContact.setFont(new Font("Serif",Font.BOLD,16));
        PreviousPateintContactBox.setBounds(530,350,200,30);

        title.setBounds(40,60,400,60);

        viewAllPateint.setBounds(80,300,350,50);
        updateButton.setBounds(530,400,200,40);
        backButton.setBounds(1450,25,100,40);

        JLabel error = new JLabel();

        backButton.addActionListener(btn->{
            frame.dispose();
            new AdminPateintUI();
        });

        viewAllPateint.addActionListener(btn->{
            frame.dispose();

            new AdminPateintUI();
        });
        updateButton.addActionListener(abtn->{
            String PreviousContact=PreviousPateintContactBox.getText();

            if(PateintNameBox.getText().replaceAll("\\s","").equals("")||PateintAddressBox.getText().replaceAll("\\s","").equals("")||PateintContactBox.getText().replaceAll("\\s","").equals("")||PateintAgeBox.getText().replaceAll("\\s","").equals("")||PateintGenderBox.getText().replaceAll("\\s","").equals("")||PreviousContact.replaceAll("\\s","").equals("")){
            error.setBounds(530,450,200,40);
            error.setText("Must fill all columan");
            error.setForeground(Color.red);
            }
            else{
                PatientService.UpdatePatient(PateintNameBox.getText(),PateintAddressBox.getText(),PateintContactBox.getText(),PateintAgeBox.getText(),PateintGenderBox.getText(),PreviousContact);
                JOptionPane.showMessageDialog(frame,"patient is added");
            }

        });

        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(viewAllPateint);
        bottomPanel.add(PateintName);
        bottomPanel.add(PateintNameBox);
        bottomPanel.add(PateintAge);
        bottomPanel.add(PateintAgeBox);
        bottomPanel.add(PateintAddress);
        bottomPanel.add(PateintAddressBox);
        bottomPanel.add(updateButton);
        bottomPanel.add(PateintContact);
        bottomPanel.add(PateintContactBox);
        bottomPanel.add(PateintGender);
        bottomPanel.add(PateintGenderBox);
        bottomPanel.add(error);
        bottomPanel.add(PreviousPateintContact);
        bottomPanel.add(PreviousPateintContactBox);



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
