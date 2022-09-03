package adminUI;

import service.AppointmentService;
import service.PatientService;
import userUI.appointmentSection.AddAppointment;
import userUI.appointmentSection.SearchAppointment;
import userUI.patientSection.Reception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminAppointmentUi {
    public AdminAppointmentUi (){
         String[] cell = new String[1];
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

        JLabel title=new JLabel("APPOINTMENT");

        JButton addAppointmentButton= new JButton("ADD APPOINTMENT");
        JButton searchAppointmentButton= new JButton("SEARCH APPOINTMENT");
        JButton deleteAppointmentButton= new JButton("DELETE APPOINTMENT");
        JButton updateAppointmentButton= new JButton("UPDATE APPOINTMENT");

        JButton backButton = new JButton("Back");



        title.setBounds(20,40,400,60);


        addAppointmentButton.setBounds(80,100,350,50);
        searchAppointmentButton.setBounds(80,200,350,50);
        deleteAppointmentButton.setBounds(80,300,350,50);
        updateAppointmentButton.setBounds(80,400,350,50);
        backButton.setBounds(1450,45,100,40);

        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        addAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));
        searchAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));
        deleteAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));
        updateAppointmentButton.setFont(new Font("Serif",Font.BOLD,14));

        backButton.setForeground(Color.WHITE);
        addAppointmentButton.setForeground(Color.DARK_GRAY);
        searchAppointmentButton.setForeground(Color.DARK_GRAY);
        deleteAppointmentButton.setForeground(Color.DARK_GRAY);
        updateAppointmentButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
        title.setForeground(Color.DARK_GRAY);


        backButton.addActionListener(btn->{
            frame.dispose();
            new AdminUI();
        });
        addAppointmentButton.addActionListener(btn->{
            frame.dispose();
            new AdminAddAppointment();
        });

        searchAppointmentButton.addActionListener(btn->{
            frame.dispose();
            new AdminSearshAppointment();
        });





        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(addAppointmentButton);
        sidePanel.add(searchAppointmentButton);
        sidePanel.add(deleteAppointmentButton);
        sidePanel.add(updateAppointmentButton);
        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        String column[]={"Appointment Number","Date","Time","Service Charges","Doctor Name","Specialization","Fee","Patient Name","Contact"};
        String data[][] = AppointmentService.getAllAppointments();
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,1100,500);
        bottomPanel.add(sp);
      jt.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
              String Selectedvalue=(String) jt.getValueAt(jt.getSelectedRow(),jt.getSelectedColumn());
              System.out.println(Selectedvalue);
              cell[0]=Selectedvalue;
          }

          @Override
          public void mousePressed(MouseEvent e) {

          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {

          }

          @Override
          public void mouseExited(MouseEvent e) {

          }
      });
      deleteAppointmentButton.addActionListener(dbtn->{
          Boolean deleteAppointment = AppointmentService.appointmentDeletebycontact(cell[0]);
          if (deleteAppointment) {
              JOptionPane.showMessageDialog(frame, "Appointment Deleted Successfully");
              frame.dispose();
              new AdminAppointmentUi();
          } else {
              JOptionPane.showMessageDialog(frame, "you can't click on contact");
          }
      });
      updateAppointmentButton.addActionListener(ubtn->{
          boolean send=AppointmentService.sendAppointmentChake(cell[0]);
          if(send){

              JOptionPane.showMessageDialog(frame,"is exist");
              frame.dispose();
              new AdminUpdateAppointmentUi(AppointmentService.sendAppointment(cell[0]),PatientService.updatePatient(cell[0]));
          }
          else {
              JOptionPane.showMessageDialog(frame,"is not exist");
          }

      });

    }
}
