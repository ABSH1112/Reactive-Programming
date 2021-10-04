package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class FluxCustomSubscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        ReactorSamplesUtil.sleepSeconds(3);
        atomicReference.get().request(3);
        ReactorSamplesUtil.sleepSeconds(5);
        atomicReference.get().request(3);
        ReactorSamplesUtil.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        ReactorSamplesUtil.sleepSeconds(3);
        atomicReference.get().request(4);

        ReactorSamplesUtil.sleepSeconds(3);
    }
}
