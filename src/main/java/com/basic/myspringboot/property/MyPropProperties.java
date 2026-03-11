package com.basic.myspringboot.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 1-5) application.properties의 설정을 저장하는 클래스
 */
@Component
@ConfigurationProperties(prefix = "myprop")
@Getter
@Setter
public class MyPropProperties {
    private String username;
    private int port;
}