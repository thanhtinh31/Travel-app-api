package com.example.travelapp.service;

import com.example.travelapp.request.ChangeStatusInvoiceRequest;
import com.example.travelapp.model.Invoice;
import com.example.travelapp.repository.InvoiceRepository;
import com.example.travelapp.response.ThongKeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }
    public List<Invoice> getListInvoiceByAccountId(Long id){
        return invoiceRepository.getListInvoiceByIdAccount(id);
    }



    public Invoice getInvoiceById(Long id){
        return invoiceRepository.getInvoiceById(id);
    }
    public Invoice changeStatus(ChangeStatusInvoiceRequest request)
    {
        if(invoiceRepository.findById(request.getId())!=null)
        {
            Invoice invoice= invoiceRepository.getInvoiceById(request.getId());
            invoice.setStatus(request.getStatus());
            invoiceRepository.save(invoice);
            return invoice;
        }
        return null;
    }
    public Invoice changeStatusPaymentVNpay(Long id,Invoice invoice)
    {
        Invoice invoice1= invoiceRepository.getInvoiceById(id);
        if(invoice1!=null)
        {
            invoice1.setStatus(2);
            invoice1.setPayDay(invoice.getPayDay());
            invoice1.setBankTranNo(invoice.getBankTranNo());
            invoice1.setBank(invoice.getBank());
            invoice1.setPayments(invoice.getPayments());
            invoiceRepository.save(invoice1);
        }
        return invoice1;
    }
    public List<Invoice> getMyInvoiceSeller(Long id){
        return invoiceRepository.getMyInvoiceSellerById(id);
    }

    public List<Map<String,Object>> thongke(int year){
        return invoiceRepository.thongketheonam(year);
    }

}
