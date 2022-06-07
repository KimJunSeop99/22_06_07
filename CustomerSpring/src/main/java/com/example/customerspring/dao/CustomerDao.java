package com.example.customerspring.dao;

import com.example.customerspring.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.customerspring.dao
 * fileName : CustomerDao
 * author : ds
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-06-07         ds          최초 생성
 */
public interface CustomerDao {
//    전체 회원 조회 메소드
    List<Customer> findAll();
//    id로 회원 조회 메소드
    Optional<Customer> findById(Long id);
//    회원생성 메소드
    long insertCustomer(Customer customer);
//    회원수정 메소드
    long updateCustomer(Customer customer);
//    id로 회원 삭제 메소드
    long deleteCustomer(Long id);
//    전체 회원 삭제 메소드
    long deleteAll();
}
