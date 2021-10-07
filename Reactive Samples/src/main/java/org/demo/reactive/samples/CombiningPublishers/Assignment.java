package org.demo.reactive.samples.CombiningPublishers;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Assignment {

    public static void main(String[] args) {

        final int carPrice = 10000;
        Flux.combineLatest(monthStream(), demandStream(), (month, demand) -> {
            return (carPrice - (month * 100)) * demand;
        })
        .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(20);

    }


    private static Flux<Long> monthStream(){
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream(){
        return Flux.interval(Duration.ofSeconds(3))
                    .map(i -> ReactorSamplesUtil.faker().random().nextInt(80, 120) / 100d)
                    .startWith(1d);
    }

}
