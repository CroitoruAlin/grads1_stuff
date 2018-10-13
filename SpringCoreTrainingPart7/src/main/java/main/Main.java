package main;

import beans.Mouse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext context=new ClassPathXmlApplicationContext("springContext/beans.xml");
        ApplicationContext context=new FileSystemXmlApplicationContext("C:\\workspace\\Training\\training_day1\\bhd_java_graduates_2018\\bhd_java_graduates_2018\\SpringCoreTrainingPart7\\src\\main\\resources\\springContext\\beans.xml");

        System.out.println(context.getBean("bateria1"));// cu prototype se genereaza de fiecare data o noua instanta
        System.out.println(context.getBean(Mouse.class).getBaterie());
        ((AbstractApplicationContext) context).registerShutdownHook();

    }
}
