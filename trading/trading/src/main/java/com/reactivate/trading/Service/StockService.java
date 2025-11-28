package com.reactivate.trading.Service;

import com.reactivate.trading.Exceptions.InsufficientStockException;
import com.reactivate.trading.Exceptions.StockNotFoundException;
import com.reactivate.trading.model.Stocks;
import com.reactivate.trading.repository.StockRepository;
//import com.reactivate.trading.Service.StockService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//public class StockServiceImpl implements StockService {
    public class StockService {
    @Autowired
    private StockRepository stockRepo;
    private Stocks stock;

    @Transactional
    public Stocks buyStocks(Long id, int quantity)  {
        Stocks stock = stockRepo.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + id));

        if (stock.getAvailableStocks() < quantity) {
            throw new InsufficientStockException("Not enough stock quantity is available to buy.");
        }

        stock.setAvailableStocks(stock.getAvailableStocks() - quantity);
        return stockRepo.save(stock);
    }


    @Transactional
    public Stocks sellStocks(Long id, int quantity) {
        Stocks stock = stockRepo.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + id));

        if (stock.getAvailableStocks() + quantity > stock.getTotalStocks()) {
            throw new InsufficientStockException("You can not sell more than total capacity of stocks.");
        }

        stock.setAvailableStocks(stock.getAvailableStocks() + quantity);
        return stockRepo.save(stock);
    }




}
