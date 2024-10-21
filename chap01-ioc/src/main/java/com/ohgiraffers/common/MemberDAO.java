package com.ohgiraffers.common;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component  // 이 클래스를 빈으로 등록함.. 이라는 뜻 // 클래스 자체가 빈이 되는것임
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;
    // final 이라 지정을 해뒀기에 해시맵이라고 자료형을 지정해둔건 바꾸지 못하지만, ( 형식 자체를 바꾸지는 못함) 안에 값을 넣는건 자유롭게 넣을 수 있다.

    public MemberDAO() {
        this.memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "홍길순"));
    }

    // 매개변수로 전달 받은 회원의 번호를 map 에서 조회 후 회원 정보 리턴 메소드
    public MemberDTO selectMember(int seq) {
        return memberMap.get(seq);
    }

    // 매개변수로 전달 받은 회원 정보를 map 에 추가하고 성공 실패 여부를 boolean 형식으로 리턴하는 메소드
    public boolean insertMember(MemberDTO member) {
      int before = memberMap.size();
      memberMap.put(member.getSequence(), member);

      // 추가 이전의 사이즈와 추가 후 사이즈가 달라졌는지 체크한 후 추가 되었다면 true 리턴 !
      return memberMap.size() > before? true : false;
    }
}

