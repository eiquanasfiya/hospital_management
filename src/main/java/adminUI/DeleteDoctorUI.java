package adminUI;

import javax.swing.*;
import java.awt.*;

public class DeleteDoctorUI {
    public DeleteDoctorUI() {
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel sidePanel = new JPanel();


        topPanel.setLayout(null);
        bottomPanel.setLayout(null);
        sidePanel.setLayout(null);


        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1600, 150);
        bottomPanel.setBounds(0, 150, 1100, 800);
        bottomPanel.setBackground(Color.lightGray);
        sidePanel.setBounds(1100, 150, 500, 800);
        sidePanel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("DELETE DOCTOR");
        JButton viewAllDoctors = new JButton("VIEW ALL DOCTORS");
        JButton backButton = new JButton("Back");
        JButton deleteDoctorButton=new JButton("DELETE");


        JLabel doctorContact=new JLabel("Doctor Contact");
        JTextField doctorContactBox=new JTextField(10);


        backButton.setForeground(Color.WHITE);

        backButton.setBackground(Color.lightGray);

        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif", Font.BOLD, 45));
        backButton.setFont(new Font("Serif", Font.BOLD, 15));
        viewAllDoctors.setFont(new Font("Serif", Font.BOLD, 14));
        doctorContact.setBounds(220,150,200,25);
        doctorContact.setFont(new Font("Serif", Font.BOLD, 22));
        deleteDoctorButton.setFont(new Font("Serif", Font.BOLD, 14));

        doctorContactBox.setBounds(400,150,150,35);
        deleteDoctorButton.setBounds(650,150,150,35);




        title.setBounds(40, 60, 400, 60);

        viewAllDoctors.setBounds(80, 300, 350, 50);
        backButton.setBounds(1450, 25, 100, 40);

        JLabel error = new JLabel();

        backButton.addActionListener(btn -> {
            frame.dispose();
            new DoctorUI();
        });

        viewAllDoctors.addActionListener(btn -> {
            frame.dispose();

            new DoctorUI();
        });

        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(viewAllDoctors);
        bottomPanel.add(deleteDoctorButton);
        bottomPanel.add(doctorContact);
        bottomPanel.add(doctorContactBox);


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
