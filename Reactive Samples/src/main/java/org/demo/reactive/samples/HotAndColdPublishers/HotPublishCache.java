package org.demo.reactive.samples.HotAndColdPublishers;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;


public class HotPublishCache {
    public static void main(String[] args) {
        // share = publish().refCount(1)
        // cache = publish().replay() int.max
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(2);

        ReactorSamplesUtil.sleepSeconds(2);
        movieStream
                .subscribe(ReactorSamplesUtil.subscriber("sam"));
        ReactorSamplesUtil.sleepSeconds(10);
        System.out.println("Mike is about to join");
        movieStream
                .subscribe(ReactorSamplesUtil.subscriber("mike"));

        ReactorSamplesUtil.sleepSeconds(60);
    }

    // movie-theatre
    private static Stream<String> getMovie(){
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
