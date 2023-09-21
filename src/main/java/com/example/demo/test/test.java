package com.example.demo.test;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author xiongtao
 * @date 2023--09--20
 */
@Component
@Getter
public class test {

    @Autowired
    @Qualifier("dog")
    private Animal animal=null;


    public test(@Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

}
