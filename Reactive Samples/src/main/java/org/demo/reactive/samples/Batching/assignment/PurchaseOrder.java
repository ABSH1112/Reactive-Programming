package org.demo.reactive.samples.Batching.assignment;

import org.demo.reactive.samples.utils.ReactorSamplesUtil;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = ReactorSamplesUtil.faker().commerce().productName();
        this.price = Double.parseDouble(ReactorSamplesUtil.faker().commerce().price());
        this.category = ReactorSamplesUtil.faker().commerce().department();
    }

}
