package adminUI;

import userUI.appointmentSection.AppointmentUI;

import javax.swing.*;
import java.awt.*;

public class AdminBillUi {
    public AdminBillUi(String invoiceNumber, String appointmentNumber, String date, String time, String doctorNamec, Double fees, Double service_charges, Double totalAmt, String patientName, String address, String contact, String age, String gender){
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
            new AdminAppointmentUi();
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
}
