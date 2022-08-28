package repository;

import domain.Report;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository extends BaseConnection{
    public List<Report> getAll(){
        List<Report> allReports =new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from report\n" +
                    "left join appointment\n" +
                    "ON report.appointment_id = appointment.id\n" +
                    "left join doctor\n" +
                    "on appointment.doctor_id=doctor.id " +
                    "left join patient\n" +
                    "on appointment.patient_id=patient.id;");
            while (rs.next()){
                Report report=new Report();
                report.populate(rs);
                allReports.add(report);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allReports;
    }

    public List<Report> getAllBetweenTwoDates(String startDate, String endDate){
        List<Report> reportsByDate =new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from report\n" +
                    "                    left join appointment\n" +
                    "                    ON report.appointment_id = appointment.id\n" +
                    "                    left join doctor\n" +
                    "                    on appointment.doctor_id=doctor.id \n" +
                    "                    left join patient\n" +
                    "                    on appointment.patient_id=patient.id\n" +
                    "\t\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tdate BETWEEN \n" +
                    "                    '"+startDate+"' AND '"+endDate+"';");
            while (rs.next()){
                Report report=new Report();
                report.populate(rs);
                reportsByDate.add(report);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return reportsByDate;

    }


    public List<Report> getMonthlyIncome(String month,String year){
        List<Report> monthlyReports =new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from report\n" +
                    "left join appointment\n" +
                    "ON report.appointment_id = appointment.id\n" +
                    "left join doctor\n" +
                    "on appointment.doctor_id=doctor.id \n" +
                    "      left join patient\n" +
                    "                    on appointment.patient_id=patient.id\n" +
                    "   WHERE MONTH(date) = '"+month+"' AND YEAR(date) = '"+year+"';");
            while (rs.next()){
                Report report=new Report();
                report.populate(rs);
                monthlyReports.add(report);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return monthlyReports;

    }

//    public static void main(String[] args) {
//        ReportRepository reportRepository=new ReportRepository();
//        reportRepository.getAll().forEach(fl-> System.out.println(fl));
//
//    }

}
