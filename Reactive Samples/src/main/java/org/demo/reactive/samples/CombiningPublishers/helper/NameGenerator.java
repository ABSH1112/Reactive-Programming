package org.demo.reactive.samples.CombiningPublishers.helper;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames(){
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("generated fresh");
            ReactorSamplesUtil.sleepSeconds(1);
            String name = ReactorSamplesUtil.faker().name().firstName();
            list.add(name);
            stringSynchronousSink.next(name);
        })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache(){
        return Flux.fromIterable(list);
    }

}
