package org.demo.reactive.samples.HotAndColdPublishers;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublish {
    public static void main(String[] args) {

        // share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish()
                .refCount(1);

        movieStream
                .subscribe(ReactorSamplesUtil.subscriber("sam"));

        ReactorSamplesUtil.sleepSeconds(5);

        movieStream
                .subscribe(ReactorSamplesUtil.subscriber("mike"));


        ReactorSamplesUtil.sleepSeconds(60);


    }

    // movie-theatre
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
