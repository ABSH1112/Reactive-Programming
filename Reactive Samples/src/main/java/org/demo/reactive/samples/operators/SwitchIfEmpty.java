package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(ReactorSamplesUtil.subscriber());

    }

    // redis cache / db
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    // db // cache
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }

}
