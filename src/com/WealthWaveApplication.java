package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 应用入口类
 */
@SpringBootApplication(scanBasePackages = "com") // 扫描com包下所有组件
@EnableJpaRepositories(basePackages = "com.repository") // 指定Repository扫描路径
public class WealthWaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(WealthWaveApplication.class, args);
    }
}