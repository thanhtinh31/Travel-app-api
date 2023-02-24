package com.example.travelapp.service;

import com.example.travelapp.model.Tax;
import com.example.travelapp.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaxService {
    @Autowired
    private TaxRepository taxRepository;
    public List<Tax> getAllTax(){
        return taxRepository.findAll();
    }
    public Tax getTaxById(Long id){
        return taxRepository.getTaxById(id);
    }
    public Map<String,Object> createTax(Tax tax){
        Map<String,Object> m=new HashMap<>();
        if(tax.getName()==null||tax.getName().equalsIgnoreCase(""))
        {
            m.put("status","0");
            m.put("message","ten khong duoc de trong");
        }
        else if(taxRepository.getTaxByName(tax.getName())==null)
        {
            taxRepository.save(tax);
            m.put("data",tax);
            m.put("status","1");
            m.put("message","them moi thanh cong");
        }
        else {
            m.put("status","0");
            m.put("message","Thue da ton tai");
        }
        return  m;
    }
    public int update(Long id, Tax tax) {
        Tax tax1 = taxRepository.getTaxById(id);
        if(checkExistTax(tax.getName())==0||tax1.getName().equalsIgnoreCase(tax.getName())){
            tax1.setName(tax.getName());
            tax1.setStatus(tax.isStatus());
            tax1.setRateTax(tax.getRateTax());
            tax1.setDateStart(tax.getDateStart());
            tax1.setDateEnd(tax.getDateEnd());
            taxRepository.save(tax1);
            return 1;
        }

        return 0;
    }
    public int checkExistTax(String name)
    {
        if(taxRepository.getTaxByName(name)==null)
            return 0;
        return 1;
    }
    public Map<String,Object> deleteTax(Long id){
        Map<String,Object> m=new HashMap<>();
        if(taxRepository.getTaxById(id)!=null)
        {
            taxRepository.deleteById(id);
            m.put("status","1");
            m.put("message","xoa thanh cong");
        }
        else {
            m.put("status","0");
            m.put("message","khong ton tai");
        }
        return  m;
    }


}
