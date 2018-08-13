package com.trade.rev.traderev.model;

import java.util.List;


public class BidRespone {
    private long bid_id;
    private Integer carId;
    private List<Customer> customerList;

    public long getBid_id() {
        return bid_id;
    }

    public void setBid_id(long bid_id) {
        this.bid_id = bid_id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
