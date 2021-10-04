package org.demo.reactive.samples.flux;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;

import java.util.List;

public class FluxVsList {

    public static void main(String[] args) {
        List<String> names = FluxNamesGenerator.getNamesFromList(5);
        System.out.println(names);

        FluxNamesGenerator.getNames(5)
                .subscribe(ReactorSamplesUtil.onNext());
    }
}
