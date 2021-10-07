package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

public class Handle {
    public static void main(String[] args) {

        // handle = filter + map
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next("ABC"+integer);
                })
                .subscribe(ReactorSamplesUtil.subscriber());


        Flux.generate(synchronousSink -> synchronousSink.next(ReactorSamplesUtil.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if(s.toLowerCase().equals("canada"))
                        synchronousSink.complete();
                })
                .subscribe(ReactorSamplesUtil.subscriber());


    }
}
