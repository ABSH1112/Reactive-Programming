package org.demo.reactive.samples.Batching;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Buffer {

    public static void main(String[] args) {

        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(ReactorSamplesUtil.subscriber());

        ReactorSamplesUtil.sleepSeconds(60);

    }


    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(800))
                    .map(i -> "event"+i);
    }


}
