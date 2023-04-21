package com.fyj.pageviewcountdemo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;
@SpringBootApplication
public class TestApplicatonContext {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestApplicatonContext.class,args);
        System.out.println("发送了1条消息：");
        context.publishEvent(context.toString());

        /*System.out.println(context.getMessage("key",null, Locale.ENGLISH));
        System.out.println(context.getMessage("key",null, Locale.CHINA));*/

/*        try {
            Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
            for(Resource resource:resources){
                System.out.println(resource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("spring.redis.port"));
        System.out.println(context.getEnvironment().getProperty("server.port"));*/
    }
}
