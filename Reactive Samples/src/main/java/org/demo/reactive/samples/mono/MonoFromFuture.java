package org.demo.reactive.samples.mono;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {
    public static void main(String[] args) {

        Mono.fromFuture(getName())
                .subscribe(ReactorSamplesUtil.onNext());

        ReactorSamplesUtil.sleepSeconds(1);

    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> ReactorSamplesUtil.faker().name().fullName());
    }

}
