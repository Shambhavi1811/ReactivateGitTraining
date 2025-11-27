package com.reactivate.trading.controller;


import com.reactivate.trading.model.Agent;
import com.reactivate.trading.repository.AgentRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@Transactional
public class AgentController {

    private final AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentRepository.findAll();
        return ResponseEntity.ok(agents);
    }

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent created = agentRepository.save(agent);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable long id) {
        if (agentRepository.existsById(id)) {
            agentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
