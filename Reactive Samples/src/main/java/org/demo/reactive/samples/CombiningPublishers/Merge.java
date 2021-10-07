package org.demo.reactive.samples.CombiningPublishers;

import org.demo.reactive.samples.CombiningPublishers.helper.AmericanAirlines;
import org.demo.reactive.samples.CombiningPublishers.helper.Emirates;
import org.demo.reactive.samples.CombiningPublishers.helper.Qatar;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

import reactor.core.publisher.Flux;

public class Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(ReactorSamplesUtil.subscriber());

        ReactorSamplesUtil.sleepSeconds(10);

    }


}
