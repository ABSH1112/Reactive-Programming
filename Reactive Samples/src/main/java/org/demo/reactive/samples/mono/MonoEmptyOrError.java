package org.demo.reactive.samples.mono;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {

        userRepository(20)
                .subscribe(
                        ReactorSamplesUtil.onNext(),
                        ReactorSamplesUtil.onError(),
                        ReactorSamplesUtil.onComplete()
                );

    }


    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(ReactorSamplesUtil.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null
        } else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }
}
