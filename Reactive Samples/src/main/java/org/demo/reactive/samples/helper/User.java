package org.demo.reactive.samples.helper;

import lombok.Data;
import lombok.ToString;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

@Data
@ToString
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = ReactorSamplesUtil.faker().name().fullName();
    }

}