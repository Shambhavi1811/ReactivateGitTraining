package com.reactivate.trading.controller;


import com.reactivate.trading.Exceptions.ErrorResponse;
import com.reactivate.trading.Exceptions.InsufficientStockException;
import com.reactivate.trading.Exceptions.StockNotFoundException;
import com.reactivate.trading.Service.StockService;
import com.reactivate.trading.model.Stocks;
import com.reactivate.trading.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins="http://172.30.1.168:4200")
@RestController
@RequestMapping("/api/stocks")
@Transactional
public class StockController {

 //   private static final Logger logger = (Logger) LoggerFactory.getLogger(StockController.class);


    private final StockRepository stockRepo;
    @Autowired
    private final StockService stockService;


    public StockController(StockRepository stockRepo, StockService stockService) {
        this.stockRepo = stockRepo;
        this.stockService = stockService;
    }


    @GetMapping
    public ResponseEntity<List<Stocks>> getAllStocks() {
        List<Stocks> stocks = stockRepo.findAll();
        return ResponseEntity.ok(stocks);
    }

    //@PatchMapping("/{id}/{quantity}/buyStocks")
    @PatchMapping("buy/{stockId}/{quantity}")
    public ResponseEntity<Stocks> buyStocks(@PathVariable Long stockId,
                                                   @PathVariable int quantity)  {
       Stocks updatedStock = stockService.buyStocks(stockId, quantity);
       return  ResponseEntity.ok(updatedStock);

    }



    @PatchMapping("sell/{stockId}/{quantity}")
    public ResponseEntity<Stocks> sellStocks(@PathVariable Long stockId,
                                             @PathVariable int quantity) {
        Stocks updatedStock = stockService.sellStocks(stockId, quantity);
        return ResponseEntity.ok(updatedStock);
    }



}




