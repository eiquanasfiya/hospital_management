package adminUI;

import service.AppointmentService;
import service.DoctorService;
import userUI.appointmentSection.AppointmentUI;
import userUI.appointmentSection.ReciptUi;

import javax.swing.*;
import java.awt.*;

public class AdminAddAppointment {
    public AdminAddAppointment(){
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

        JLabel title=new JLabel("ADD APPOINTMENT");
        JButton viewAllAppointments= new JButton("VIEW ALL APPOINTMENT");
        JButton backButton = new JButton("Back");
        JButton addAppointmentButton=new JButton("ADD APPOINTMENT");


        String latestAppointmentNumber = AppointmentService.getLatestAppointmentNumber();
        JLabel appointmentNumber=new JLabel("Appointment Num");
        JTextField appointmentNumberBox=new JTextField(13);
        appointmentNumberBox.setText(latestAppointmentNumber);
        JLabel date=new JLabel("Date");
        JTextField dateBox=new JTextField(13);
        JLabel time=new JLabel("Time");
        JTextField timeBox=new JTextField(18);
        String optionOfDoctors[] = DoctorService.getDoctorsName();
        JLabel doctorsName = new JLabel("Doctors Name");
        JComboBox doctorsNameBox=new JComboBox(optionOfDoctors);
        JLabel patientName=new JLabel("Patient Name");
        JTextField patientNameBox=new JTextField(13);
        JLabel patientAddress=new JLabel("Address");
        JTextField patientAddressBox=new JTextField(18);
        JLabel patientContact=new JLabel("Contact");
        JTextField patientContactBox=new JTextField(13);
        JLabel patientAge=new JLabel("Age");
        JTextField patientAgeBox=new JTextField(13);
        JLabel patientGender=new JLabel("Gender");
        JTextField patientGenderBox=new JTextField(13);
        JLabel error = new JLabel();

        backButton.setForeground(Color.WHITE);
        addAppointmentButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);

        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        viewAllAppointments.setFont(new Font("Serif",Font.BOLD,14));


        appointmentNumber.setBounds(400,100,300,30);
        appointmentNumber.setFont(new Font("Serif",Font.BOLD,16));
        appointmentNumberBox.setBounds(530,100,200,30);

        date.setBounds(400,150,300,30);
        date.setFont(new Font("Serif",Font.BOLD,16));
        dateBox.setBounds(530,150,200,30);

        time.setBounds(400,200,300,30);
        time.setFont(new Font("Serif",Font.BOLD,16));
        timeBox.setBounds(530,200,200,30);


        doctorsName.setBounds(400,250,300,30);
        doctorsName.setFont(new Font("Serif",Font.BOLD,16));
        doctorsNameBox.setBounds(530,250,200,30);

        patientName.setBounds(400,300,300,30);
        patientName.setFont(new Font("Serif",Font.BOLD,16));
        patientNameBox.setBounds(530,300,200,30);

        patientAddress.setBounds(400,350,300,30);
        patientAddress.setFont(new Font("Serif",Font.BOLD,16));
        patientAddressBox.setBounds(530,350,200,30);

        patientContact.setBounds(400,400,300,30);
        patientContact.setFont(new Font("Serif",Font.BOLD,16));
        patientContactBox.setBounds(530,400,200,30);

        patientAge.setBounds(400,450,300,30);
        patientAge.setFont(new Font("Serif",Font.BOLD,16));
        patientAgeBox.setBounds(530,450,200,30);

        patientGender.setBounds(400,500,300,30);
        patientGender.setFont(new Font("Serif",Font.BOLD,16));
        patientGenderBox.setBounds(530,500,200,30);


        title.setBounds(40,60,400,60);

        viewAllAppointments.setBounds(80,300,350,50);
        addAppointmentButton.setBounds(530,600,200,40);
        backButton.setBounds(1450,25,100,40);



        backButton.addActionListener(btn->{
            frame.dispose();
            new AdminAppointmentUi();
        });

        viewAllAppointments.addActionListener(btn->{
            frame.dispose();

           new AdminAppointmentUi();
        });
        addAppointmentButton.addActionListener(btn->{
//            PatientService.addPatient(patientNameBox.getText(),patientAddressBox.getText(),patientContactBox.getText(),patientAgeBox.getText(),patientGenderBox.getText());
//            JOptionPane.showMessageDialog(frame,"You need to pay bill");
            if(dateBox.getText().replaceAll("\\s","").equals("")||timeBox.getText().replaceAll("\\s","").equals("") ||patientNameBox.getText().replaceAll("\\s","").equals("") || patientAddressBox.getText().replaceAll("\\s","").equals("") || patientContactBox.getText().replaceAll("\\s","").equals("")||patientAgeBox.getText().replaceAll("\\s","").equals("") || patientGenderBox.getText().replaceAll("\\s","").equals("")){
                error.setBounds(530,550,300,15);
                error.setText("Must fill all column ");
                error.setForeground(Color.red);
            }
            else{
                frame.dispose();
                new AdminReciptUi(appointmentNumberBox.getText(),dateBox.getText(),timeBox.getText(),doctorsNameBox.getSelectedItem().toString(),patientNameBox.getText(),patientAddressBox.getText(),patientContactBox.getText(),patientAgeBox.getText(),patientGenderBox.getText());
            }

//            frame.dispose();
//            new BillUi();
//            String fee = DoctorService.getDoctorFees(doctorsNameBox.getText());
//            Double actualFee = Double.parseDouble(fee);
//            System.out.println(actualFee);
//            Boolean flag = AppointmentService.addAppointment(dateBox.getText(),timeBox.getText(),serviceChargesBox.getText(),doctorsNameBox.getText(),patientNameBox.getText());
//            if(flag){
//                JOptionPane.showMessageDialog(frame,"Appointment Added");
//            }else {
//                JOptionPane.showMessageDialog(frame,"Appointment Not Added");
//            }
        });

        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(viewAllAppointments);
        bottomPanel.add(appointmentNumber);
        bottomPanel.add(appointmentNumberBox);
        bottomPanel.add(date);
        bottomPanel.add(dateBox);
        bottomPanel.add(time);
        bottomPanel.add(timeBox);
        bottomPanel.add(addAppointmentButton);
        bottomPanel.add(doctorsName);
        bottomPanel.add(doctorsNameBox);
        bottomPanel.add(patientName);
        bottomPanel.add(patientNameBox);
        bottomPanel.add(patientAddress);
        bottomPanel.add(patientAddressBox);
        bottomPanel.add(patientContact);
        bottomPanel.add(patientContactBox);
        bottomPanel.add(patientAge);
        bottomPanel.add(patientAgeBox);
        bottomPanel.add(patientGender);
        bottomPanel.add(patientGenderBox);
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
