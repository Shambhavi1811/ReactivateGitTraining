package com.reactivate.trading.repository;

import com.reactivate.trading.model.Agent;
import com.reactivate.trading.model.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface StockRepository extends JpaRepository<Stocks, Long> {
        // That's it! No code needed!
        // JPA provides: findAll(), save(), deleteById(), findById(), etc.
    }
