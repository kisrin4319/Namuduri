package com.spring.namuduri;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.spring.namuduri")
//프로젝트에서 Mapper를 스캔할 수 있도록 @MapperScan 어노테이션을 사용하고
//basePackages="패키지 경로:를 작성한다.
//이를 작성함으로서 프로젝트 하위
public class NamuduriApplication {

    public static void main(String[] args) {
        SpringApplication.run(NamuduriApplication.class, args);
    }

}
