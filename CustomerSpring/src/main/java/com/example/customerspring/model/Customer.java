package com.example.customerspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.customerspring.model
 * fileName : Customer
 * author : 4571c
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07         4571c          최초 생성
 */
@Getter
@Setter
@ToString
public class Customer {
    // Long(객체) , long(일반자료형)
    private Long id; // 회원아이디
    private String firstName; // 회원 이름
    private String lastName; // 회원 성
    private String email; // 회원 이메일
    private String phone; // 회원 전화번호
    private String deleteYn; // 삭제여부
    private String insertTime; // 생성날짜
    private String updateTime; // 수정날짜
    private String deleteTime; // 삭제시간
}
