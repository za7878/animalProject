package com.human.app.controller;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // XML에 빈을 설정하지 않아도 Component를 사용하면, 매핑이 된다!!
@Aspect //@Aspect 어노테이션을 적용한 클래스는 Advice와 Pointcut을 함께 제공, 공통적으로 사용되는 부분
public class Aop {
	private static final Logger logger = LoggerFactory.getLogger(Aop.class);
	
//	public Object Aop(ProceedingJoinPoint joinpoint) throws Throwable {
//	String signatureStr = joinpoint.getSignature().toShortString(); //getSignature = 호출되는 메서드에 대한 정보를 구한다.
//	}
//		logger.debug(signatureStr, "in start.");	//toShortString = 메서드를 축약해서 표현한 문장을 구한다. (기본 구현은 메서드의 이름만을 구한다.) (클라이언트가 호출한 메소드의 시그니처를 축약한 문자열로 리턴)
//		
//		// 핵심기능 실행전 공통기능
//		long st = System.currentTimeMillis(); //System.currentTimeMillis() = 1970년 1월 1일부터
//											  //경과한 시간을 long값으로 리턴하며, 밀리세컨 1/1000초 값을 리턴.
//											  //현재 시간을 구하고, 프로그램 실행 시간을 구함.
//		try {
//			//핵심기능
//			Object obj = joinpoint.proceed(); //Aop가 적용된 메소드를 전체 수행하고 리턴되는 데이터를 받는 메소드
//			return obj;
//		} finally {
//			//핵심기능 실행 후 공통기능
//			long et = System.currentTimeMillis();
//			logger.debug(signatureStr, "is finished.");
//			logger.debug(signatureStr, "경과시간: " + (et - st));
//		}
//	}
	// PointCut의 속성에 핵심코드의 어느 부분까지 공통 기능을 사용하겠다고 명시
	// 2.1 pointcut 메서드를 이용하는 방법
//    @Pointcut("within(com.human.app.web.*.Service.*Service.*)") //특정 타입에 속하는 메서드를 JoinPoint로 설정되도록 명시할 때 사용
//    private void pointcutMethod(){
//    }
//	  //@Around 어노테이션은 publicTarget() 매서드에 정의한 Pointuct에 공통 기능을 적용
//    @Around("pointcutMethod()")
//    public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
//        String signatureStr = joinpoint.getSignature().toShortString();
//        logger.debug(signatureStr, "is start");
//
//        // 핵심기능 실행전 공통기능
//        long st = System.currentTimeMillis();
//
//        try{
//            // 핵심기능
//            Object obj = joinpoint.proceed(); //Aop가 적용된 메소드를 전체 수행하고 리턴되는 데이터를 받는 메소드
//            return obj;
//        } finally {
//            // 핵심기능 실행후 공통기능
//            long et = System.currentTimeMillis();
//            logger.debug(signatureStr, "is finished.");
//            logger.debug(signatureStr, "경과시간: "+ (et - st));
//        }
//    }

    // 2.2 pointcut 메서드를 이용하지 않고 바로 적용하는 방법
    // 괄호 안에 메서드가 아니라 Expression 바로 입력
	  @Before("execution(* com.human.app.web.*.Service.*Service.*(..))") //execution(접근제어자, 반환형 패키지를 포함한 클래스 경로 메소드파라미터)
	  public void beforeAdvice(){ // * 기호는 접근 제어자,반환형을 상관하지 않는다는 의미이고, com.human.app.controller.HomeController해당 클래스에
		  logger.debug("beforeAdvice():: 메소드 실행 전");	//(..) 메소드의 파라미터가 몇개가 존재하던지 상관없이 실행하는 경우를 의미
	  }
	  
	  @After("execution(* com.human.app.web.*.Service.*Service.*(..))") //Advice를 적용할 메서드를 명시할 때 사용
	  public void afterAdvice(){
		  logger.debug("afterAdvice():: 메소드 실행 후");
	  }
	  
//	  @Around("execution(* com.human.app.controller.HomeController.*(..))")
//	  public void AroundAdvice(){
//		  logger.debug("AroundAdvice()::요것만찍어용");
//	  }
}

/* before(비지니스 메소드 실행 전에 Advice 메소드 실행)  
 *
 * after(비지니스 메소드의 성공 실패와 상관없이 비지니스 메소드 실행 후 무조건 Advice 메소드 실행)
 *
 * around(비지니스 메소드 실행 전과 실행 후 Advice 메소드 동작. 메소드 호출 자체를 가로채서 비즈니스 메소드 실행 전&후 모두에 처리할 로직을 삽입할 수 있다.)
 *
 * 그 외에도 after-returning(비지니스 메소드가 성공적으로 실행되었을 때만 Advice메스도 동작. 단, 메소드 내부에 리턴값이 존재하는 경우),
 *
 * after-throwing (비지니스 메소드가 실행에 실패했을 때만 Advice 메소드 실행. 예를들면 try~catch 블록의 catch 부분에 해당!),
 */