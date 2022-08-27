package service;

import repository.PatientRepository;
import domain.Patient;

import java.util.List;

public class PatientService {

    public static String[][] getAllPatients() {
        PatientRepository patientRepository = new PatientRepository();
        List<Patient> patient = patientRepository.getAllPatients();
        String[][] data = new String[patient.size()][5];
        for(int row =0;row<patient.size();row++){
            data[row][0] = patient.get(row).getPatientName();
            data[row][1] = patient.get(row).getPatientAddress();
            data[row][2] = patient.get(row).getPatientContact();
            data[row][3] = String.valueOf(patient.get(row).getPatientAge());
            data[row][4] = patient.get(row).getPatientGender();
        }

        return data;
    }

    public static Boolean addPatient(String name, String address, String contact, String age, String gender) {
        PatientRepository patientRepository = new PatientRepository();
        Boolean flag = patientRepository.addPatient(name,address,contact,age,gender);
        return flag;
    }

    public static String[][] getPatientByContact(String contact) {
        PatientRepository patientRepository = new PatientRepository();
        List<Patient> patient = patientRepository.getPatientByContact(contact);
        String[][] data = new String[patient.size()][5];
        for(int row =0;row<patient.size();row++){
            data[row][0] = patient.get(row).getPatientName();
            data[row][1] = patient.get(row).getPatientAddress();
            data[row][2] = patient.get(row).getPatientContact();
            data[row][3] = String.valueOf(patient.get(row).getPatientAge());
            data[row][4] = patient.get(row).getPatientGender();
        }

        return data;
    }

    public static int getPatientIdByContact(String contact) {
        PatientRepository patientRepository = new PatientRepository();
        return patientRepository.getPatientIdByContact(contact);
    }

    public static Boolean deletebyContact(String contact) {
        PatientRepository patientRepository=new PatientRepository();
        return patientRepository.deletebyContact(contact);
    }

    public static boolean updatePatientChake(String contact) {

        PatientRepository patientRepository=new PatientRepository();
        Patient patient= patientRepository.getrowbycontact(contact);
        if(patient==null){
         return false;
        }
        return true;
    }

    public static Patient updatePatient(String contact) {
        PatientRepository patientRepository=new PatientRepository();
        Patient patient=patientRepository.getrowbycontact(contact);
        return patient;
    }

    public static boolean UpdatePatient(String name, String address, String contact, String age, String gender, String previousContact) {
        PatientRepository patientRepository=new PatientRepository();
        return patientRepository.updatePatient(name,address,contact,age,gender,previousContact);
    }
}
