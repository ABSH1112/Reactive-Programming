package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
        Flux.range(3, 10)
                .log()
                .map(i -> ReactorSamplesUtil.faker().name().fullName())
                .log()
                .subscribe(
                        ReactorSamplesUtil.onNext()
                );

/*        Flux.range(1, 3)
                .log()
                .map(i -> i / (2 - i))
                .log()
                .onErrorReturn(3)
                .subscribe(
                        ReactorSamplesUtil.subscriber()
                );*/

/*        Flux<Integer> range = Flux.range(1, 10);
        range.map(i -> i * 10);
        range.subscribe( ReactorSamplesUtil.subscriber());*/
    }
}
