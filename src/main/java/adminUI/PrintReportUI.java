package adminUI;

import service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class PrintReportUI {
public PrintReportUI(String dateOne, String dateTwo){
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

    JLabel title=new JLabel("MONTHLY REPORT");
    JButton printReport= new JButton("PRINT REPORT");
    JButton backButton = new JButton("Back");
    backButton.setForeground(Color.WHITE);
    backButton.setBackground(Color.lightGray);
    backButton.setFont(new Font("Serif",Font.BOLD,15));
    backButton.setBounds(1450,25,100,40);

    backButton.addActionListener(btn->{
        frame.dispose();
        new ReportUI();
    });


    JTextArea textArea = new JTextArea();
    textArea.setBounds(0,0,1180,300);
    textArea.setFont(new Font("Calibri",Font.BOLD,15));
    textArea.setText(textArea.getText()+"-------------------------MONTHLY REPORT------------------------------------\n");
    textArea.setText(textArea.getText()+"FROM          "+dateOne+"\n");
    textArea.setText(textArea.getText()+"TO             "+dateTwo+"\n");
    textArea.setText(textArea.getText()+"---------------------------------------------------------------------------\n");
    textArea.setText(textArea.getText()+"Total Income                   "+ReportService.totalNumberOfPatient(dateOne, dateTwo).toString()+"\n");
    textArea.setText(textArea.getText()+"No Of totalNumberOfPatient      "+ReportService.totalNumberOfPatient(dateOne,dateTwo)+"\n");



    String colum[] = {"Doctor", "Doctor Contact", "Patient", "Patient Contact", "Date", "Time", "Doctor Fee", "Total Income"};
    String dataa[][] = ReportService.getAllReportsByDate(colum.length, dateOne, dateTwo);
    JTable jt = new JTable(dataa, colum);
    JScrollPane fp = new JScrollPane(jt);
    fp.setBounds(0, 400, 700, 325);



    MessageFormat mf = new MessageFormat(textArea.getText());
//    MessageFormat mf1 = new MessageFormat(textArea.getText()+"FROM          "+dateOne+"\n");
    MessageFormat mf2 = new MessageFormat(Integer.toString(3));


    title.setForeground(Color.DARK_GRAY);
    title.setFont(new Font("Serif",Font.BOLD,45));
    printReport.setFont(new Font("Serif",Font.BOLD,14));




    title.setBounds(40,60,400,60);

    printReport.setBounds(80,300,350,50);



    printReport.addActionListener(btn->{
        try{
//             textArea.print();
            jt.print(JTable.PrintMode.FIT_WIDTH,mf,mf2);
//            jt.print();



        }catch (Exception e){
            System.out.println(e);
        }
    });






    topPanel.add(title);
    topPanel.add(backButton);
    sidePanel.add(printReport);
    bottomPanel.add(textArea);
    bottomPanel.add(fp);



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
