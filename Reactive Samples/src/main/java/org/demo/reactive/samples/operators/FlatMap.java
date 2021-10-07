package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.helper.OrderService;
import org.demo.reactive.samples.helper.UserService;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

public class FlatMap {
    public static void main(String[] args) {


        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // mono / flux
                // .filter(p -> p > 10)
                .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(60);


    }
}
