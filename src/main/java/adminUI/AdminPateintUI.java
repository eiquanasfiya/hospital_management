package adminUI;

import service.PatientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicReference;

public class AdminPateintUI {
    public AdminPateintUI(){

      JTable jt;
       JScrollPane sp;





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

        JLabel title=new JLabel("PATEINT");
        JLabel search=new JLabel("Enter Contact");
        JLabel error = new JLabel();

        JTextField searchBox=new JTextField(12);


        JButton deletePateintButton= new JButton("DELETE PATEINT");
        JButton updatePateintButton= new JButton("UPDATE PATEINT");
        JButton backButton = new JButton("Back");
        JButton searchButton=new JButton("Search");




        title.setBounds(20,40,400,60);



        deletePateintButton.setBounds(80,200,350,50);
        updatePateintButton.setBounds(80,300,350,50);
        backButton.setBounds(1450,45,100,40);
        searchButton.setBounds(900,48,100,30);
        searchBox.setBounds(750,48,120,30);
        search.setBounds(620,45,150,40);




        title.setFont(new Font("Serif",Font.BOLD,45));
        backButton.setFont(new Font("Serif",Font.BOLD,15));

        deletePateintButton.setFont(new Font("Serif",Font.BOLD,14));
        updatePateintButton.setFont(new Font("Serif",Font.BOLD,14));
        searchButton.setFont(new Font("Serif",Font.BOLD,16));
        search.setFont(new Font("Serif",Font.BOLD,18));

        backButton.setForeground(Color.WHITE);
        searchButton.setForeground(Color.WHITE);

        updatePateintButton.setForeground(Color.DARK_GRAY);
        deletePateintButton.setForeground(Color.DARK_GRAY);

        backButton.setBackground(Color.lightGray);
        searchButton.setBackground(Color.lightGray);
        searchBox.setBackground(Color.WHITE);


            deletePateintButton.setBackground(Color.lightGray);
            updatePateintButton.setBackground(Color.lightGray);
        title.setForeground(Color.DARK_GRAY);
        String column[]={"Name","Address","Contact","Age","Gender"};
        String data[][] = PatientService.getAllPatients();
         jt =new JTable(data, column);
         sp=new JScrollPane(jt);
        sp.setBounds(0,0,1100,500);
        bottomPanel.add(sp);


        searchButton.addActionListener(sbtn->{
           String[] column1={"Name","Address","Contact","Age","Gender"};
           String[][] data1 = PatientService.getPatientByContact(searchBox.getText());
            JTable jt1=new JTable(data1, column1);
            JScrollPane sp1=new JScrollPane(jt1);
            sp1.setBounds(0,0,1100,500);
            bottomPanel.add(sp1);
        });




//        String column[]={"Name","Age","Address","Contact","Gender"};
//        String data[][] ={{"ali","asfi"},{"18","20"},{"H-88-11","H-88-10"},{"03108693669","1234566"},{"male","male"}};
//// DoctorService.getAllFlightsForJTable(column.length);
//        JTable jt=new JTable(data,column);
//        JScrollPane jp=new JScrollPane(jt);
//        jp.setBounds(0,0,1100,500);
//        bottomPanel.add(jp);
        final String[] cell = new String[1];


        jt.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String selectedCellValue = (String) jt.getValueAt(jt.getSelectedRow() , jt.getSelectedColumn());
                cell[0] =selectedCellValue;
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });

//        backButton.addActionListener(btn->{
//            frame.dispose();
//            new AdminUI();
//        });
//        addDoctorButton.addActionListener(btn->{
//            frame.dispose();
//            new AddDoctorUI();
//        });
//        updateDoctorButton.addActionListener(btn->{
//            Boolean searchDoctor = DoctorService.searchDoctorFromAdmin(cell[0]);
//            if (searchDoctor) {
//                JOptionPane.showMessageDialog(frame, "Doctor Exist");
//                new UpdateDoctorUI(DoctorService.searchDoctorForUpdate(cell[0]));
//                frame.dispose();
//
//            } else {
//                JOptionPane.showMessageDialog(frame, " Doctor not Exist");
//            }
////
//        });
        deletePateintButton.addActionListener(btn->{
            Boolean deletePatint = PatientService.deletebyContact(cell[0]);
            if (deletePatint) {
                JOptionPane.showMessageDialog(frame, "Pateint Deleted Successfully");
                frame.dispose();
                new AdminPateintUI();
            } else {
                JOptionPane.showMessageDialog(frame, "you can't click on contact");
            }
        });
        updatePateintButton.addActionListener(ubtn->{
           boolean updatePatient=PatientService.updatePatientChake(cell[0]);
           if(updatePatient){

           JOptionPane.showMessageDialog(frame,"is exist");
           frame.dispose();
           new UpdatePateintUI(PatientService.updatePatient(cell[0]));
           }
           else {
           JOptionPane.showMessageDialog(frame,"is not exist");
           }

        });
     backButton.addActionListener(b->{
         frame.dispose();
         new AdminUI();
     });



        topPanel.add(title);
        topPanel.add(backButton);
        topPanel.add(searchButton);
        topPanel.add(search);
        topPanel.add(searchBox);
        sidePanel.add(updatePateintButton);
        sidePanel.add(deletePateintButton);



        container.add(topPanel);
        container.add(bottomPanel);
        container.add(sidePanel);

        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);







//        searchButton.addActionListener(btn->
//        {
//            String getContact=searchBox.getText();
//
//
//
//        });




    }

}
