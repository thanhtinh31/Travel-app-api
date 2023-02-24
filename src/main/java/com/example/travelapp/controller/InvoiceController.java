package com.example.travelapp.controller;

import com.example.travelapp.request.ChangeStatusInvoiceRequest;
import com.example.travelapp.model.*;
import com.example.travelapp.service.InvoiceService;
import com.example.travelapp.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/invoice")
@CrossOrigin
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private TourService tourService;
    @GetMapping
    public ResponseEntity<?> getListInvoice(){
        List<Invoice> services= invoiceService.getAllInvoice();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/myinvoice/{id}")
    public ResponseEntity<?> getListInvoiceByAccountId(@PathVariable Long id){
        List<Invoice> services= invoiceService.getListInvoiceByAccountId(id);
        return ResponseEntity.ok(services);
    }
    @GetMapping("/myinvoiceseller/{id}")
    public ResponseEntity<?> getListInvoice(@PathVariable Long id){
        List<Invoice> invoices= invoiceService.getMyInvoiceSeller(id);
        return ResponseEntity.ok(invoices);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> geInvoiceById(@PathVariable Long id){
        Invoice invoice= invoiceService.getInvoiceById(id);
        return new ResponseEntity(invoice,HttpStatus.OK);
    }

    @PostMapping("/changestatus")
    public ResponseEntity<?> create(@RequestBody ChangeStatusInvoiceRequest request){

        return  new ResponseEntity<>(invoiceService.changeStatus(request), HttpStatus.OK);
    }
    @PutMapping("/paymentvnpay")
    public ResponseEntity<?> paymentVNPay(@RequestBody Invoice invoice){
        return new ResponseEntity<>(invoiceService.changeStatusPaymentVNpay(invoice.getId(),invoice), HttpStatus.OK);
    }



}
