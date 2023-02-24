package com.example.travelapp.repository;

import com.example.travelapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

  @Query(value = "select * from account", nativeQuery = true)
  List<Account> getAll();
  @Query(value = "select status from account where name_account = ?1", nativeQuery = true)
  boolean getStatus(String name);

  @Query(value = "select * from account where name_account = ?1", nativeQuery = true)
  Account getAccountByName(String name);
  @Query(value = "select * from account where id = ?1", nativeQuery = true)
  Account getAccountByID(Long id);

  @Query(value = "select * from account where name_account = ?1 and password = ?2", nativeQuery = true)
  Account checkLogin(String name_account,String password);
  @Query(value = "select password from account where id = ?1", nativeQuery = true)
  String getPassword(Long id);
  @Query(value = "SELECT type_account, count(*) as soluong FROM account group by type_account", nativeQuery = true)
  List<Map<String,Object>> thongketaikhoan();

}
