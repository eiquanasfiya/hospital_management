package userUI.appointmentSection;

import javax.swing.*;
import java.awt.*;

public class BillUi {

    public BillUi(String invoiceNumber, String appointmentNumber, String date, String time, String doctorNamec, Double fees, Double service_charges, Double totalAmt, String patientName, String address, String contact, String age, String gender){
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

        JLabel title=new JLabel("Bill");
        JButton printBill= new JButton("PRINT BILL");
        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.lightGray);
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        backButton.setBounds(1450,25,100,40);

        backButton.addActionListener(btn->{
            frame.dispose();
            new AppointmentUI();
        });


        JTextArea textArea = new JTextArea();
        textArea.setBounds(200,100,400,500);
        textArea.setFont(new Font("Calibri",Font.BOLD,15));
        textArea.setText("***********************************************************\n");
        textArea.setText(textArea.getText()+"***********************BILL RECEIPT*************************\n");
        textArea.setText(textArea.getText()+"*************************************************************\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"        Invoice Number      :      "+invoiceNumber+"\n");
        textArea.setText(textArea.getText()+"        Appointment Number  :      "+appointmentNumber+"\n");
        textArea.setText(textArea.getText()+"        Date                :      "+date+"\n");
        textArea.setText(textArea.getText()+"        Time                :      "+time+"\n");
        textArea.setText(textArea.getText()+"        Doctor Name         :      "+doctorNamec+"\n");
        textArea.setText(textArea.getText()+"        Doctor Fees         :      "+fees+"\n");
        textArea.setText(textArea.getText()+"        Service Charges     :      "+service_charges+"\n");
        textArea.setText(textArea.getText()+"        Total Amount        :      "+totalAmt+"\n");
        textArea.setText(textArea.getText()+"        Patient Name        :      "+patientName+"\n");
        textArea.setText(textArea.getText()+"        Patient Address     :      "+address+"\n");
        textArea.setText(textArea.getText()+"        Patient Contact     :      "+contact+"\n");
        textArea.setText(textArea.getText()+"        Patient Age         :      "+age+"\n");
        textArea.setText(textArea.getText()+"        Patient Gender      :      "+gender+"\n");





        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));
        printBill.setFont(new Font("Serif",Font.BOLD,14));




        title.setBounds(40,60,400,60);

        printBill.setBounds(80,300,350,50);



printBill.addActionListener(btn->{
    try{
        textArea.print();
    }catch (Exception e){
        System.out.println(e);
    }
});






        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(printBill);
        bottomPanel.add(textArea);



        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //  frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }





//    public BillUi(String invoiceNumber, String appointmentNumber, String date, String time, String doctorNamec, Double fees, Double service_charges, Double totalAmt, String patientName, String address, String contact, String age, String gender){
////        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
////        Container container=frame.getContentPane();
////
////        JPanel topPanel=new JPanel();
////        JPanel bottomPanel=new JPanel();
////        JPanel sidePanel=new JPanel();
////
////
////
////        topPanel.setLayout(null);
////        bottomPanel.setLayout(null);
////        sidePanel.setLayout(null);
////
////
////        topPanel.setBackground(Color.GRAY);
////        topPanel.setBounds(0,0,1600,150);
////        bottomPanel.setBounds(0,150,1100,800);
////        bottomPanel.setBackground(Color.lightGray);
////        sidePanel.setBounds(1100,150,500,800);
////        sidePanel.setBackground(Color.DARK_GRAY);
////
////        JLabel title=new JLabel("Bill");
////        JButton printBill= new JButton("VIEW ALL PATIENTS");
////        JButton backButton = new JButton("Back");
////        JButton addPatientButton=new JButton("ADD PATIENT");
////
////
////        JLabel patientName=new JLabel("Name");
////        JTextField patientNameBox=new JTextField(13);
////        JLabel patientAddress=new JLabel("Address");
////        JTextField patientAddressBox=new JTextField(18);
////        JLabel patientContact=new JLabel("Contact");
////        JTextField patientContactBox=new JTextField(13);
////        JLabel patientAge=new JLabel("Age");
////        JTextField patientAgeBox=new JTextField(13);
////        JLabel patientGender=new JLabel("Gender");
////        JTextField patientGenderBox=new JTextField(13);
////
////        backButton.setForeground(Color.WHITE);
////        addPatientButton.setForeground(Color.DARK_GRAY);
////
////        backButton.setBackground(Color.lightGray);
////
////        title.setForeground(Color.DARK_GRAY);
////        title.setFont(new Font("Serif",Font.BOLD,45));
////        backButton.setFont(new Font("Serif",Font.BOLD,15));
////        printBill.setFont(new Font("Serif",Font.BOLD,14));
////
////
////        patientName.setBounds(400,100,300,30);
////        patientName.setFont(new Font("Serif",Font.BOLD,16));
////        patientNameBox.setBounds(530,100,200,30);
////
////        patientAddress.setBounds(400,150,300,30);
////        patientAddress.setFont(new Font("Serif",Font.BOLD,16));
////        patientAddressBox.setBounds(530,150,200,30);
////
////        patientContact.setBounds(400,200,300,30);
////        patientContact.setFont(new Font("Serif",Font.BOLD,16));
////        patientContactBox.setBounds(530,200,200,30);
////
////        patientAge.setBounds(400,250,300,30);
////        patientAge.setFont(new Font("Serif",Font.BOLD,16));
////        patientAgeBox.setBounds(530,250,200,30);
////
////        patientGender.setBounds(400,300,300,30);
////        patientGender.setFont(new Font("Serif",Font.BOLD,16));
////        patientGenderBox.setBounds(530,300,200,30);
////
////
////        title.setBounds(40,60,400,60);
////
////        printBill.setBounds(80,300,350,50);
////        addPatientButton.setBounds(530,400,200,40);
////        backButton.setBounds(1450,25,100,40);
////
////        JLabel error = new JLabel();
////
////        backButton.addActionListener(btn->{
////            frame.dispose();
////            new PateintUI();
////        });
////
////        printBill.addActionListener(btn->{
////            frame.dispose();
////
////            new PateintUI();
////        });
////
////        addPatientButton.addActionListener(btn->{
////            String name = patientNameBox.getText();
////            String address = patientAddressBox.getText();
////            String contact  = patientContactBox.getText();
////            String age = patientAgeBox.getText();
////            String gender = patientGenderBox.getText();
////
////            Boolean flag = PatientService.addPatient(name,address,contact,age,gender);
////            if(flag){
////                JOptionPane.showMessageDialog(frame,"Patient Added");
////            }else {
////                JOptionPane.showMessageDialog(frame,"Patient Not Added");
////            }
////        });
////
////        topPanel.add(title);
////        topPanel.add(backButton);
////        sidePanel.add(printBill);
////        bottomPanel.add(patientName);
////        bottomPanel.add(patientNameBox);
////        bottomPanel.add(patientAddress);
////        bottomPanel.add(patientAddressBox);
////        bottomPanel.add(patientContact);
////        bottomPanel.add(patientContactBox);
////        bottomPanel.add(addPatientButton);
////        bottomPanel.add(patientAge);
////        bottomPanel.add(patientAgeBox);
////        bottomPanel.add(patientGender);
////        bottomPanel.add(patientGenderBox);
////        bottomPanel.add(error);
////
////
////
////        container.add(topPanel);
////        container.add(bottomPanel);
////        container.add(sidePanel);
////
////        frame.setLayout(null);
////        //  frame.setSize(1000,1000);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setVisible(true);
////        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//    }


}
