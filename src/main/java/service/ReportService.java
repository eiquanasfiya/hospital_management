package service;

import repository.ReportRepository;
import domain.Report;

import java.time.LocalDate;
import java.util.List;

public class ReportService {

    public static String[][] getAllReportsForJTable(int length, String startDate, String endDate) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> reports = reportRepository.getAll();
        String[][] data = new String[reports.size()][length];
        for (int row = 0; row < reports.size(); row++) {
            data[row][0] = reports.get(row).getDoctorName();
            data[row][1] = reports.get(row).getDoctorContact();
            data[row][2] = reports.get(row).getPatientName();
            data[row][3] = reports.get(row).getPatientContact();
            data[row][4] = reports.get(row).getDate();
            data[row][5] = reports.get(row).getTime();
            data[row][6] = reports.get(row).getDoctorCharges().toString();
            data[row][7] = reports.get(row).getTotalIncome().toString();

        }
        return data;
    }


    public static String[][] getAllReportsByDate(int length, String startDate, String endDate) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> reports = reportRepository.getAllBetweenTwoDates(startDate, endDate);
        String[][] data = new String[reports.size()][length];
        for (int row = 0; row < reports.size(); row++) {
            data[row][0] = reports.get(row).getDoctorName();
            data[row][1] = reports.get(row).getDoctorContact();
            data[row][2] = reports.get(row).getPatientName();
            data[row][3] = reports.get(row).getPatientContact();
            data[row][4] = reports.get(row).getDate();
            data[row][5] = reports.get(row).getTime();
            data[row][6] = reports.get(row).getDoctorCharges().toString();
            data[row][7] = reports.get(row).getTotalIncome().toString();
        }
        return data;
    }

    public static Double totalincomeofHospital(String startDate, String endDate) {
        ReportRepository reportRepository = new ReportRepository();
        Double i = null;

        if (startDate != null && !startDate.equalsIgnoreCase(LocalDate.now().toString()) && endDate != null &&
                !endDate.equalsIgnoreCase(LocalDate.now().toString())) {
            Double temp = 0.0;
            List<Report> allReports = reportRepository.getAllBetweenTwoDates(startDate, endDate);
            for (int j = 0; j <= allReports.size() - 1; j++) {
                for (Report report : reportRepository.getAllBetweenTwoDates(startDate, endDate)) {
                    i = Double.parseDouble(report.getTotalIncome().toString());
                    temp += i;
                }
                return temp;
            }
        } else {
            Double temp = 0.0;
            List<Report> allReports = reportRepository.getAll();
            for (int j = 0; j <= allReports.size() - 1; j++) {
                for (Report report : reportRepository.getAll()) {
                    i = Double.parseDouble(report.getTotalIncome().toString());
                    temp += i;
                }
                return temp;
            }
        }
        return null;
    }

    public static Integer totalNumberOfPatient(String startDate, String endDate) {
        ReportRepository reportRepository = new ReportRepository();
        if (startDate != null && !startDate.equalsIgnoreCase(LocalDate.now().toString()) && endDate != null &&
                !endDate.equalsIgnoreCase(LocalDate.now().toString())) {
            List<Report> allReports = reportRepository.getAllBetweenTwoDates(startDate, endDate);
            return allReports.size();
        } else {
            List<Report> allReports = reportRepository.getAll();
            return allReports.size();
        }
    }









    public static void main(String[] args) {
        System.out.println(totalincomeofHospital("2022-11-07","2022-11-07"));
    }
}