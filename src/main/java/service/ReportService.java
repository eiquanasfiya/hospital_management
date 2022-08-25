package Service;

import Repository.ReportRepository;
import domain.Doctor;
import domain.Report;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {

    public static  String[][]  getAllReportsForJTable(int length, String startDate, String endDate) {
        ReportRepository reportRepository = new ReportRepository();
        List<Report> reports = reportRepository.getAll();
        String[][] data=new String[reports.size()][length];
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



    public static String[][] getAllReportsByDate(int length,String startDate, String endDate) {
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


    //            Double i = 0.0;
//            Double temp = 0.0;
//            for (Report report : reports) {
//                i = Double.parseDouble(report.getTotalIncome().toString());
//                temp += i;
//            }
//    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//    Integer sum = integers.stream()
//            .mapToInt(Integer::intValue)
//            .sum();
//
//public static Integer[] getAllPassengerIDs(){
//    int i=0;
//    PassengerRepository passengerRepository=new PassengerRepository();
//    Integer arr[]=new Integer[passengerRepository.getAll().size()];
//
//
//    for(PassengerInquiry flightId:passengerRepository.getAll()){
//
//        arr[i]=Integer.parseInt(flightId.getFlightID().toString());
//        i++;
//
//    }
//
//    return  arr;
//}
        public static Double totalincomeofHospital () {
            Double i = null;
            Double temp = 0.0;
            ReportRepository reportRepository = new ReportRepository();
            List<Report> allReports = reportRepository.getAll();
            for (int j = 0; j < allReports.size() - 1; j++) {
                for (Report report : reportRepository.getAll()) {
                    i = Double.parseDouble(report.getTotalIncome().toString());
                    temp += i;
                }
            }
            return temp;
        }


    public static void main(String[] args) {
      //  System.out.println(totalincomeofHospital());
    }
}