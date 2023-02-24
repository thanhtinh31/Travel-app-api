package com.example.travelapp.controller;

import com.example.travelapp.response.ThongKeResponse;
import com.example.travelapp.service.AccountService;
import com.example.travelapp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/thongke")
@CrossOrigin
public class ThongKeController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private AccountService accountService;
    @GetMapping("/doanhthutheothang/{year}")
    public ResponseEntity<?> getThongKeTheoThang(@PathVariable int year){
        List<Map<String,Object>> tk= invoiceService.thongke(year);
        return ResponseEntity.ok(tk);
    }
    @GetMapping("/thongketaikhoan")
    public ResponseEntity<?> getThongKeTaiKhoan(){
        List<Map<String,Object>> tk= accountService.thongketaikhoan();
        return ResponseEntity.ok(tk);
    }
}
