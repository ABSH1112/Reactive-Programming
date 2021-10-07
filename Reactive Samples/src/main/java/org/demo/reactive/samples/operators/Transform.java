package org.demo.reactive.samples.operators;

import org.demo.reactive.samples.helper.Person;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Transform {

    public static void main(String[] args) {

        getPerson()
                .transform(applyFilterMap())
                .subscribe(ReactorSamplesUtil.subscriber());
    }

    public static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing : " + p));
    }

}
