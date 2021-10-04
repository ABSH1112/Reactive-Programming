package org.demo.reactive.samples.mono;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(ReactorSamplesUtil.onNext(),
                        ReactorSamplesUtil.onError(),
                        () -> {
                            System.out.println("process is done. Sending emails...");
                        });


    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            ReactorSamplesUtil.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
