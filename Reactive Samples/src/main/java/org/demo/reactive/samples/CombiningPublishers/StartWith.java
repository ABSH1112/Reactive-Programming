package org.demo.reactive.samples.CombiningPublishers;

import org.demo.reactive.samples.CombiningPublishers.helper.NameGenerator;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;


public class StartWith {

    public static void main(String[] args) {


        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(ReactorSamplesUtil.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(ReactorSamplesUtil.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(ReactorSamplesUtil.subscriber("Jake"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(ReactorSamplesUtil.subscriber("Marshal"));


    }


}
