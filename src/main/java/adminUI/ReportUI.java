package AdminUI;

import Service.DoctorService;
import Service.ReportService;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.math.RoundingMode;

public class ReportUI {
    public ReportUI() {
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel incomePanel1 = new JPanel();
        JPanel incomePanel2=new JPanel();
        JPanel sidePanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);
        incomePanel1.setLayout(null);
        incomePanel2.setLayout(null);
        sidePanel.setLayout(null);

        JLabel title=new JLabel("HOSPITAL REPORT");
        title.setBounds(450,30,600,50);
        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,60));

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(10, 40, 1580, 120);
        bottomPanel.setBounds(0, 0, 1600, 900);
        bottomPanel.setBackground(Color.lightGray);
        incomePanel1.setBounds(60, 180, 300, 100);
        incomePanel1.setBackground(Color.GRAY);
        incomePanel2.setBounds(10, 305, 1180, 525);
        incomePanel2.setBackground(Color.DARK_GRAY);
        sidePanel.setBounds(1200, 180, 390, 650);
        sidePanel.setBackground(Color.DARK_GRAY);

//        AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);

        JLabel totalIncome=new JLabel("Total Income    =");

        JLabel tot=new JLabel(ReportService.totalincomeofHospital().toString());
        tot.setBounds(200,10,200,35);
        tot.setFont(new Font("Serif",Font.BOLD,25));
        tot.setForeground(Color.DARK_GRAY);

        totalIncome.setBounds(10,10,200,35);
        totalIncome.setForeground(Color.DARK_GRAY);
        totalIncome.setFont(new Font("Serif",Font.BOLD,25));

        JLabel totalPatients=new JLabel("Total Patients   =");
        totalPatients.setBounds(10,50,200,35);
        totalPatients.setForeground(Color.DARK_GRAY);
        totalPatients.setFont(new Font("Serif",Font.BOLD,25));


        JTextField dateFrom=new JTextField(10);
        dateFrom.setBounds(800,220,80,30);
        dateFrom.setText("Start Date");
        JTextField dateTo=new JTextField(10);
        dateTo.setBounds(930,220,80,30);
        dateTo.setText("End Date");

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(1030,220,80,30);


        String column[]={"Doctor","Doctor Contact","Patient","Patient Contact","Date","Time","Doctor Fee","Total Income"};
        String data[][] = ReportService.getAllReportsForJTable(column.length,dateFrom.getText(),dateTo.getText());
        JTable js=new JTable(data,column);
        JScrollPane sp=new JScrollPane(js);
        sp.setBounds(0,0,1180,525);
        incomePanel2.add(sp);

        searchButton.addActionListener(btn->{
                String startDate= dateFrom.getText();
                String endDate=dateTo.getText();
                String colum[]={"Doctor","Doctor Contact","Patient","Patient Contact","Date","Time","Doctor Fee","Total Income"};
                String dataa[][] = ReportService.getAllReportsByDate(column.length,startDate,endDate);
                JTable jt=new JTable(dataa,colum);
                JScrollPane fp=new JScrollPane(jt);
                fp.setBounds(0,0,1180,525);
                incomePanel2.remove(sp);
                incomePanel2.add(fp);
        });



        container.add(topPanel);
        container.add(sidePanel);
        container.add(incomePanel1);
        container.add(incomePanel2);
        container.add(bottomPanel);
        bottomPanel.add(dateFrom);
        bottomPanel.add(dateTo);
        bottomPanel.add(searchButton);
        incomePanel1.add(totalIncome);
        incomePanel1.add(tot);
        incomePanel1.add(totalPatients);
        topPanel.add(title);



        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }

    public static void main(String[] args) {
        ReportUI reportUI=new ReportUI();

    }
}
