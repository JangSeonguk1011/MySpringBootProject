package com.basic.myspringboot.runner;

import com.basic.myspringboot.property.MyPropProperties;
import com.basic.myspringboot.config.CustomerVO; // CustomerVO 임포트 확인!
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyPropRunner implements ApplicationRunner {

    // 1-4) @Value 로드
    @Value("${myprop.username}")
    private String username;

    @Value("${myprop.port}")
    private int port;

    // 1-5) Properties 객체 주입
    @Autowired
    private MyPropProperties myPropProperties;

    /**
     * 1-6) Profile별 Bean 주입
     * MyEnvironment 대신 성욱님이 원래 가지고 계셨던 CustomerVO를 사용합니다.
     */
    @Autowired
    private CustomerVO customerVO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("==========================================");

        // 성욱님의 CustomerVO에 있는 getMode() 메서드를 호출합니다.
        log.info("현재 실행 모드: {}", customerVO.getMode());

        // 1-7) 로그 레벨에 따른 출력 (debug/info)
        log.debug("[@Value] 유저: {}, 포트: {}", username, port);

        log.info("[Properties 객체] 유저: {}, 포트: {}",
                myPropProperties.getUsername(),
                myPropProperties.getPort());

        // CustomerVO의 다른 정보(rate 등)도 궁금하다면 추가할 수 있습니다.
        log.info("[CustomerVO] 추가 정보 - 이율: {}", customerVO.getRate());

        log.info("==========================================");
    }
}