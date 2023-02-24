package com.example.travelapp.service;

import com.example.travelapp.request.ChangePassRequest;
import com.example.travelapp.model.Account;
import com.example.travelapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService{
    @Autowired
    public AccountRepository accountRepository;
    public List<Account> listAcount(){
        return accountRepository.getAll();
    }
    public Map<String,Object> checkLogin(String name_account, String password){
        Map<String,Object> m=new HashMap<>();
        if(accountRepository.getAccountByName(name_account)==null)
        {   m.put("status","0");
            m.put("message","Tài khoản không tồn tại");
        }
        else
        if(accountRepository.getStatus(name_account)==false) {
            m.put("status","0");
            m.put("message","Tài khoản đã bị khóa");

        }else
        if(accountRepository.checkLogin(name_account,password)==null)
        {
            m.put("status","0");
            m.put("message","Mật khẩu không chính xác");

        }
        else {
            m.put("status","1");
            m.put("message","Đăng nhập thành công");
            m.put("account",accountRepository.getAccountByName(name_account));
        }
        return m;
    }
    public Map<String,Object> createAccount(Account account){
        Map<String,Object> m=new HashMap<>();
        if(account.getNameAccount()==null)
        {
            m.put("status","0");
            m.put("message","ten dang nhap va mat khau khong hop le");
        }
        else if(accountRepository.getAccountByName(account.getNameAccount())==null)
        {
            accountRepository.save(account);
            m.put("data",account);
            m.put("status","1");
            m.put("message","them moi thanh cong");
        }
        else {
            m.put("status","0");
            m.put("message","Ten dang nhap da ton tai");
        }
        return  m;
    }
    public void lockOrUnlock(Long id) {
        Account account1 = accountRepository.getAccountByID(id);
        if(account1.isStatus()==true)
            account1.setStatus(false);
        else
            account1.setStatus(true);
        accountRepository.save(account1);
    }
    public Account getAccountByID(Long id)
    {
        return accountRepository.getAccountByID(id);
    }

    public Map<String,Object> update(Long id,Account account){
        Map<String,Object> m=new HashMap<>();
        Account account1 = accountRepository.findById(id).get();
            account1.setFullName(account.getFullName());
            account1.setPhoneNumber(account.getPhoneNumber());
            account1.setAddress(account.getAddress());
            accountRepository.save(account1);
            m.put("status","1");
            m.put("message","cap nhat thanh cong");
            m.put("account",account1);

        return m;
    }

    public Map<String,Object> changePasswprd(ChangePassRequest changePassRequest)
    {
        Map<String,Object> m=new HashMap<>();
        Account account1 = accountRepository.findById(changePassRequest.getId()).get();
        if(!changePassRequest.getOldPass().equals(accountRepository.getPassword(changePassRequest.getId())))
        {
            m.put("status","0");
            m.put("message","mat khau khong hop le");
        }
        else if(changePassRequest.getNewPass() ==null || changePassRequest.getNewPass().length()<6){
            m.put("status","0");
            m.put("message","mat khau phai >=6 ki tu");
        }
        else {
            account1.setPassword(changePassRequest.getNewPass());
            accountRepository.save(account1);
            m.put("status","1");
            m.put("message","doi mat khau thanh cong");
        }
        return m;
    }
    public List<Map<String,Object>> thongketaikhoan(){
        return accountRepository.thongketaikhoan();
    }


}
