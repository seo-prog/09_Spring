package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect // pointcut 과 advice 를 하나의 클래스 단위로 정의하기 위한 어노테이션
@Component
public class LoggingAspect {
    /*
    * @Aspect
    * - pointcut 과 advice 를 하나의 클래스 단위로 정의하기 위한 어노테이션
    *
    * 조인 포인트 - aop 에서 특정한 실행 지점을 의미
    *
    * 실행 지점 종류
    * 메소드 호출 = 특정 메소드가 호출될 떄
    * 메소드 실행 = 특정 메소드의 실행이 완료된 후
    * 예외 발생 = 특정 메소드 내에서 예외가 발생할 뗴
    * 필드 접근 = 객체의 필드에 접근할 떄
    *
    * pointcut = 특정 조건에 의해 필터링 된 조인포인트
    * 수 많은 조인포인트 중에 특정 메소드만 횡단 공통기능을 수행하기 위해 사용
    * advice = 횡단 관심에 해당하는 공통 기능의 코드(코드 뭉치들), 독립된 메소드로 작성
    * */

    /*
    * pointcut = 관심 조인 포인를 결정하여 어드바이스가 실행되는 시기를 제어한다.
    * execution = 메소드 실행 조인 포인트를 매칭한다
    *
    * execution (*리턴타입(경로?) . 이름(파라미터))
    * *Service.*(..) = 매개변수가 0개 이상인 모든 메소드
    * *Service.*(*) = 매개변수가 1개인 모든 메소드
    * *Service.*(*,*) = 매개변수가 2개인 모든 메소드
    * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))") // Service안 메소드 지정
    public void logPointCut(){
        // 실행되지 않고 경로만 잡아주는 역할을 한다. 몸체가 필요없음.
        System.out.println(" 이거 진짜 실행 안되나 ??");
        // 어떤 상황에서 동작을 시킬지만 지정
        // 실행이 안됨. 정말 지정만 해둔거고 아예 실행이 안된다.
    }

    // LoggingAspect 안에있는 logPointCut() 메소드.
    // 위에서 메소드 지정(?) 만 하고 아래는 실행 될 advice 들이다.
    @Before("LoggingAspect.logPointCut()") // 위에 메소드 가리킨거임
    public void logBefore(JoinPoint joinPoint){// Service 안 메소드들이 동작할 때 그 전에 동작
        // 성능 진단, 로그 찍어보기, 예외처리, 메소드 권한 체크 등 이런것들을 쓴다.
        // 현재 실행 중인 타깃 객체를 반환
        System.out.println(" before joinpoint.getTarget() :" + joinPoint.getTarget());
        // 객체의 toString 이 반환된다.

        // 호출된 메소드의 시그니처 반환
        System.out.println(" before joinpoint.getSignature() :" + joinPoint.getSignature());

        if(joinPoint.getArgs().length > 0){
            System.out.println(" before joinpoint.getArgs()[] :" + joinPoint.getArgs()[0]);
        }
// 이 @Before 안에 존재하는 것들 무더기로 그냥 advice 로 부른다.
    }

    @After("logPointCut()")
    // logPointCut() 이 메소드가 지정한 메소드들이 다 끝난후에 실행될꺼임
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinpoint.getTarget() :" + joinPoint.getTarget());
        System.out.println("After joinpoint.getSignature() :" + joinPoint.getSignature());
    }

    // aop 가 적용된 메소드가 에러 없이 정상적으로 실행된 이후 실행
    // result 는 정해진게 아니라 바뀔 수 있다. 우리가 그냥 정해준! 대신 두 번째 인자로 받아야 한다.
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result : "+ result);
        // 우리가 호출한 메소드의 결과값을 가지고 올 수 있다.

//        if(result != null && result instanceof Map){
//            ((Map<Integer,MemberDTO>)result).put(100, new MemberDTO(100, "가공한 값"));
            // 그 결과값을 가공도 해줄 수 있다.
            // 만약, 이 메소드 성공시에만 추가해줄래 ! 를 원한다면 일케 사용 가능

    }

    // 메소드에서 에러가 발생했을 때 동작
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception){
        System.out.println("After Throwing exception : "+ exception);
        // 아까 만들어 둔 에러 메세지를 담아서 출력해준다. 실패했을 시 !
    }

    @Around("logPointCut()") // 제일 강력한 메소드 !
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        /*
        * Around Advice 는 가장 강력한 어드바이스이다.
        * 이 어드바이스는 조인포인트를 완전히 장악한다..
        * 따라서 앞서 살펴 본 어드바이스 모두 Around 어드바이스로 조합할 수 있다..
        * 매개변수는 ProceedingJoinPoint 로 고정되어 있다.
        * joinPoint 의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
        * -- 원본 메소드에도 영향을 줄 수 있기 땜시 위험.
        * */

        // 메소드 실행 전 로그 출력 // 동작 전 상태
        System.out.println("Around Before: " + joinPoint.getSignature().getName()); // 제일 먼저 호출 ! // 메소드 시작 전에 호출 !


        // 원본 메소드 실행
        // Object 는 모두의 상위 객체이기 땜시 모두 적용 가능.
        // proceed 가 있어야 원본메소드를 실행한다는 의미. proceed 가 없으면 아예 지정 메소드가 실행 안된다.
        // 위에 메소드 전에 동작하게 해둔것들도 다 안된다. 즉, proceed 가 없다면 Around 빼고는 모든 메소드가 동작하지 않는다는 뜻 !
        // 기본 app 에서 실행시킨 memberService 의 메소드의 실행조차도 제어가 가능하다. (proceed 로)
        Object result = joinPoint.proceed(); // 원본 메소드의 결과값이 result 에 저장될꺼다
        if(result != null && result instanceof Map){
            ((Map<Integer, MemberDTO>)result).put(100, new MemberDTO(100, "반환 값 가공"));
        }

        // 메소드 실행 후 로그 출력
        System.out.println("Around After: " + joinPoint.getSignature().getName());
        return result; // 추가해준 값 반환
    }

}
