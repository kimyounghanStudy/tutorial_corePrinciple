# 스프링 기초

## 스프링 웹 개발 기초

1. 정적컨텐츠
  웹브라우저 요청 -> 내장 톰캣 서버([WAS](http://sungbine.github.io/tech/post/2015/02/15/tomcat%EA%B3%BC%20apache%EC%9D%98%20%EC%97%B0%EB%8F%99.html))-> 스프링컨테이너~ 관련 컨트롤러 찾음
  -> 없으면 정적폴더 뒤져서 있는거 매핑해서 ~ -> 톰캣서버 ~ 웹브라우저 반환
  
 
2. MVC + 템플린엔진(타임리프, 머스테치 같은~)
웹브라우저 요청 -> 내장 톰캣~ ->스프링컨 테이너에 컨트롤러 매핑된게 있다.!! -> 해당 컨트롤러 return+model넘김
-> viewResolver -> 내장톰캣~ HTML 변환후 반환

3. API
  컬트롤러에 @ResponseBody 가 달려있는 경우, viewResolver를 사용하지 않는 대신 HTTP BODY에 담아서 반환
그럼 viewResolver 대신에 HttpMessageConverter가 동작
>HttpMessageConverter는 여러 Converter 이용 해서 처리함
>예를 들어 문자라면 StringHttpMessageConverter, 객체라면 MappingJackon2HttpMessageConverter
>자세한 내용은 MVC강의~ 나중에 링크 연결하겠음!

---

## 스프링 빈과 의존관계
> 생성자에 @Autowired가 달려있다면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌!([DI](https://github.com/j-jh-Study/technical-interview/blob/main/DI.md))
  그럼 스프링 컨테이너에 등록하는건...! 
  컴포먼트스캔 자동 의존관계 설정 or 직접 코드짜서 등록하기
  ```
  생성자에 @AutoWired 사용시 객체 생성 시점에 빈주입!!.. 생성자가 한개만 있다면
  @AutoWired 생략가능
  ```
  
1. 컴포넌트 스캔과 자동 의존관계 설정
  컴포먼트 스캔 ~ @Component 달려있으면 스프링 빈으로 자동등록
  @Controller , @Service , @Repository 등도 들어가보면 @Component 포함
2. 자바 코드로 직접 스프링 빈 등록하기
  @Configuration ~ @Bean의 조합 

---

## 스프링DB 접근기술

1. 순수 Jdbc
2. 스프링 jdbcTemplate // MyBatis -> 반복코드삭제, but SQL은 직접 작성
3. JPA -> SQL도 대신 해줌! 엔티티맵핑 분리..!?
4. 스프링 데이터 JPA -> 반복코드제거, 편의성 추가!   
  [JpaRepository]->  [PagingAndSortingRepository->CrudRepository->Repository]
