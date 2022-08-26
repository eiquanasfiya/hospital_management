package adminUI;

import service.ReportService;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

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
        JLabel title2=new JLabel("DAILY INCOME REPORT");
        JLabel label3=new JLabel("From");
        JLabel label4=new JLabel("To");

        title.setBounds(450,30,600,50);
        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif",Font.BOLD,60));
        title2.setBounds(50,30,400,50);
        title2.setForeground(Color.DARK_GRAY);
        title2.setFont(new Font("Serif",Font.BOLD,26));
        label3.setBounds(600,220,130,27);
        label4.setBounds(805,220,130,27);

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.lightGray);
        backButton.setFont(new Font("Serif",Font.BOLD,15));
        backButton.setBounds(1450,25,100,40);

        backButton.addActionListener(btn->{
            frame.dispose();
            new adminUI.AdminUI();
        });

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(10, 40, 1580, 120);
        bottomPanel.setBounds(0, 0, 1600, 900);
        bottomPanel.setBackground(Color.lightGray);
        incomePanel1.setBounds(60, 180, 300, 100);
        incomePanel1.setBackground(Color.GRAY);
        incomePanel2.setBounds(10, 305, 1180, 525);
        incomePanel2.setBackground(Color.DARK_GRAY);
        sidePanel.setBounds(1200, 180, 390, 650);
        sidePanel.setBackground(Color.GRAY);

//        AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);

        JLabel totalIncome=new JLabel("Total Income    =");



        totalIncome.setBounds(10,10,200,35);
        totalIncome.setForeground(Color.DARK_GRAY);
        totalIncome.setFont(new Font("Serif",Font.BOLD,25));

        JLabel totalPatients=new JLabel("Total Patients   =");
        totalPatients.setBounds(10,50,200,35);
        totalPatients.setForeground(Color.DARK_GRAY);
        totalPatients.setFont(new Font("Serif",Font.BOLD,25));


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(1030,220,80,30);

///////////////////////////////////////////////////CALENDAR-SECTION///////////////////////////////////
        Date _dte1 = Date.from(Instant.now());
        UtilDateModel model = new UtilDateModel(_dte1);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DataLabelFormatter());
        datePicker.setBounds(650,220,130,27);
        bottomPanel.add(datePicker);

        Date _dte2 = Date.from(Instant.now());
        UtilDateModel model1 = new UtilDateModel(_dte2);
        Properties f = new Properties();
        f.put("text.today", "Today");
        f.put("text.month", "Month");
        f.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, f);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DataLabelFormatter());
        datePicker1.setBounds(830,220,130,27);
        bottomPanel.add(datePicker1);

        Date selectedValue1= (Date) datePicker.getModel().getValue();
        LocalDate _date1 = selectedValue1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date selectedValue2= (Date) datePicker1.getModel().getValue();
        LocalDate _date2 = selectedValue2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        String date1=_date1.toString();
        String date2=_date2.toString();
        ///////////////////////////////////ALL _RECORDS///////////////////////////

        String column[]={"Doctor","Doctor Contact","Patient","Patient Contact","Date","Time","Doctor Fee","Total Income"};
        String data[][] = ReportService.getAllReportsForJTable(column.length,date1,date2);
        JTable js=new JTable(data,column);
        JScrollPane sp=new JScrollPane(js);
        sp.setBounds(0,0,1180,525);
        incomePanel2.add(sp);
/////////////////////////////////////////TOTAL INCOME/////////////////////////////////////////////
        String val=ReportService.totalincomeofHospital(date1,date2).toString();
        System.out.println(val);
        JTextField tot=new JTextField(val);
        tot.setBounds(200,10,100,35);
        tot.setFont(new Font("Serif",Font.BOLD,25));
        tot.setBackground(Color.GRAY);
        tot.setEditable(false);
        tot.setForeground(Color.DARK_GRAY);
        incomePanel1.add(tot);
//        ////////////////////////////////TOTAL PATIENT/////////////////////////////////////////////////////
        String patient=ReportService.totalNumberOfPatient(date1,date2).toString();
        JTextField totPatient=new JTextField(patient);
        totPatient.setBounds(200,50,100,35);
        totPatient.setFont(new Font("Serif",Font.BOLD,25));
        totPatient.setBackground(Color.GRAY);
        totPatient.setEditable(false);
        totPatient.setForeground(Color.DARK_GRAY);
        incomePanel1.add(totPatient);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        searchButton.addActionListener(btn->{
            Date selectedValue11= (Date) datePicker.getModel().getValue();
            LocalDate _date11 = selectedValue11.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date selectedValue22= (Date) datePicker1.getModel().getValue();
            LocalDate _date22 = selectedValue22.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String date11=_date11.toString();
            String date22=_date22.toString();
            System.out.println(date22);
            System.out.println(date11);


             ///////////////////////////////////////SEARCH RECORD ACCORDING TO DATE///////////////////////////

                String colum[]={"Doctor","Doctor Contact","Patient","Patient Contact","Date","Time","Doctor Fee","Total Income"};
                String dataa[][] = ReportService.getAllReportsByDate(colum.length,date11,date22);
                JTable jt=new JTable(dataa,colum);
                JScrollPane fp=new JScrollPane(jt);
                fp.setBounds(0,0,1180,525);
                incomePanel2.remove(sp);
                incomePanel2.add(fp);
        ///////////////////////////////////////TOTAL INCOME ACCORDING TO DATE///////////////////////////
            String val2=ReportService.totalincomeofHospital(date11,date22).toString();
            System.out.println(val2);
            JTextField tota=new JTextField(val2);
            tota.setBounds(200,10,100,35);
            tota.setFont(new Font("Serif",Font.BOLD,25));
            tota.setBackground(Color.GRAY);
            tota.setForeground(Color.DARK_GRAY);
            tota.setEditable(false);
            incomePanel1.remove(tot);
            incomePanel1.add(tota);
            ///////////////////////////////////////TOTAL PATIENT ACCORDING TO DATE///////////////////////////
            String patients=ReportService.totalNumberOfPatient(date11,date22).toString();
            System.out.println(patients);
            JTextField totPatients=new JTextField(patients);
            totPatients.setBounds(200,50,100,35);
            totPatients.setFont(new Font("Serif",Font.BOLD,25));
            totPatients.setBackground(Color.GRAY);
            totPatients.setEditable(false);
            totPatients.setForeground(Color.DARK_GRAY);
            incomePanel1.add(totPatients);


        });


        container.add(topPanel);
        container.add(sidePanel);
        container.add(incomePanel1);
        container.add(incomePanel2);
        container.add(bottomPanel);

        bottomPanel.add(searchButton);
        incomePanel1.add(totalIncome);
        bottomPanel.add(label3);
        bottomPanel.add(label4);


        incomePanel1.add(totalPatients);
        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(title2);



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
