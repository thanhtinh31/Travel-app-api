package com.example.travelapp.controller;

import com.example.travelapp.model.Tax;
import com.example.travelapp.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tax")
@CrossOrigin
public class TaxController {
    @Autowired
    private TaxService taxService;
    @GetMapping
    public ResponseEntity<?> getListTax(){
        List<Tax> taxs= taxService.getAllTax();
        return ResponseEntity.ok(taxs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTax(@PathVariable Long id){
        Tax tax= taxService.getTaxById(id);
        return ResponseEntity.ok(tax);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Tax tax){

        return  new ResponseEntity<>(taxService.createTax(tax), HttpStatus.OK);
    }
    @PutMapping(path = "/{id}")
    public int update(@RequestBody Tax tax, @PathVariable Long id){
        try{
            Tax placesExist = taxService.getTaxById(id);
            return taxService.update(id,tax);
        }
        catch (NoSuchElementException e){
            return 0;
        }
    }
    @DeleteMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable Long id)
    {

        return taxService.deleteTax(id);
    }

}
