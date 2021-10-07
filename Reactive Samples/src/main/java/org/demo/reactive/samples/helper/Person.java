package org.demo.reactive.samples.helper;

import lombok.Data;
import lombok.ToString;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

@Data
@ToString
public class Person {


    private String name;
    private int age;

    public Person() {
        this.name = ReactorSamplesUtil.faker().name().firstName();
        this.age = ReactorSamplesUtil.faker().random().nextInt(1, 30);
    }
}
