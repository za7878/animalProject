package com.human.app.controller;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoviesService {
	private MovieApiClient movieApiClient = new MovieApiClient();

	@Transactional(readOnly = true) // 트랜잭션을 읽기 전용 모드로 설정.
	public MoviesResponseModel findByKeyword(String keyword) {
		return movieApiClient.requestMovie(keyword);
	}

	
	/*ReadOnly=true
	 * (기본값 false)
	 * 
	 * 읽기 전용 트랜잭션 내에서 Insert, Update, Delete 작업을 해도 반영 되지 않거나,
	 * DB 종류에 따라서 아예 예외가 발생하는 경우도 있다.
	 * 성능 향상을 위해 사용하거나, 읽기 외의 다른 동작을 방지하기 위해 사용하기도 함.
	 * */
	
	
	//But! JDBC를 구현한 벤더마다 readOnly 지원 여부가 다르다고 함.. 
	//h2에서는 CUD가 일어나도 예외를 던지지 않고, 
	//mysql 5.6.5 이후 버전에서는 CUD가 일어나면 예외를 던진다고 한다.
}
//트랜잭션에 readOnly=true 옵션을 주면 스프링 프레임워크가 하이버네이트 세션 플러시 모드를
// MANUAL로 설정한다. 이렇게 하면 강제로 플러시를 호출하지 않는 한 플러시가 일어나지 않는다.
// 따라서 트랜잭션을 커밋하더라도 영속성 컨텍스트가 플러시 되지 않아서 엔티티의 등록,수정,삭제 등이 동작하지 않고,
//또한 읽기 전용으로, 영속성 컨텍스트는 변경 감지를 위한 스냅샷을 보관하지 않으므로 성능이 향상됨.

//엔티티를 읽기 전용으로 조회하면, 변경 감지를 위한 스냅샷을 유지하지 않아도 되고,
//영속성 컨텍스트를 플러시 하지 않아도 돼, 성능을 최적화함.

/*하이버 네이트란?
 * 하이버네이트는 자바 환경에서의 객체-관계 모델 매핑 솔루션
 * orm이라 불리우는 객체-관계 매핑은 어플리케이션레벨의 도메인 객체를 
 * 관계형 데이터베이스 테이블의 형태로 혹은 역으로 매핑시켜주는 프로그래밍 기술
 * 하이버네이트는 낮은 결합도의 이점을 가진 ORM 툴로 Java Persistence API를 참조하여 구현하는 기능을 제공
 * */

/*스냅샷?
 * 접미사로 SNAPSHOT이 붙으면 아직 개발단계라는 의미이며, 메이븐에서 라이브러리를 관리하는 방식이 다르다.
 * */
/* 플러시(Flush)
 * flsuh를 수행하지 않는다는 것은 즉, 아래와 같은 작업을 수행하지 않는다는 것.
 * 엔티티의 등록(insert), 수정(update), 삭제(delete)
 * Dirty Checking을 위한 스냅샷 비교
 * */

/*영속성 컨텍스트란?
 * 
 * 엔티티를 영구 저장하는 환경
 * 영속성 컨텍스트는 애플리케이션과 데이터베이스 사이에서 객체를 보관하는 논리적 개념.
 * EntityManager를 통해서 영속성 컨텍스트에 접근. (EntityManager가 생성되면
 * 논리적 개념인 영속성 컨텍스트 PersistenceContext)가 1:1로 생성된다.
 * */

							//Entity
//JPA에서는 엔티티는 테이블에 대응하는 하나의 클래스라고 생각하시면 편하다.
//spring-boot-starter-data-jpa 의존성을 추가하고 @Entiy 어노테이션을 붙이면 테이블과 자바 클래스가 매핑이 됨.
//그래서 JPA에서 '하나의 엔티티 타입을 생성한다'라는 의미는 '하나의 클래스를' 작성한다는 의미가 됨.

//엔티티라는 용어는 때로는 클래스를 의미하는 경우도 있고, 
//클래스에 의해 생성된 인스턴스를 의미하는 경우가 있다..
//정확히 얘기 하자면, 엔티티 클래스 와 엔티티 인스턴스 혹은 엔티티 객체라는 표현이 정확하다..
