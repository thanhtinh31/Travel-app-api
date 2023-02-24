package com.example.travelapp.repository;

import com.example.travelapp.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    @Query(value = "Select *  from invoice where id= ?1", nativeQuery = true)
    Invoice getInvoiceById(Long id);
    @Query(value = "Select *  from invoice where account_id= ?1 ORDER BY id DESC", nativeQuery = true)
    List<Invoice> getListInvoiceByIdAccount(Long id);
    @Query(value = "SELECT i.id,i.amount,i.date_invoice,i.note,i.payments,i.status,i.account_id,i.tour_id,i.address,i.email,i.full_name,i.phone\n" +
            ",i.people,i.bank_tran_no,i.pay_day,i.bank FROM invoice i,tour t where i.tour_id=t.id and t.id_seller= ?1 ORDER BY id DESC", nativeQuery = true)
    List<Invoice> getMyInvoiceSellerById(Long id);
    @Query(value = "SELECT month(date_invoice) as thang, sum(amount) as doanhthu FROM invoice where year(date_invoice)= ?1 and status=2 group by month(date_invoice) order by thang;", nativeQuery = true)
    List<Map<String,Object>> thongketheonam(int year);


}
