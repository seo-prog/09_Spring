package com.ohgiraffers.section01.aop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
// DAO class 에서 쓰이는 어노테이션이다.
// DB에 접근하는 method 를 가지고 있는 Class 에서 쓰인다.
public class MemberDAO {

    private final Map<Integer,MemberDTO> membersMap;

    public MemberDAO() {
        membersMap = new HashMap<>();
        membersMap.put(1, new MemberDTO(1, "유관순"));
        membersMap.put(2, new MemberDTO(2, "홍길동"));
    }

    public Map<Integer,MemberDTO> selectMembers() {
        return membersMap;
    }

    public MemberDTO selectMember(int id) {
        MemberDTO returnMember = membersMap.get(id);
        if(Objects.isNull(returnMember)){
            throw new RuntimeException("해당 id 를 가진 회원은 존재하지 않습니다.");
        }
        return returnMember;
    }
}
