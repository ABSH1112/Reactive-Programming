package org.demo.reactive.samples.flux.programatically;

import reactor.core.publisher.Flux;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

public class FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = ReactorSamplesUtil.faker().country().name();
                    sink.next(country);
                    if(counter >= 10 || country.toLowerCase().equals("canada") )
                        sink.complete();
                    return counter + 1;
                })
                .take(4)
                .subscribe(ReactorSamplesUtil.subscriber());
    }
}
