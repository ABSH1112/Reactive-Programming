package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FluxNamesGenerator {

    public static List<String> getNamesFromList(int count){
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        ReactorSamplesUtil.sleepSeconds(1);
        return ReactorSamplesUtil.faker().name().fullName();
    }
}
