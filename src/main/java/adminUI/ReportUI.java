package adminUI;

import domain.Doctor;
import repository.DoctorRepository;
import service.ReportService;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ReportUI {
    public ReportUI() {
        JFrame frame = new JFrame("HOSPITAL MANAGEMENT SYSTEM");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel incomePanel1 = new JPanel();
        JPanel incomePanel2 = new JPanel();
        JPanel sidePanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);
        incomePanel1.setLayout(null);
        incomePanel2.setLayout(null);
        sidePanel.setLayout(null);

        JLabel title = new JLabel("HOSPITAL REPORT");
        JLabel title2 = new JLabel("MONTHLY INCOME REPORT");
        JLabel label3 = new JLabel("From");
        JLabel label4 = new JLabel("To");
        JLabel label5 = new JLabel("Month");
        JLabel label6 = new JLabel("Year");
        JLabel label7 = new JLabel("total income =");
        JLabel label8 = new JLabel("no of patients");

        title.setBounds(450, 30, 600, 50);
        title.setForeground(Color.DARK_GRAY);
        title.setFont(new Font("Serif", Font.BOLD, 60));
        title2.setBounds(20, 30, 400, 50);
        title2.setForeground(Color.DARK_GRAY);
        title2.setFont(new Font("Serif", Font.BOLD, 24));
        label3.setBounds(600, 220, 130, 27);
        label4.setBounds(805, 220, 130, 27);
        label5.setBounds(30, 120, 130, 27);
        label6.setBounds(120, 120, 130, 27);
        label7.setBounds(200, 500, 160, 50);
        label8.setBounds(200, 520, 160, 50);
        JTextField incomeMonth = new JTextField();
        JTextField patientByMonth = new JTextField();
        incomeMonth.setBounds(290, 513, 60, 20);
        patientByMonth.setBounds(290, 533, 60, 20);
        JTextField month = new JTextField("10");
        JTextField year = new JTextField("2022");
        month.setBounds(70, 120, 40, 27);
        year.setBounds(160, 120, 60, 27);
        JButton monthlyReportBtn = new JButton("Search");
        monthlyReportBtn.setBounds(250, 120, 100, 27);
        JLabel error = new JLabel();

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.lightGray);
        backButton.setFont(new Font("Serif", Font.BOLD, 15));
        backButton.setBounds(1450, 25, 100, 40);

        JButton printBtn = new JButton("Print Report By Date" );
        printBtn.setBounds(10, 570, 370, 50);

        JButton printBtn2=new JButton("Print");
        printBtn2.setBounds(1000, 470, 100, 30);

        backButton.addActionListener(btn -> {
            frame.dispose();
            new AdminUI();
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

        JLabel totalIncome = new JLabel("Total Income    =");


        totalIncome.setBounds(10, 10, 200, 35);
        totalIncome.setForeground(Color.DARK_GRAY);
        totalIncome.setFont(new Font("Serif", Font.BOLD, 25));

        JLabel totalPatients = new JLabel("Total Patients   =");
        totalPatients.setBounds(10, 50, 200, 35);
        totalPatients.setForeground(Color.DARK_GRAY);
        totalPatients.setFont(new Font("Serif", Font.BOLD, 25));


        JButton searchButton = new JButton("Search");
        searchButton.setBounds(1010, 220, 80, 30);
        JButton searchBackBtn = new JButton("<");
        searchBackBtn.setBounds(1130, 220, 50, 30);

        ///////////////////////////////////////////////////CALENDAR-SECTION///////////////////////////////////
        Date _dte1 = Date.from(Instant.now());
        UtilDateModel model = new UtilDateModel(_dte1);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DataLabelFormatter());
        datePicker.setBounds(650, 220, 130, 27);
        bottomPanel.add(datePicker);

        Date _dte2 = Date.from(Instant.now());
        UtilDateModel model1 = new UtilDateModel(_dte2);
        Properties f = new Properties();
        f.put("text.today", "Today");
        f.put("text.month", "Month");
        f.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, f);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DataLabelFormatter());
        datePicker1.setBounds(830, 220, 130, 27);
        bottomPanel.add(datePicker1);

        ///////////////////////////////////ALL _RECORDS///////////////////////////

        String column[] = {"Doctor", "Doctor Contact", "Patient", "Patient Contact", "Date", "Time", "Doctor Fee", "Total Income"};
        String data[][] = ReportService.getAllReportsForJTable(column.length);
        JTable js = new JTable(data, column);
        JScrollPane sp = new JScrollPane(js);
        sp.setBounds(0, 0, 1180, 425);
        incomePanel2.add(sp);
        incomePanel2.add(printBtn2);
        /////////////////////////////////////////TOTAL INCOME/////////////////////////////////////////////
        String val = ReportService.totalincomeofHospital(null, null).toString();
        JTextField tot = new JTextField(val);
        tot.setBounds(200, 10, 100, 35);
        tot.setFont(new Font("Serif", Font.BOLD, 25));
        tot.setBackground(Color.GRAY);
        tot.setEditable(false);
        tot.setForeground(Color.DARK_GRAY);
        incomePanel1.add(tot);

        //        ////////////////////////////////TOTAL PATIENT/////////////////////////////////////////////////////
        String patient = ReportService.totalNumberOfPatient(null, null).toString();
        JTextField totPatient = new JTextField(patient);
        totPatient.setBounds(200, 50, 100, 35);
        totPatient.setFont(new Font("Serif", Font.BOLD, 25));
        totPatient.setBackground(Color.GRAY);
        totPatient.setEditable(false);
        totPatient.setForeground(Color.DARK_GRAY);
        incomePanel1.add(totPatient);
////////////////////////////////////////////////////////SEARCH-BUTTON SECTION/////////////////////////////////////////////////////

        searchButton.addActionListener(btn -> {
            Date selectedValue11 = (Date) datePicker.getModel().getValue();
            LocalDate _date11 = selectedValue11.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date selectedValue22 = (Date) datePicker1.getModel().getValue();
            LocalDate _date22 = selectedValue22.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Integer dateOneDay=_date11.getDayOfMonth();
            Integer dateOneMonth=_date11.getDayOfMonth();
            Integer  dateOneYear=_date11.getYear();
            Integer dateTwoDay=_date22.getDayOfMonth();
            Integer dateTwoMonth=_date11.getDayOfMonth();
            Integer dateTwoYear=_date11.getYear();

            String date11 = _date11.toString();
            String date22 = _date22.toString();

            ///////////////////////////////////////SEARCH RECORD ACCORDING TO DATE///////////////////////////
            if(dateOneDay<=dateTwoDay && dateOneMonth<=dateTwoMonth && dateOneYear<=dateTwoYear){
            String colum[] = {"Doctor", "Doctor Contact", "Patient", "Patient Contact", "Date", "Time", "Doctor Fee", "Total Income"};
            String dataa[][] = ReportService.getAllReportsByDate(colum.length, date11, date22);
            JTable jt = new JTable(dataa, colum);
            JScrollPane fp = new JScrollPane(jt);
            fp.setBounds(0, 0, 1180, 525);
            incomePanel2.remove(sp);
            incomePanel2.add(fp);
            ///////////////////////////////////////TOTAL INCOME ACCORDING TO DATE///////////////////////////
            String val2 = ReportService.totalincomeofHospital(date11, date22).toString();
            System.out.println(val2);
            JTextField tota = new JTextField(val2);
            tota.setBounds(200, 10, 100, 35);
            tota.setFont(new Font("Serif", Font.BOLD, 25));
            tota.setBackground(Color.GRAY);
            tota.setForeground(Color.DARK_GRAY);
            tota.setEditable(false);
            incomePanel1.remove(tot);
            incomePanel1.add(tota);
            ///////////////////////////////////////TOTAL PATIENT ACCORDING TO DATE///////////////////////////
            String patients = ReportService.totalNumberOfPatient(date11, date22).toString();
            System.out.println(patients);
            JTextField totPatients = new JTextField(patients);
            totPatients.setBounds(200, 50, 100, 35);
            totPatients.setFont(new Font("Serif", Font.BOLD, 25));
            totPatients.setBackground(Color.GRAY);
            totPatients.setEditable(false);
            totPatients.setForeground(Color.DARK_GRAY);
            incomePanel1.add(totPatients);
            }else {
                JOptionPane.showMessageDialog(frame,"Second Date Must be Greater or Equal than first Date");
            }
        });



        ///////////////////////////////////////////////////////////////////////////////////////////////

        monthlyReportBtn.addActionListener(btn -> {
            String monthText = month.getText();
            String yearText = year.getText();
            Integer check = Integer.parseInt(month.getText());
            Integer checkYear = Integer.parseInt(year.getText());
            System.out.println(monthText);
            ///////////////////////////////////ALL_Monthly _RECORDS///////////////////////////
            Boolean searchRec = ReportService.searchRecord(monthText, yearText);
            if (check <= 12 && check > 0 && checkYear >= 2020 && checkYear < 2999) {
                if (searchRec) {
                    incomeMonth.setText(ReportService.totalIncomeOfMonth(monthText, yearText).toString());
                    patientByMonth.setText(ReportService.totalNumberOfPatientByMonth(monthText, yearText).toString());
                    incomeMonth.setEditable(false);
                    incomeMonth.setForeground(Color.DARK_GRAY);
                    patientByMonth.setEditable(false);
                    patientByMonth.setForeground(Color.DARK_GRAY);
                    sidePanel.add(label7);
                    sidePanel.add(label8);
                    sidePanel.add(incomeMonth);
                    sidePanel.add(patientByMonth);
                    String columnn[] = {"Date", "Time", "Total Amount"};
                    String datta[][] = ReportService.getMonthlyReportForJTable(columnn.length, monthText, yearText);
                    JTable jss = new JTable(datta, columnn);
                    JScrollPane spp = new JScrollPane(jss);
                    spp.setBounds(0, 200, 390, 300);
                    sidePanel.add(spp);
                    JOptionPane.showMessageDialog(frame, "Record Found");
                } else {
                    JOptionPane.showMessageDialog(frame, "Record Not Found");
                }
            } else {
                error.setBounds(160, 400, 300, 15);
                error.setText("INVALID MONTH");
                error.setForeground(Color.red);
            }

        });
        searchBackBtn.addActionListener(btn -> {
            frame.dispose();
            new ReportUI();

        });

        /////////////////////////////////////GET CURRENT MONTH REPORT///////////////////////////////////
        Integer currentYear=LocalDate.now().getYear();
        Integer currentMonth=new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
        String curYear=currentYear.toString();
        String curMonth=currentMonth.toString();
        System.out.println(curYear);
        System.out.println(curMonth);
        String columnnn[] = {"Date", "Time", "Total Amount"};
        String dattaa[][] = ReportService.getMonthlyReportForJTable(columnnn.length,curMonth,curYear);
        JTable jsss = new JTable(dattaa, columnnn);
        JScrollPane sppp = new JScrollPane(jsss);
        sppp.setBounds(0, 200, 390, 300);
        sidePanel.add(sppp);
        incomeMonth.setText(ReportService.totalIncomeOfMonth(curMonth, curYear).toString());
        patientByMonth.setText(ReportService.totalNumberOfPatientByMonth(curMonth, curYear).toString());
        incomeMonth.setEditable(false);
        incomeMonth.setForeground(Color.DARK_GRAY);
        patientByMonth.setEditable(false);
        patientByMonth.setForeground(Color.DARK_GRAY);
        sidePanel.add(incomeMonth);
        sidePanel.add(patientByMonth);

        /////////////////////////////////////////////////////////////////////////////////////////////////

//        printBtn2.addActionListener();

        printBtn.addActionListener(btn -> {

            Date selectedValue11 = (Date) datePicker.getModel().getValue();
            LocalDate _date11 = selectedValue11.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date selectedValue22 = (Date) datePicker1.getModel().getValue();
            LocalDate _date22 = selectedValue22.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String date11 = _date11.toString();
            String date22 = _date22.toString();
            frame.dispose();
            new PrintReportUI(date11, date22);


        });
        printBtn2.addActionListener(btn -> {

            frame.dispose();
            new PrintReportUI();
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
        sidePanel.add(printBtn);


        incomePanel1.add(totalPatients);
        topPanel.add(title);
        topPanel.add(backButton);
        sidePanel.add(title2);
        sidePanel.add(label5);
        sidePanel.add(label6);
        sidePanel.add(month);
        sidePanel.add(year);
        sidePanel.add(monthlyReportBtn);
        sidePanel.add(error);
        sidePanel.add(label7);
        sidePanel.add(label8);
        bottomPanel.add(searchBackBtn);


        frame.setLayout(null);
        //    frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }

}