package org.demo.reactive.samples.ThreadingAndSchedulers;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Parallel {

    public static void main(String[] args) {


        Flux.range(1, 10)
                .parallel(10)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                .sequential()
                .subscribe(v -> printThreadName("sub " + v));


        ReactorSamplesUtil.sleepSeconds(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
