package org.demo.reactive.samples.Batching;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Group {

    public static void main(String[] args) {


        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2)  // key 0, 1
                .subscribe(gf -> process(gf, gf.key()));


        ReactorSamplesUtil.sleepSeconds(60);

    }

    private static void process(Flux<Integer> flux , int key){
        System.out.println("Called");
        flux.subscribe(i -> System.out.println("Key : " + key + ", Item : " + i));
    }


}
