package com.reactivate.trading.repository;

import com.reactivate.trading.model.Agent;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
    public interface AgentRepository extends JpaRepository<Agent, Long> {
        // That's it! No code needed!
        // JPA provides: findAll(), save(), deleteById(), findById(), etc.
    }
