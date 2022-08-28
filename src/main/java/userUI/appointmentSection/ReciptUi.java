package userUI.appointmentSection;

import service.AppointmentService;
import service.BillService;
import service.DoctorService;
import service.PatientService;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReciptUi {

    public ReciptUi(String appointmentNumber,String date, String time, String doctorNamec, String patientName, String address, String contact, String age, String gender) {
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        Container container=frame.getContentPane();
        AtomicBoolean flag = new AtomicBoolean(false);

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

        JLabel title=new JLabel("RECIPT");
        JButton print= new JButton("GENERATE BILL");
        JButton backButton = new JButton("Back");
        JButton pay=new JButton("PAY");

        Integer randomInvoiceNumber = new Random().nextInt(1000000);
        JLabel invoiceNumber=new JLabel("Invoice Number");
        JLabel invoiceNumberBox=new JLabel(randomInvoiceNumber.toString());
        JLabel doctorName=new JLabel("Doctor Name");
        JLabel doctorNameBox=new JLabel(doctorNamec);
        JLabel doctorFee=new JLabel("Fee");
        Double fees = DoctorService.getDoctorFees(doctorNamec);
        Double service_charges = fees*0.2;
        Double totalAmt = fees+service_charges;
        JLabel doctorFeeBox=new JLabel(fees.toString());
        JLabel serviceCharges=new JLabel("Service Charges");
        JLabel serviceChargesBox=new JLabel(service_charges.toString());
        JLabel totalAmount=new JLabel("Total Amount");
        JLabel totalAmountBox=new JLabel(totalAmt.toString());
        JLabel payment=new JLabel("Payment");
        JTextField paymentBox=new JTextField(13);

        backButton.setForeground(Color.WHITE);
        pay.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);

        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        print.setFont(new Font("Serif",Font.BOLD,14));

        invoiceNumber.setBounds(400,100,300,30);
        invoiceNumber.setFont(new Font("Serif",Font.BOLD,16));
        invoiceNumberBox.setBounds(530,100,200,30);

        doctorName.setBounds(400,150,300,30);
        doctorName.setFont(new Font("Serif",Font.BOLD,16));
        doctorNameBox.setBounds(530,150,200,30);

        doctorFee.setBounds(400,200,300,30);
        doctorFee.setFont(new Font("Serif",Font.BOLD,16));
        doctorFeeBox.setBounds(530,200,200,30);

        serviceCharges.setBounds(400,250,300,30);
        serviceCharges.setFont(new Font("Serif",Font.BOLD,16));
        serviceChargesBox.setBounds(530,250,200,30);

        totalAmount.setBounds(400,300,300,30);
        totalAmount.setFont(new Font("Serif",Font.BOLD,16));
        totalAmountBox.setBounds(530,300,200,30);

        payment.setBounds(400,350,300,30);
        payment.setFont(new Font("Serif",Font.BOLD,16));
        paymentBox.setBounds(530,350,200,30);


        title.setBounds(40,60,400,60);

        print.setBounds(80,300,350,50);
        pay.setBounds(530,450,200,40);
        backButton.setBounds(1450,25,100,40);

        JLabel error = new JLabel();

        backButton.addActionListener(btn->{
            frame.dispose();
            new AddAppointment();
        });

        pay.addActionListener(btn->{
            if(paymentBox.getText().replaceAll("\\s","").equals("")||invoiceNumberBox.getText().replaceAll("\\s","").equals("")){
                error.setBounds(530,400,300,15);
                error.setText("Must fill all column");
                error.setForeground(Color.red);
            }
            else if((Double.parseDouble(paymentBox.getText())) == totalAmt){
                JOptionPane.showMessageDialog(frame,"Payment Successful");
              PatientService.addPatient(patientName,address,contact,age,gender);
                int patientId = PatientService.getPatientIdByContact(contact);
                int doctorId = DoctorService.getDoctorIdByName(doctorNamec);
              AppointmentService.addAppointment(appointmentNumber,date,time,service_charges,doctorId,patientId);
              flag.set(true);

            }
            else{
                error.setBounds(530,400,300,15);
                error.setText("You enter wrong amount");
                error.setForeground(Color.red);
            }
        });

        print.addActionListener(btn->{
            if(flag.get()){
                int appointmentId = AppointmentService.getAppointmentIdByAppointmentNumber(appointmentNumber);
                Boolean flag1 = BillService.addBill(invoiceNumberBox.getText(),appointmentId);
                if(flag1){
                    JOptionPane.showMessageDialog(frame,"Bill Added");
                    System.out.println("Invoice Number : "+invoiceNumberBox.getText());
                    System.out.println("appointment Number"+appointmentNumber);
                    System.out.println("date"+date);
                    System.out.println("time"+time);
                    System.out.println("doctor Name"+doctorNamec);
                    System.out.println("doctor Fee"+fees);
                    System.out.println("service charges"+service_charges);
                    System.out.println("total amount"+totalAmt);
                    System.out.println("patient name"+patientName);
                    System.out.println("patient address"+address);
                    System.out.println("patient contact"+contact);
                    System.out.println("age"+age);
                    System.out.println("gender"+gender);
                    frame.dispose();
                    new BillUi(invoiceNumberBox.getText(),appointmentNumber,date,time,doctorNamec,fees,service_charges,totalAmt,patientName,address,contact,age,gender);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Bill Not Added");
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"First you need to pay");
            }
        });
        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(print);
        bottomPanel.add(invoiceNumber);
        bottomPanel.add(invoiceNumberBox);
        bottomPanel.add(doctorName);
        bottomPanel.add(doctorNameBox);
        bottomPanel.add(doctorFee);
        bottomPanel.add(doctorFeeBox);
        bottomPanel.add(serviceCharges);
        bottomPanel.add(serviceChargesBox);
        bottomPanel.add(pay);
        bottomPanel.add(totalAmount);
        bottomPanel.add(totalAmountBox);
        bottomPanel.add(payment);
        bottomPanel.add(paymentBox);
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
