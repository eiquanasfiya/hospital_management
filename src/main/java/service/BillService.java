package service;

import repository.BillRepository;

public class BillService {

    public static Boolean addBill(String invoiceNumber, int appointmentId) {
        BillRepository billRepository = new BillRepository();
        return billRepository.addBill(invoiceNumber,appointmentId);
    }
}
