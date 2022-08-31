package service;

import repository.ReportRepository;
import domain.Report;

import java.time.LocalDate;
import java.util.List;

public class ReportService {

    public static String[][] getAllReportsForJTable(int length) {
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

    public static String[][] getMonthlyReportForJTable(int length, String month, String year) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> reports = reportRepository.getMonthlyIncome(month, year);
        String[][] data = new String[reports.size()][length];
        for (int row = 0; row < reports.size(); row++) {
            data[row][0] = reports.get(row).getDate();
            data[row][1] = reports.get(row).getTime();
            data[row][2] = reports.get(row).getTotalIncome().toString();
        }
        return data;
    }


    public static Boolean searchRecord(String month, String year) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> search = reportRepository.getMonthlyIncome(month, year);
        if (search.size() != 0) {
            return true;
        }
        return false;
    }

    public static Double totalIncomeOfMonth(String month, String year) {
        ReportRepository reportRepository = new ReportRepository();
        Double i = null;

        if (searchRecord(month, year)) {
            Double temp = 0.0;
            List<Report> allReports = reportRepository.getMonthlyIncome(month, year);
            for (int j = 0; j <= allReports.size() - 1; j++) {
                for (Report report : reportRepository.getMonthlyIncome(month, year)) {
                    i = Double.parseDouble(report.getTotalIncome().toString());
                    temp += i;
                }
                return temp;
            }
        }
        return null;
    }

    public static Integer totalNumberOfPatientByMonth(String month, String year) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> allReports = reportRepository.getMonthlyIncome(month, year);
        return allReports.size();
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
        if (startDate != null && endDate != null ) {
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
        if(startDate != null && endDate != null) {
            List<Report> allReports = reportRepository.getAllBetweenTwoDates(startDate, endDate);
            return allReports.size();
        } else {
            List<Report> allReports = reportRepository.getAll();
            return allReports.size();
        }
    }


}