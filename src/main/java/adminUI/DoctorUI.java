package adminUI;

import javax.swing.*;
import java.awt.*;

public class DoctorUI{
        public DoctorUI(){
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

            JLabel title=new JLabel("DOCTORS");

            JButton addDoctorButton= new JButton("ADD DOCTOR");
            JButton deleteDoctorButton= new JButton("DELETE DOCTOR");
            JButton updateDoctorButton= new JButton("UPDATE DOCTOR");
            JButton backButton = new JButton("Back");



            title.setBounds(20,40,400,60);


            addDoctorButton.setBounds(80,100,350,50);
            deleteDoctorButton.setBounds(80,200,350,50);
            updateDoctorButton.setBounds(80,300,350,50);
            backButton.setBounds(1450,45,100,40);

            title.setFont(new Font("Serif",Font.BOLD,45));
            backButton.setFont(new Font("Serif",Font.BOLD,15));
            addDoctorButton.setFont(new Font("Serif",Font.BOLD,14));
            deleteDoctorButton.setFont(new Font("Serif",Font.BOLD,14));
            updateDoctorButton.setFont(new Font("Serif",Font.BOLD,14));

            backButton.setForeground(Color.WHITE);
            addDoctorButton.setForeground(Color.DARK_GRAY);
            updateDoctorButton.setForeground(Color.DARK_GRAY);
            deleteDoctorButton.setForeground(Color.DARK_GRAY);

            backButton.setBackground(Color.lightGray);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
            title.setForeground(Color.DARK_GRAY);


            backButton.addActionListener(btn->{
                frame.dispose();
                new AdminUI();
            });
            addDoctorButton.addActionListener(btn->{
                frame.dispose();
                new AddDoctorUI();
            });
            updateDoctorButton.addActionListener(btn->{
                frame.dispose();
                new UpdateDoctorUI();
            });
            deleteDoctorButton.addActionListener(btn->{
                frame.dispose();
                new DeleteDoctorUI();
            });




            topPanel.add(title);
            topPanel.add(backButton);
            sidePanel.add(addDoctorButton);
            sidePanel.add(updateDoctorButton);
            sidePanel.add(deleteDoctorButton);


            container.add(topPanel);
            container.add(bottomPanel);
            container.add(sidePanel);

            frame.setLayout(null);
        //    frame.setSize(1000,1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


            String column[]={"Plane","FlightNumber","Source","Destination","Date","Fare","Plane ID"};
  //          String data[][] = FlightService.getAllFlightsForJTable(column.length);
//            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane();
            sp.setBounds(0,0,1100,500);
            bottomPanel.add(sp);

        }

    public static void main(String[] args) {
        DoctorUI login=new DoctorUI();
    }
}

