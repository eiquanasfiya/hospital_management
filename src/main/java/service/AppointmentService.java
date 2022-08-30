package service;

import domain.Patient;
import repository.AppointmentRepository;
import domain.Appointment;
import repository.PatientRepository;

import java.util.List;

public class AppointmentService {
    public static String[][] getAllAppointments() {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        List<Appointment> appointment = appointmentRepository.getAllAppointments();
        String[][] data = new String[appointment.size()][9];
        for (int row = 0; row < appointment.size(); row++) {
            data[row][0] = appointment.get(row).getAppointmentNumber();
            data[row][1] = appointment.get(row).getDate();
            data[row][2] = appointment.get(row).getTime();
            data[row][3] = appointment.get(row).getServiceCharges().toString();
            data[row][4] = appointment.get(row).getDoctorName();
            data[row][5] = appointment.get(row).getSpecialization();
            data[row][6] = appointment.get(row).getFee().toString();
            data[row][7] = appointment.get(row).getPatientName();
            data[row][8] = appointment.get(row).getContact();

        }
        return data;
    }

    public static String[][] getAppointmentByContact(String contact) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        List<Appointment> appointment = appointmentRepository.getAppointmentByContact(contact);
        String[][] data = new String[appointment.size()][9];
        for (int row = 0; row < appointment.size(); row++) {
            data[row][0] = appointment.get(row).getAppointmentNumber();
            data[row][1] = appointment.get(row).getDate();
            data[row][2] = appointment.get(row).getTime();
            data[row][3] = appointment.get(row).getServiceCharges().toString();
            data[row][4] = appointment.get(row).getDoctorName();
            data[row][5] = appointment.get(row).getSpecialization();
            data[row][6] = appointment.get(row).getFee().toString();
            data[row][7] = appointment.get(row).getPatientName();
            data[row][8] = appointment.get(row).getContact();

        }
        return data;
    }

    public static Boolean addAppointment(String appointmentNumber,String date, String time, Double serviceCharges, int doctorId, int patientId) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        Boolean flag = appointmentRepository.addAppointment(appointmentNumber,date,time,serviceCharges,doctorId,patientId);
        return flag;
    }

    public static int getAppointmentIdByAppointmentNumber(String appointmentNumber) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        return appointmentRepository.getAppointmentIdByAppointmentNumber(appointmentNumber);
    }

    public static String getLatestAppointmentNumber() {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        return appointmentRepository.getLatestAppointmentNumber();
    }

    public static Boolean appointmentDeletebycontact(String contact) {
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        return appointmentRepository.appointmentDeletebycontact(contact);
    }
    public static boolean sendAppointmentChake(String contact) {

        AppointmentRepository appointmentRepository=new AppointmentRepository();
        Appointment appointment= appointmentRepository.sendChakeAppoindmentData(contact);
        if(appointment==null){
            return false;
        }
        return true;
    }

    public static Appointment sendAppointment(String contact) {
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        Appointment appointment=appointmentRepository.sendChakeAppoindmentData(contact);
        return appointment;
    }


    public static boolean updateAppointment(String appointmentNumber, String date, String time, int doctor_id, int patient_id,String patientContact) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        return appointmentRepository.updateAppointment(appointmentNumber,date,time,doctor_id,patient_id,patientContact);
    }
}