# 스프링 웹 개발 기초

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
