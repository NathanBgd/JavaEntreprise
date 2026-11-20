package fr.epita.demoaop.model;


import org.springframework.stereotype.Component;


@Component
public class Concert implements Performance {
    @Override
    public void perform() {
        System.out.println("La la la la la la");
    }
}
