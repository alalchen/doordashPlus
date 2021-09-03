package com.mycompany.doordashPlus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }

    // 只是create table时run了一下这个main function, Tomcat启动时不会run这个
}
