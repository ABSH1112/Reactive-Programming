package org.demo.reactive.samples.helper;

import lombok.Data;
import lombok.ToString;
import org.demo.reactive.samples.utils.ReactorSamplesUtil;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = ReactorSamplesUtil.faker().commerce().productName();
        this.price = ReactorSamplesUtil.faker().commerce().price();
    }
}
