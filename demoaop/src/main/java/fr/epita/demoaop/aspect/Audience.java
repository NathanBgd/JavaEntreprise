package fr.epita.demoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Before("execution(* fr.epita.demoaop.model.Performance.perform(..))")
    void silenceCellPhones(){
        System.out.println("======== silence cell phones");
    }
}
