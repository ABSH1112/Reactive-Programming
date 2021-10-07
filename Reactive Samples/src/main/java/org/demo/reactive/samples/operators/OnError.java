package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnError {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                // .onErrorReturn(-1)
                //  .onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {

                })
                .subscribe(ReactorSamplesUtil.subscriber());


    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> ReactorSamplesUtil.faker().random().nextInt(100, 200));
    }
}
