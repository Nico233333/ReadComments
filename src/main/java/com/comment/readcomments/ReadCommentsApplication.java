package com.comment.readcomments;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.comment"})
@MapperScan(basePackages = "com.comment.readcomments.repository")
public class ReadCommentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadCommentsApplication.class, args);
    }

}
