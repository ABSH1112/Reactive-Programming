package org.demo.reactive.samples.BackPressureAndOverflow;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BufferWithSize {

    public static void main(String[] args) {
        // 75% 12
        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
            for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                ReactorSamplesUtil.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer(50, o -> System.out.println("Dropped : "+ o))
                .publishOn(Schedulers.boundedElastic())

                .doOnNext(i -> {
                    ReactorSamplesUtil.sleepMillis(10);
                })
                .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(10);


    }

}
