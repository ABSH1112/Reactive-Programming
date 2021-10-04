package org.demo.reactive.samples.mono;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class MonoSamples {

    public static void main(String[] args) {
/*        sample1();
        sample2();*/
        sample3();
    }


    private static void sample1(){
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i -> System.out.println("Received : " + i));
    }

    private static void sample2(){
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);
        mono.subscribe(
                ReactorSamplesUtil.onNext(),
                ReactorSamplesUtil.onError(),
                ReactorSamplesUtil.onComplete()
        );
    }

    private static void sample3(){
        List<String> demo= Arrays.asList("11");
        Mono<List<String>> value=Mono.just(demo)
                .doOnNext(data -> System.out.println("next element : " + data))
                .filter(values->!values.isEmpty())
                .flatMap(values->Mono.error(new RuntimeException("Validation messages: " + values.toString())));

       value.flatMap(values->Mono.just("ABC"))
                .subscribe(
                        ReactorSamplesUtil.onNext(),
                        ReactorSamplesUtil.onError(),
                        ReactorSamplesUtil.onComplete());
    }
}
