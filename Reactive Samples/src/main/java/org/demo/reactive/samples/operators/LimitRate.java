package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

public class LimitRate {
    public static void main(String[] args) {

        Flux.range(1, 1000) // 175
                .log()
                .limitRate(100, 0) // 75%
                .subscribe(ReactorSamplesUtil.subscriber());



    }

}
