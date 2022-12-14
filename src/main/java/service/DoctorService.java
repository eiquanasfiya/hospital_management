package service;

import domain.Doctor;
import repository.DoctorRepository;

import java.util.List;

public class DoctorService {

    public static Double getDoctorFees(String doctorName) {
        DoctorRepository doctorRepository = new DoctorRepository();
        return doctorRepository.getDoctorFees(doctorName);
    }

    public static String[] getDoctorsName() {
        DoctorRepository doctorRepository = new DoctorRepository();
        List<String> doctorsName = doctorRepository.getDoctorsName();
        String dName[] = new String[doctorsName.size()];
        for(int i=0;i< doctorsName.size();i++)
        {
            dName[i] = doctorsName.get(i);
        }
        return dName;

    }

    public static int getDoctorIdByName(String doctorNamec) {
        DoctorRepository doctorRepository = new DoctorRepository();
        return doctorRepository.getDoctorIdByName(doctorNamec);
    }

    public static String[][] getAllFlightsForJTable(int length) {
        DoctorRepository doctorRepository=new DoctorRepository();
        List<Doctor> allDoctors=doctorRepository.getAllDoctors();
        String[][] data = new String[allDoctors.size()][length];
        for (int row = 0; row < allDoctors.size(); row++) {
            data[row][0] = allDoctors.get(row).getName();
            data[row][1] = allDoctors.get(row).getAddress();
            data[row][2] = allDoctors.get(row).getSpecialization();
            data[row][3] = allDoctors.get(row).getContact();
            data[row][4] = allDoctors.get(row).getFee().toString();

        }
        return data;
    }
    /////////////////////TO SHOW THE SEARCHED ITEMS/////////////////

    public static String[][] showSearchedField(String contactNumber, int length) {
        DoctorRepository doctorRepository = new DoctorRepository();
        Doctor doctors = doctorRepository.searchDoctor(contactNumber);
        String[][] data = new String[1][length];
        for (int row = 0; row < 1; row++) {
            data[row][0] = doctors.getName();
            data[row][1] = doctors.getAddress();
            data[row][2] =doctors.getSpecialization();
            data[row][3] = doctors.getContact();
            data[row][4] = doctors.getFee().toString();

        }
        return data;
    }

//////////////////////TO ADD THE DOCTOR////////////////////////////////

    public static Boolean addDoctor(String doctorName, String doctorAddress,
                                    String doctorSpecialization,String doctorContact,String doctorFee){
        DoctorRepository doctorRepository=new DoctorRepository();
        Doctor searchedDoctor=doctorRepository.searchDoctor(doctorContact);
        if(searchedDoctor==null){
            doctorRepository.addDoctorFromJtable(doctorName,doctorAddress,doctorSpecialization,doctorContact,doctorFee);
            return true;
        }
        return false;
    }



    ///////////SEARCH SECTION FOR SEARCH CLASS//////////////////////
    public static Boolean searchDoctorFromAdmin(String contactNumber) {
        DoctorRepository doctorRepository=new DoctorRepository();
        Doctor searchedDoc=doctorRepository.searchDoctor(contactNumber);
        if(searchedDoc!=null){
            return true;
        }
        return false;
    }

    /////////////////////////////SEARCH DOCTOR FOR UPDATE/////////////////////////////////
    public static Doctor searchDoctorForUpdate(String doctorContact) {
        DoctorRepository doctorRepository=new DoctorRepository();
        Doctor doctorToUpdate=doctorRepository.searchDoctor(doctorContact);
        return doctorToUpdate;
    }
//////////////////////ADDING UPDATED DOCTOR//////////////////////////////////

    public static void doctorUpdated(String doctorContact,String updateDoctorName,String updateDoctorAddress,
                                     String updateDoctorSpecialization,String updateDoctorContact,String updateDoctorFee){
        DoctorRepository doctorRepository=new DoctorRepository();
        doctorRepository.updateDoctor(doctorContact,updateDoctorName,updateDoctorAddress
                ,updateDoctorSpecialization,updateDoctorContact,updateDoctorFee);
    }


    /////////////////DELETE DOCTOR////////////////////////////
    public static Boolean deleteDoctorFromAdmin(String doctorContact){
        DoctorRepository doctorRepository=new DoctorRepository();
        Doctor searchedDoctor=doctorRepository.searchDoctor(doctorContact);
        if(searchedDoctor!=null){
            doctorRepository.deleteDoctor(doctorContact);
            return true;
        }
        return false;
    }




//    public static String[] getDoctorByName(String doctorName) {
//        DoctorRepository doctorRepository = new DoctorRepository();
//        List<Doctor> doctors = doctorRepository.getDoctorByName(doctorName);
//        String doc
//    }
}
