package fr.afpa.exercices.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.exercices.spring.bean.MyRepository;

@Component
public class MyComponent {
    
    @Autowired
    private MyRepository repository;
 
    public void showAppInfo() {
        System.out.println("Now is: "+ repository.getSystemDateTime());
        System.out.println("App Name: "+ repository.getAppName());
    }

}
