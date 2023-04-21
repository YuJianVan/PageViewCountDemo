package com.fyj.pageviewcountdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestInjection {
    public static void main(String[] args) {
        ConfigurableApplicationContext context1= SpringApplication.run(TestInjection.class,args);
        GenericApplicationContext context=new GenericApplicationContext();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(
                context.getDefaultListableBeanFactory());
        context.registerBean("bean",Bean.class,b->{
            // 最高优先级（相当于<property name="bean2" ref="bean1" />）
            b.getPropertyValues().add("bean2",new RuntimeBeanReference("bean1"));
            // 第二优先级
            ((RootBeanDefinition) b).setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
        });
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.refresh();

    }

    static class Bean{
        MyInterface myBean;

        @Autowired @Qualifier("bean3")
        public void setBean2(MyInterface bean){
            System.out.println(bean);
            this.myBean=bean;
        }
    }

    interface MyInterface{}

    static class Bean1 implements MyInterface{};

    static class Bean2 implements MyInterface{};

    static class Bean3 implements MyInterface{};
}
