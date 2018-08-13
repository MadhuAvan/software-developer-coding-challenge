package com.trade.rev.traderev.model;

import javax.persistence.*;

@Table(name="BID")
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bid_id;
    private long carId;
    private long customerId ;
    private long price ;
    private String status ;

    public long getBid_id() {
        return bid_id;
    }

    public void setBid_id(long bid_id) {
        this.bid_id = bid_id;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
