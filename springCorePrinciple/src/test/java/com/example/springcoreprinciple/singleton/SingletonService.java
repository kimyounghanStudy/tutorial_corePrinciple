package com.example.springcoreprinciple.singleton;

public class SingletonService {



    private  static  final SingletonService instance = new SingletonService();
    //자기자신을 선언 .. 내부에 ... 스태틱으로 가지고 있어 이렇게 하면 스태틱레벨에 올라가기 때문에 하나만 가지고 있음 ...


    //요렇게하면 .. 자바가 뜰때 .. 객체생성해서 .. 인스턴스에 넣어놓고 .. 이건
    //조회할때 쓰는거야 ..

    public static SingletonService getInstance() {
        return instance;
    }

    //프라이빗 생성자를 사용해서 다른곳에서 .. 새로운 생성을 막자 ..!
    private void SingletTonService() {
    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
