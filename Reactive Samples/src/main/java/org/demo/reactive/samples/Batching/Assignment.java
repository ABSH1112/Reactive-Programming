package org.demo.reactive.samples.Batching;

import org.demo.reactive.samples.Batching.helper.BookOrder;
import org.demo.reactive.samples.Batching.helper.RevenueReport;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = new HashSet() {
            {
                add("Science fiction");
                add("Fantasy");
                add("Suspense/Thriller");
            }
        };

        bookStream()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .log()
                .map(list -> revenueCalculator(list))
                .subscribe(ReactorSamplesUtil.subscriber());


        ReactorSamplesUtil.sleepSeconds(60);


    }

    private static RevenueReport revenueCalculator(List<BookOrder> books) {
        Map<String, Double> map = books.stream()
                .collect(Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                ));
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }


}
