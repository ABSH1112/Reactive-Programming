package org.demo.reactive.samples.flux.programatically;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FluxCreate {
    public static void main(String[] args) {
        // only one instance of fluxsink
        Flux.create(fluxSink -> {
            String country;
            int counter = 0;
            do{
                country = ReactorSamplesUtil.faker().country().name();
                System.out.println("emitting : " + country);
                fluxSink.next(country);
                counter++;
            }while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled() && counter < 10);
            fluxSink.complete();
        })
                .take(3)
                .subscribe(ReactorSamplesUtil.subscriber());
    }
}
