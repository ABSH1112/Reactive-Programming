package org.demo.reactive.samples.CombiningPublishers.helper;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirates {

    public static Flux<String> getFlights(){
        return Flux.range(1, ReactorSamplesUtil.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates " + ReactorSamplesUtil.faker().random().nextInt(100, 999))
                .filter(i -> ReactorSamplesUtil.faker().random().nextBoolean());
    }


}
