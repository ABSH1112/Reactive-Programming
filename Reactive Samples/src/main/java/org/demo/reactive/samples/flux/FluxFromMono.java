package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(ReactorSamplesUtil.onNext());

        Flux.range(1, 10)
                .next() // 1
                .filter(i -> i > 3)
                .subscribe(ReactorSamplesUtil.onNext(), ReactorSamplesUtil.onError(), ReactorSamplesUtil.onComplete());
    }
}
