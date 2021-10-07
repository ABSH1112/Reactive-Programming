package org.demo.reactive.samples.ThreadingAndSchedulers;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .log()
                .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(60);
    }

}
