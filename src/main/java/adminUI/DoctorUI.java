package adminUI;

import service.DoctorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
            JLabel search=new JLabel("Enter Contact");
            JLabel error = new JLabel();

            JTextField searchBox=new JTextField(12);

            JButton addDoctorButton= new JButton("ADD DOCTOR");
            JButton deleteDoctorButton= new JButton("DELETE DOCTOR");
            JButton updateDoctorButton= new JButton("UPDATE DOCTOR");
            JButton backButton = new JButton("Back");
            JButton searchButton=new JButton("Search");




            title.setBounds(20,40,400,60);


            addDoctorButton.setBounds(80,100,350,50);
            deleteDoctorButton.setBounds(80,200,350,50);
            updateDoctorButton.setBounds(80,300,350,50);
            backButton.setBounds(1450,45,100,40);
            searchButton.setBounds(900,48,100,30);
            searchBox.setBounds(750,48,120,30);
            search.setBounds(620,45,150,40);




            title.setFont(new Font("Serif",Font.BOLD,45));
            backButton.setFont(new Font("Serif",Font.BOLD,15));
            addDoctorButton.setFont(new Font("Serif",Font.BOLD,14));
            deleteDoctorButton.setFont(new Font("Serif",Font.BOLD,14));
            updateDoctorButton.setFont(new Font("Serif",Font.BOLD,14));
            searchButton.setFont(new Font("Serif",Font.BOLD,16));
            search.setFont(new Font("Serif",Font.BOLD,18));

            backButton.setForeground(Color.WHITE);
            searchButton.setForeground(Color.WHITE);
            addDoctorButton.setForeground(Color.DARK_GRAY);
            updateDoctorButton.setForeground(Color.DARK_GRAY);
            deleteDoctorButton.setForeground(Color.DARK_GRAY);

            backButton.setBackground(Color.lightGray);
            searchButton.setBackground(Color.lightGray);
            searchBox.setBackground(Color.WHITE);
//            addDoctorButton.setBackground(Color.lightGray);
//            deleteDoctorButton.setBackground(Color.lightGray);
//            updateDoctorButton.setBackground(Color.lightGray);
            title.setForeground(Color.DARK_GRAY);

            String column[]={"Name","Address","Specialization","Contact","Doctor Fee"};
            String data[][] = DoctorService.getAllFlightsForJTable(column.length);
            JTable jt=new JTable(data,column);
            JScrollPane jp=new JScrollPane(jt);
            jp.setBounds(0,0,1100,500);
            bottomPanel.add(jp);
            final String[] cell = new String[1];
            jt.addMouseListener(new MouseListener() {
                @Override
                public void mouseReleased(MouseEvent e) {
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    String selectedCellValue = (String) jt.getValueAt(jt.getSelectedRow() , jt.getSelectedColumn());
                    System.out.println(selectedCellValue);
                    cell[0] =selectedCellValue;


                }
                @Override
                public void mouseExited(MouseEvent e) {
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });

            backButton.addActionListener(btn->{
                frame.dispose();
                new AdminUI();
            });
            addDoctorButton.addActionListener(btn->{
                frame.dispose();
                new adminUI.AddDoctorUI();
            });
            updateDoctorButton.addActionListener(btn->{
                Boolean searchDoctor = DoctorService.searchDoctorFromAdmin(cell[0]);
                if (searchDoctor) {
                    JOptionPane.showMessageDialog(frame, "Doctor Exist");
                    new UpdateDoctorUI(DoctorService.searchDoctorForUpdate(cell[0]));
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, " Doctor not Exist");
                }
//
            });
            deleteDoctorButton.addActionListener(btn->{
                Boolean searchDoctor = DoctorService.deleteDoctorFromAdmin(cell[0]);
                if (searchDoctor) {
                    JOptionPane.showMessageDialog(frame, "Doctor Deleted Successfully");
                    new DoctorUI();
                    frame.dispose();


                } else {
                    JOptionPane.showMessageDialog(frame, " Doctor not Exist");
                }



            });




            topPanel.add(title);
            topPanel.add(backButton);
            topPanel.add(searchButton);
            topPanel.add(search);
            topPanel.add(searchBox);
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







            searchButton.addActionListener(btn->
            {
                String getContact=searchBox.getText();

                Boolean searchedDoctor=DoctorService.searchDoctorFromAdmin(getContact);

                error.setBounds(450,100,400,950);
                error.setFont(new Font("Serif", Font.BOLD, 25));

                error.setForeground(Color.red);

                if(searchedDoctor) {
                    String colum[] = {"Name", "Address", "Specialization", "Contact", "Doctor Fee"};
                    String dat[][] = DoctorService.showSearchedField(getContact, colum.length);
                    JTable jc = new JTable(dat, colum);
                    JScrollPane sp = new JScrollPane(jc);
                    sp.setBounds(0, 0, 1100, 500);
                    bottomPanel.add(sp);
                    bottomPanel.remove(jp);
                    error.setText("Doctor found");

                    jc.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            String selectedCellValue = (String) jc.getValueAt(jc.getSelectedRow() , jc.getSelectedColumn());
                            cell[0] =selectedCellValue;
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        }
                    });
                }
                else
                {
                    error.setText("Doctor not found");
                    bottomPanel.add(error);

                }


            });




        }

    public static void main(String[] args) {
        DoctorUI login=new DoctorUI();
    }
}

