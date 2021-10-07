package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Delay {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.x", "9");

        Flux.range(1, 100)  // 32
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(60);
    }
}
