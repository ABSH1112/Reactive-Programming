package org.demo.reactive.samples.Batching.helper;

import com.github.javafaker.Book;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookOrder {

    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder() {
        Book book = ReactorSamplesUtil.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(ReactorSamplesUtil.faker().commerce().price());
    }
}
