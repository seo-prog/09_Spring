package com.ohgiraffers.section01.aop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

// 실행부

@Service
// 비즈니스 로직을 수행하는 Class 라는 것을 나타내는 용도이다.
public class MemberService {

    private final MemberDAO memberDAO;


    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Integer, MemberDTO> selectMembers() {
        System.out.println(" selectMembers 메소드 실행! ");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(int id){
        System.out.println(" selectMember 메소드 실행 !");
        return memberDAO.selectMember(id);
    }

    @Override
    public String toString() {
        return "MemberService Bean";
    }
}
