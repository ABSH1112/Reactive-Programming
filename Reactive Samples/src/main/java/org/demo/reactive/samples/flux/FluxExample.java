package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class FluxExample {

    public static void main(String[] args) throws Exception {
        AtomicInteger price = new AtomicInteger(200);
        Flux<Integer> flux = Flux.interval(Duration.ofSeconds(1))
                .map(value -> price.accumulateAndGet(ReactorSamplesUtil.faker().random().nextInt(-10, 10)
                        , Integer::sum));
        checkValue(flux);
    }

    private static void checkValue(Flux<Integer> values) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        values.subscribeWith(new Subscriber<Integer>() {
            Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer value) {
                System.out.println(LocalDateTime.now() + "    value:::" + value);
                if (value < 180 || value > 220) {
                    subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
            }

            @Override
            public void onComplete() {
                System.out.println("flow is completed");
                latch.countDown();

            }
        });
        latch.await();

    }
}
