package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FluxSamples {

    public static void main(String[] args) {
        sample3();
    }

    private static void sample1() {
        Flux<Object> flux = Flux.just(1, 2, 3, "a", ReactorSamplesUtil.faker().name().fullName());

        flux.subscribe(
                ReactorSamplesUtil.onNext(),
                ReactorSamplesUtil.onError(),
                ReactorSamplesUtil.onComplete());
    }

    private static void sample2() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0);

        integerFlux
                .subscribe(i -> System.out.println("Sub 1 : " + i));

        evenFlux
                .subscribe(i -> System.out.println("Sub 2 : " + i));
    }

    private static void sample3() {
        List<String> strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(ReactorSamplesUtil.onNext());
    }

    private static void sample4() {
        Integer[] arr = {2, 5, 7, 8};
        Flux.fromArray(arr)
                .subscribe(ReactorSamplesUtil.onNext());
    }
}
