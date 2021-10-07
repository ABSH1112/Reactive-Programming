package org.demo.reactive.samples.Batching;

import org.demo.reactive.samples.Batching.assignment.OrderProcessor;
import org.demo.reactive.samples.Batching.assignment.OrderService;
import org.demo.reactive.samples.Batching.assignment.PurchaseOrder;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Assignment2 {

    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = new HashMap() {
            {
                put("Kids", OrderProcessor.kidsProcessing());
                put("Automotive", OrderProcessor.automotiveProcessing());
            }
        };

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)  // 2 keys
                .flatMap(gf -> map.get(gf.key()).apply(gf)) //flux
                .subscribe(ReactorSamplesUtil.subscriber());

        ReactorSamplesUtil.sleepSeconds(60);

    }


}
