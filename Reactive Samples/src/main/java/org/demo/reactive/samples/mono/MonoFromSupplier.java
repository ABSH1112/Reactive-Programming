package org.demo.reactive.samples.mono;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MonoFromSupplier {
    public static void main(String[] args) {

        // use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                ReactorSamplesUtil.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        ReactorSamplesUtil.onNext()
                );


    }

    private static String getName() {
        System.out.println("Generating name..");
        return ReactorSamplesUtil.faker().name().fullName();
    }
}
