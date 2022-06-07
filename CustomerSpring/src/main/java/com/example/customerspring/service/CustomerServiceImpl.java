package com.example.customerspring.service;

import com.example.customerspring.dao.CustomerDao;
import com.example.customerspring.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.customerspring.service
 * fileName : CustomerServiceImpl
 * author : ds
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-06-07         ds          최초 생성
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

//    id로 회원 조회하는 메소드
    @Override
    public Optional<Customer> findById(long id) {
        return customerDao.findById(id);
    }

//
    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

//    회원생성 / 수정 서비스 ( insert / update )
    @Override
    public Optional<Customer> save(Customer customer) {
//        DB 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        logger.info("customer {}", customer);
        if (customer.getId() == null) {
            customerDao.insertCustomer(customer);
        }
        else {
            customerDao.updateCustomer(customer);
        }
//        insert문 후에는 customer의 id속성값에 값이 저장됨 (<selectKey>)
        seqId = customer.getId();
        logger.info("seqId {}", seqId);

        return customerDao.findById(seqId);
    }

    @Override
    public boolean deleteById(Long id) {
        long queryResult = 0;

        queryResult = customerDao.deleteCustomer(id);


        return (queryResult >=1) ? true : false;
    }

    @Override
    public boolean deleteAll() {
        long queryResult = 0;

        queryResult = customerDao.deleteAll();

        return (queryResult >=1) ? true : false;
    }
}
