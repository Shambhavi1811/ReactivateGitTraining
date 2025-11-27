package com.reactivate.trading.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 100)
        private String name;

        @Column(nullable = false, unique = true, length = 100)
        private String email;

        public Agent() {
        }

        public Agent(long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

