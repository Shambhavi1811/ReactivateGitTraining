package com.reactivate.trading.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stockId")
    private Long stockId;

    @Column(nullable = false, length = 100)
    private String stockName;

    @Column(nullable = false, length = 100)
    private int  totalStocks;


    @Column(nullable = false, length = 100)
    private int  availableStocks;

    @Column(nullable = false, length = 100)
    private int  price;


    public Stocks() {
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getTotalStocks() {
        return totalStocks;
    }

    public void setTotalStocks(int totalStocks) {
        this.totalStocks = totalStocks;
    }

    public int getAvailableStocks() {
        return availableStocks;
    }

    public void setAvailableStocks(int availableStocks) {
        this.availableStocks = availableStocks;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Stocks(Long stockId, String stockName, int totalStocks, int availableStocks, int price) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.totalStocks = totalStocks;
        this.availableStocks = availableStocks;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                ", totalStocks=" + totalStocks +
                ", availableStocks=" + availableStocks +
                ", price=" + price +
                '}';
    }
}
