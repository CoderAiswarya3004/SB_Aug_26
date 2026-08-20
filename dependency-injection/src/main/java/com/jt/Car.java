package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car{
    //  private Engine engine = new Engine();

    //DI
    //DI is a mechanism in which spring container inject the bean inside a class reference variable
    //In simple word Spring Container automatically assigns the address of the bean inside another class reference variable

    //1. Field Based Injection - NR
    // @Autowired
    // private Engine engine;

    //2. Setter Method Based Injection - R
    // private Engine engine;
    // @Autowired
    // public void setEngine(Engine engine){
    //     // System.out.println("parameter engine"+engine);
    //     // System.out.println("variable engine"+this.engine);

    //     this.engine =engine;
    // }

    //3.Constructor Based Injection - HR
    private Engine engine; 
    // @Autowired ---- Spring 4.3 update & SpringBoot 2.3 , if one constructor present then no need of autowired
    @Autowired //== This will given priority now to be called automatically over non-parameterized    
    public Car(@Qualifier("petrolEngine") Engine engine){
        this.engine=engine;
        System.out.println("Parameterized constructor");
    }

    public Car()
    {
        System.out.println("Non parameterized constructor");
    }
   

    public void startCar(){
        // Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is started");
    }

    public void stopCar(){
    //  Engine engine = new Engine();
     engine.startEngine();

     System.out.println("Car is stopped");   
    }
}