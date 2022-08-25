package service;

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

//    public static String[] getDoctorByName(String doctorName) {
//        DoctorRepository doctorRepository = new DoctorRepository();
//        List<Doctor> doctors = doctorRepository.getDoctorByName(doctorName);
//        String doc
//    }
}
