package org.demo.reactive.samples.Batching;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OverlapAndDrop {

    public static void main(String[] args) {

        eventStream()
                .buffer(3, 5)
                .subscribe(ReactorSamplesUtil.subscriber());

        ReactorSamplesUtil.sleepSeconds(60);

    }


    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event"+i);
    }


}
