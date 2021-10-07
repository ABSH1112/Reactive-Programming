package org.demo.reactive.samples.BackPressureAndOverflow;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Demo {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            for (int i = 1; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
            }
            fluxSink.complete();
        })
            .publishOn(Schedulers.boundedElastic())
            .doOnNext(i -> {
                ReactorSamplesUtil.sleepMillis(10);
            })
            .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(60);

    }

}
