package fr.epita.demoaop.model;

import org.springframework.stereotype.Component;


@Component
public class BadConcert implements Performance{
    @Override
    public void perform() {
        System.out.println("je riiiis ......");
        throw new RuntimeException("Arrrrrg !!!!");
    }
}
